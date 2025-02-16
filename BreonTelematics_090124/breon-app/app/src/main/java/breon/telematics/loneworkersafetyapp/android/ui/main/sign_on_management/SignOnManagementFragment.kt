package breon.telematics.loneworkersafetyapp.android.ui.main.sign_on_management

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import breon.telematics.loneworkersafetyapp.android.R
import breon.telematics.loneworkersafetyapp.android.databinding.FragmentSignOnManagementBinding
import breon.telematics.loneworkersafetyapp.android.domain.model.request.ConfirmOrUpdateDetailsRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.request.DeviceWebServiceSmartphoneRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.request.UserLoginRequest
import breon.telematics.loneworkersafetyapp.android.ui.main.activity.MyDashboardActivity
import breon.telematics.loneworkersafetyapp.android.ui.main.take2form.Take2FormActivity
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants.ACTION_SIGN_OFF
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants.ACTION_SIGN_ON
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants.IS_SIGN_IN
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants.LOGGED_IN_PASSWORD
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants.LOGGED_IN_USERNAME
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants.SIGNED_IN_PHONE
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants.SIGN_ON_USERNAME
import breon.telematics.loneworkersafetyapp.android.utils.CurrentStatus
import breon.telematics.loneworkersafetyapp.android.utils.PrefManager
import breon.telematics.loneworkersafetyapp.android.utils.UiState
import breon.telematics.loneworkersafetyapp.android.utils.createAlertDialog
import breon.telematics.loneworkersafetyapp.android.utils.getCurrentDateTimeInUTCFormat
import breon.telematics.loneworkersafetyapp.android.utils.getCurrentUtcDate
import breon.telematics.loneworkersafetyapp.android.utils.getCurrentUtcTime
import breon.telematics.loneworkersafetyapp.android.utils.permissions
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.time.Duration.Companion.minutes

@AndroidEntryPoint
class SignOnManagementFragment : Fragment() {

	private var _binding: FragmentSignOnManagementBinding? = null
	private val binding get() = _binding!!
	private val viewModel: SignOnManagementViewModel by viewModels()
	private var isSignedOn = false
	private lateinit var username: String
	private lateinit var password: String
	private lateinit var phone: String
	private lateinit var contact: String

	@Inject
	lateinit var pref: PrefManager

	@Inject
	lateinit var fusedLocationClient: FusedLocationProviderClient
	private var latitude: Double = 0.0
	private var longitude: Double = 0.0

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
	): View {
		_binding = FragmentSignOnManagementBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		getPrefData()
		observeState()
		handleUiLogic()
		initClickEvent()
		if (isLocationPermissionGranted()) getLastLocation()
	}

	private fun getPrefData() {
		isSignedOn =
			pref.getString(AppConstants.CURRENT_STATUS) != CurrentStatus.NotMonitoring.value
		username = pref.getString(LOGGED_IN_USERNAME)
		password = pref.getString(LOGGED_IN_PASSWORD)
		phone = pref.getString(AppConstants.PHONE)
		contact = pref.getString(AppConstants.CONTACT)
	}

	private fun handleUiLogic() {
		binding.etContactName.editText?.setText(contact)
		binding.etContactPhone.editText?.setText(phone)
		binding.tvAssetName.text = getString(R.string.asset_name).format(username.uppercase())

		if (isSignedOn) {
			binding.run {
				etContactName.isEnabled = false
				etContactPhone.isEnabled = false
				btnSignOn.text = getString(R.string.sign_off)
				tvDescription.text = getString(R.string.sign_off_desc)
			}
		} else {
			binding.run {
				btnSignOn.text = getString(R.string.sign_on)
				tvDescription.text = getString(R.string.sign_on_desc)
				binding.etContactName.isEnabled = true
				binding.etContactPhone.isEnabled = true
			}
		}
	}


	private fun observeState() {
		lifecycleScope.launch {
			repeatOnLifecycle(Lifecycle.State.STARTED) {
				launch {
					viewModel.uiState.collect { uiState ->
						when (uiState) {
							is UiState.Loading -> {
								if (uiState.isLoading) {
									binding.btnSignOn.visibility = View.INVISIBLE
									binding.circularLoader.visibility = View.VISIBLE
								} else {
									binding.btnSignOn.visibility = View.VISIBLE
									binding.circularLoader.visibility = View.INVISIBLE
								}
							}

							is UiState.OpenDashboardFragment -> {
								viewModel.setIdleState()
								withContext(Dispatchers.Main) {
									//Save sign in status in pref
									pref.putBoolean(IS_SIGN_IN, true)
									val username = binding.etContactName.editText?.text.toString()
									val phone = binding.etContactPhone.editText?.text.toString()
									pref.putString(SIGN_ON_USERNAME, username)
									pref.putString(SIGNED_IN_PHONE, phone)
									(activity as? MyDashboardActivity)?.startBackgroundService()
									(activity as? MyDashboardActivity)?.navigateTo(R.id.nav_dashboard)
								}
							}

							is UiState.StartNewScreen -> {
								withContext(Dispatchers.Main) {
									startNewActivity()
								}
							}

							is UiState.StartSignOnFlow -> {
								withContext(Dispatchers.Main) {
									callSignOnApis(true)
								}
							}

							else -> {}
						}
					}
				}

				launch {
					viewModel.assetDetailState.collect { assetDetails ->
						if (assetDetails != null) {
							val status = CurrentStatus.from(assetDetails.status)
							if (status == CurrentStatus.NotMonitoring || status == CurrentStatus.OffDuty) {
								isSignedOn = false
								val statusName = if (status == CurrentStatus.NotMonitoring) {
									CurrentStatus.NotMonitoring.value
								} else {
									CurrentStatus.OffDuty.value
								}
								pref.putString(AppConstants.CURRENT_STATUS, statusName)
								(activity as? MyDashboardActivity)?.stopBackgroundService()

								binding.run {
									etContactName.isEnabled = true
									etContactPhone.isEnabled = true
									btnSignOn.text = getString(R.string.sign_on)
									tvDescription.text = getString(R.string.sign_on_desc)
								}
							} else {
								isSignedOn = true
								pref.putString(
									AppConstants.CURRENT_STATUS, CurrentStatus.Normal.value
								)
								pref.putLong(
									AppConstants.SAFETY_TIMER,
									assetDetails.safetyTimer.toInt().minutes.inWholeMilliseconds
								)

								binding.run {
									etContactName.isEnabled = false
									etContactPhone.isEnabled = false
									btnSignOn.text = getString(R.string.sign_off)
									tvDescription.text = getString(R.string.sign_off_desc)
								}

								val contact = binding.etGetContactName.text?.toString().orEmpty()
								val phone = binding.etGetContactPhone.text?.toString().orEmpty()
								pref.putString(AppConstants.CONTACT, contact)
								pref.putString(AppConstants.PHONE, phone)
							}
						}
					}
				}
			}
		}
	}

	private fun startNewActivity() {
		viewModel.setIdleState()
		startActivity(
			Intent(requireActivity(), Take2FormActivity::class.java)
		)
	}

	private fun initClickEvent() {
		binding.btnSignOn.setOnClickListener {
			if (isLocationPermissionGranted()) {
				if (isSignedOn) {
					val deviceRequest = getSignOnRequest()
					viewModel.callDeviceWebApi(
						deviceRequest,
						showLoading = true,
						assetId = pref.getString(AppConstants.ASSETS_ID)
					)
				} else {
					callSignOnApis()
				}
			} else {
				requestMultiplePermissionsLauncher.launch(permissions)
			}
		}
	}

	private fun callSignOnApis(callSignOnApis: Boolean = false) {
		val assetsId = pref.getString(AppConstants.ASSETS_ID)

		if (callSignOnApis) {
			val status = pref.getString(AppConstants.CURRENT_STATUS)
			if (status == CurrentStatus.OffDuty.value) {
				showoffDutyDialog()
				return
			}

			val loginRequest = UserLoginRequest(
				UserLoginRequest.UserData(
					username = username, password = password
				)
			)

			val email = pref.getString(AppConstants.EMAIL)

			val confirmDetailsRequest = ConfirmOrUpdateDetailsRequest(
				assetId = assetsId,
				contact = binding.etGetContactName.text?.toString().orEmpty(),
				phone = binding.etGetContactPhone.text?.toString().orEmpty(),
				email = email
			)

			val deviceRequest = getSignOnRequest()
			viewModel.callSignOnApis(
				loginRequest, deviceRequest, confirmDetailsRequest, assetsId
			)
		} else {
			viewModel.getTake2FormStatus(assetsId)
		}
	}

	private fun getSignOnRequest(): DeviceWebServiceSmartphoneRequest {
		val formattedDate = getCurrentDateTimeInUTCFormat()
		val date = getCurrentUtcDate()
		val time = getCurrentUtcTime()
		val message = if (isSignedOn) {
			"$username,android,$ACTION_SIGN_OFF,0,$latitude,$longitude,0,0,$date,$time,,0"
		} else {
			"$username,android,$ACTION_SIGN_ON,0,$latitude,$longitude,0,0,$date,$time,,0"
		}
		Log.d("SmartDeviceMsg", "getSignOnRequest: $message")
		return getDeviceWebServiceRequest(formattedDate, message)
	}

	private fun getDeviceWebServiceRequest(
		formattedDate: String, message: String
	): DeviceWebServiceSmartphoneRequest {
		return DeviceWebServiceSmartphoneRequest(
			createdAt = formattedDate,
			updatedAt = formattedDate,
			createdBy = "string",
			updatedBy = "string",
			isDeleted = true,
			id = "string",
			createdOnServerAt = DeviceWebServiceSmartphoneRequest.CreatedOnServerAt(
				seconds = 0, nanoseconds = 0
			),
			updatedOnServerAt = DeviceWebServiceSmartphoneRequest.UpdatedOnServerAt(
				seconds = 0, nanoseconds = 0
			),
			docType = "string",
			type = 2,
			mode = "operations",
			message = message,
			dueAt = "2024-04-05T05:59:42.179Z",
			followupCheckInAfterCancellation = "string"
		)
	}

	private fun isLocationPermissionGranted(): Boolean {
		return permissions.all {
			ActivityCompat.checkSelfPermission(
				requireContext(), it
			) == PackageManager.PERMISSION_GRANTED
		}
	}

	private val requestMultiplePermissionsLauncher =
		registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
			val allPermissionsGranted = permissions.all { it.value }
			if (allPermissionsGranted) {
				// All permissions granted, proceed with your logic
				checkAndRequestNotificationPermission()
			} else {
				// Permission denied, handle accordingly (show explanation, disable functionality, etc.)
				showPermissionDeniedDialog()
			}
		}

	private fun checkAndRequestNotificationPermission() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
			when (ContextCompat.checkSelfPermission(
				requireContext(), android.Manifest.permission.POST_NOTIFICATIONS
			)) {
				PackageManager.PERMISSION_GRANTED -> {
					// permission already granted
					performAction()
				}

				else -> {
					notificationPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
				}
			}
		}
	}

	// we need notification permission to be able to display a notification for the foreground service
	private val notificationPermissionLauncher = registerForActivityResult(
		ActivityResultContracts.RequestPermission()
	) { isGranted ->
		if (isGranted) {
			performAction()
		} else {
			showNotificationPermissionDialog()
		}
	}

	private fun performAction() {
		getLastLocation()
		if (isSignedOn) {
			viewModel.callDeviceWebApi(
				getSignOnRequest(),
				showLoading = true,
				assetId = pref.getString(AppConstants.ASSETS_ID)
			)
		} else {
			callSignOnApis()
		}
	}

	private fun showPermissionDeniedDialog() {
		createAlertDialog(context = requireContext(),
			title = getString(R.string.permission_denied),
			message = getString(R.string.permission_desc),
			positiveBtnText = "Ok",
			negativeBtnText = "Cancel",
			onPositiveBtnClick = {
				requestMultiplePermissionsLauncher.launch(permissions)
			})
	}

	private fun showNotificationPermissionDialog() {
		createAlertDialog(context = requireContext(),
			title = getString(R.string.notification_permission_title),
			message = getString(R.string.notification_permission_desc),
			positiveBtnText = "Ok",
			negativeBtnText = "Cancel",
			onPositiveBtnClick = {
				val intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
				startActivity(intent)
			},
			onNegativeBtnClick = {
				Toast.makeText(
					requireContext(),
					"Notification permission is mandatory. Please allow it from settings.",
					Toast.LENGTH_SHORT
				).show()
			})
	}

	private fun showoffDutyDialog() {
		createAlertDialog(
			context = requireContext(),
			title = getString(R.string.off_duty_title),
			message = getString(R.string.off_duty_desc),
			positiveBtnText = "Ok",
			negativeBtnText = "Cancel"
		)
	}

	@SuppressLint("MissingPermission")
	private fun getLastLocation() {
		fusedLocationClient.lastLocation.addOnSuccessListener { location ->
			latitude = location?.latitude ?: 0.0
			longitude = location?.longitude ?: 0.0
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}