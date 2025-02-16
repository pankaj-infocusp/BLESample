package breon.telematics.loneworkersafetyapp.android.ui.login

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import breon.telematics.loneworkersafetyapp.android.R
import breon.telematics.loneworkersafetyapp.android.app.service.BackgroundLocationService
import breon.telematics.loneworkersafetyapp.android.databinding.ActivityMainBinding
import breon.telematics.loneworkersafetyapp.android.domain.model.request.UserLoginRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails
import breon.telematics.loneworkersafetyapp.android.ui.main.activity.MyDashboardActivity
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants.IS_LOGGED_IN
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants.LOGGED_IN_PASSWORD
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants.LOGGED_IN_USERNAME
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants.SIGNED_IN_PHONE
import breon.telematics.loneworkersafetyapp.android.utils.CurrentStatus
import breon.telematics.loneworkersafetyapp.android.utils.PrefManager
import breon.telematics.loneworkersafetyapp.android.utils.UiState
import breon.telematics.loneworkersafetyapp.android.utils.createAlertDialog
import breon.telematics.loneworkersafetyapp.android.utils.permissions
import breon.telematics.loneworkersafetyapp.android.utils.showToast
import com.google.firebase.installations.FirebaseInstallations
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.time.Duration.Companion.minutes


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

	private var _binding: ActivityMainBinding? = null
	private val binding get() = _binding!!

	private val viewModel: LoginViewModel by viewModels()
	private var assetDetails: AssetDetails? = null

	@Inject
	lateinit var prefManager: PrefManager
	private var templateName: String? = null
	private var isLoggedIn = false

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		_binding = DataBindingUtil.setContentView(
			this, R.layout.activity_main
		)
		isLoggedIn = prefManager.getBoolean(IS_LOGGED_IN)
		observeState()
		Log.d("IsUserLoggedIn", "onCreate: $isLoggedIn")
		if (isLoggedIn) {
			val assetId = prefManager.getString(AppConstants.ASSETS_ID)
			viewModel.startDummyLoading(assetId)
		}
		getFirebaseId();
		initToolbar()
		initClickEvent()
		observeLiveData()
	}

	private fun initToolbar() {
		binding.appToolbar.tvTitle.text = getString(
			R.string.app_name
		)
	}

	private fun observeState() {
		lifecycleScope.launch {
			repeatOnLifecycle(Lifecycle.State.STARTED) {
				launch {
					viewModel.uiState.collect { uiState ->
						Log.d("CollectionFlow", "observeState: UiState")
						when (uiState) {
							is UiState.Loading -> {
								if (uiState.isLoading) {
									binding.btnLogin.visibility = View.INVISIBLE
									binding.circularLoader.visibility = View.VISIBLE
								} else {
									binding.btnLogin.visibility = View.VISIBLE
									binding.circularLoader.visibility = View.INVISIBLE
								}
							}

							is UiState.Success<*> -> {
								if (binding.clLoadUserData.isVisible.not()) {
									binding.clLoadUserData.isVisible = true
									binding.mainContent.isVisible = false
									binding.appToolbar.root.isVisible = false
								}
								binding.tvProgress.text = uiState.data?.toString()
							}

							is UiState.StartNewScreen -> {
								withContext(Dispatchers.Main) {
									startNewActivity()
								}
							}

							else -> {}
						}
					}
				}

				launch {
					viewModel.assetDetailState.collect { assetDetails ->
						handleAssetDetails(assetDetails)
					}
				}
			}
		}
	}

	private fun observeLiveData() {
		viewModel.userLoginData.observe(this) { loggedInUser ->
			loggedInUser?.let {
				val username = binding.etUserName.editText?.text.toString()
				val password = binding.etPassword.editText?.text.toString()
				prefManager.putString(AppConstants.ASSETS_ID, it.assetId.orEmpty())
				prefManager.putString(LOGGED_IN_USERNAME, username)
				prefManager.putString(LOGGED_IN_PASSWORD, password)
				prefManager.putString(SIGNED_IN_PHONE, loggedInUser.phone.orEmpty())
				prefManager.putString(AppConstants.CONTACT, loggedInUser.contact.orEmpty())
				prefManager.putString(AppConstants.EMAIL, loggedInUser.email.orEmpty())
				prefManager.putString(AppConstants.PHONE, loggedInUser.phone.orEmpty())
				prefManager.putBoolean(IS_LOGGED_IN, true)

				templateName = loggedInUser.templateName
			}
		}
		viewModel.templatesData.observe(this) { templates ->
			if (templates != null) {
				val json = Gson().toJson(templates.templates)
				prefManager.putString(AppConstants.USER_TEMPLATES, json)
				Log.d("TemplatesData", "templatesResponse: ${templates.templates}")
				var position = 0
				templates.templates.forEachIndexed { index, it ->
					if (it.name == templateName) {
						position = index
						return@forEachIndexed
					}
				}
				prefManager.putInt(AppConstants.SELECTED_TEMP_POS, position)
				val safetyTimer = templates.templates.getOrNull(position)?.safetyTimer ?: "20"
				prefManager.putLong(
					AppConstants.SAFETY_TIMER,
					safetyTimer.toInt().minutes.inWholeMilliseconds
				)
				prefManager.putLong(
					AppConstants.TEMPLATE_TIME,
					safetyTimer.toInt().minutes.inWholeMilliseconds
				)
			}
		}

		viewModel.error.observe(this) {
			showToast(
				it.toString()
			)
		}
	}

	private fun handleAssetDetails(assetDetails: AssetDetails?) {
		if (assetDetails != null) {
			val status = CurrentStatus.from(assetDetails.status)
			prefManager.putString(AppConstants.CURRENT_STATUS, status.value)
			this.assetDetails = assetDetails
			if (isLocationEnabled(this)) {
				if (isLocationPermissionGranted() && isLoggedIn) {
					if (status != CurrentStatus.NotMonitoring && status != CurrentStatus.OffDuty) {
						startBackgroundService()
					}
					startNewActivity()
				} else {
					if (isLocationPermissionGranted().not())
						userConsentDialog()
					else requestMultiplePermissionsLauncher.launch(permissions)
				}
			} else {
				showLocationEnablingDialog()
			}
		} /*else {
            checkLocationService()
        }*/
	}

	private fun startBackgroundService() {
		startService(Intent(this, BackgroundLocationService::class.java))
	}

	private fun startNewActivity() {
		viewModel.setIdleState()
		startActivity(
			Intent(this@LoginActivity, MyDashboardActivity::class.java)
		)
		finish()
	}

	private fun initClickEvent() {
		binding.btnLogin.setOnClickListener {
			val username = binding.etUserName.editText?.text?.toString() ?: ""
			val password = binding.etPassword.editText?.text?.toString() ?: ""
			if (username.isEmpty()) {
				binding.tvApiError.visibility = View.VISIBLE
				binding.tvApiError.text = getString(R.string.empty_username)
			} else if (password.isEmpty() || password.length < 6) {
				binding.tvApiError.visibility = View.VISIBLE
				binding.tvApiError.text = getString(R.string.password_msg)
			} else {
				val userLoginRequest =
					UserLoginRequest(
						UserLoginRequest.UserData(
							username = username,
							password = password
						)
					)
				viewModel.userLogin(userLoginRequest)
			}
		}
	}

	private fun isLocationEnabled(context: Context): Boolean {
		val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
		return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
				locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
	}

	private fun isLocationPermissionGranted(): Boolean {
		return permissions.all {
			ActivityCompat.checkSelfPermission(
				this@LoginActivity,
				it
			) == PackageManager.PERMISSION_GRANTED
		}
	}

	private val requestMultiplePermissionsLauncher =
		registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
			val allPermissionsGranted = permissions.all { it.value }
			if (allPermissionsGranted) {
				checkAndRequestNotificationPermission()
			} else {
				// Permission denied, handle accordingly (show explanation, disable functionality, etc.)
				showPermissionDeniedDialog()
			}
		}

	private fun checkAndRequestNotificationPermission() {
		val savedStatus = prefManager.getString(AppConstants.CURRENT_STATUS)
		val isLoggedIn = prefManager.getBoolean(IS_LOGGED_IN)
		val status = CurrentStatus.from(savedStatus)
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
			when (ContextCompat.checkSelfPermission(
				this,
				android.Manifest.permission.POST_NOTIFICATIONS
			)) {
				PackageManager.PERMISSION_GRANTED -> {
					if (isLoggedIn) {
						if (status != CurrentStatus.NotMonitoring && status != CurrentStatus.OffDuty) {
							startBackgroundService()
						}
						startNewActivity()
					}
				}

				else -> {
					notificationPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
				}
			}
		} else {
			if (isLoggedIn) {
				if (status != CurrentStatus.NotMonitoring && status != CurrentStatus.OffDuty) {
					startBackgroundService()
				}
				startNewActivity()
			}
		}
	}

	// we need notification permission to be able to display a notification for the foreground service
	private val notificationPermissionLauncher =
		registerForActivityResult(
			ActivityResultContracts.RequestPermission()
		) { isGranted ->
			if (isGranted) {
				val savedStatus = prefManager.getString(AppConstants.CURRENT_STATUS)
				val status = CurrentStatus.from(savedStatus)
				if (status != CurrentStatus.NotMonitoring && status != CurrentStatus.OffDuty) {
					startBackgroundService()
				}
				startNewActivity()
			} else {
				showNotificationPermissionDialog()
			}
			// if permission was denied, the service can still run only the notification won't be visible
		}

	private fun showPermissionDeniedDialog() {
		createAlertDialog(
			context = this@LoginActivity,
			title = getString(R.string.permission_denied),
			message = getString(R.string.permission_desc),
			positiveBtnText = "Ok",
			negativeBtnText = "Cancel",
			onPositiveBtnClick = {
				requestMultiplePermissionsLauncher.launch(permissions)
			},
			onNegativeBtnClick = {

			}
		)
	}

	private fun showLocationEnablingDialog() {
		createAlertDialog(
			context = this@LoginActivity,
			title = getString(R.string.location_permission_title),
			message = getString(R.string.location_permission_desc),
			positiveBtnText = "Ok",
			negativeBtnText = "Cancel",
			onPositiveBtnClick = {
				val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
				startForResult.launch(intent)
			},
			onNegativeBtnClick = {
				Toast.makeText(
					this@LoginActivity,
					"Location service is mandatory to keep user safety. Please allow it from settings.",
					Toast.LENGTH_SHORT
				).show()
			}
		)
	}

	private fun userConsentDialog() {
		createAlertDialog(
			context = this@LoginActivity,
			title = getString(R.string.user_consent_title),
			message = getString(R.string.user_consent_desc),
			positiveBtnText = "Ok",
			negativeBtnText = "Cancel",
			onPositiveBtnClick = {
				requestMultiplePermissionsLauncher.launch(permissions)
			},
			onNegativeBtnClick = {
				Toast.makeText(
					this@LoginActivity,
					"Location service is mandatory to keep user safety. Please allow it from settings.",
					Toast.LENGTH_SHORT
				).show()
			}
		)
	}

	private val startForResult = registerForActivityResult(
		ActivityResultContracts.StartActivityForResult()
	) { result: ActivityResult ->
		if (isLocationEnabled(this@LoginActivity)) {
			requestMultiplePermissionsLauncher.launch(permissions)
		} else {
			showLocationEnablingDialog()
		}
	}

	private fun showNotificationPermissionDialog() {
		createAlertDialog(
			context = this@LoginActivity,
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
					this@LoginActivity,
					"Notification permission is mandatory. Please allow it from settings.",
					Toast.LENGTH_SHORT
				).show()
			}
		)
	}

	private fun getFirebaseId() {
		FirebaseInstallations.getInstance().id.addOnSuccessListener {
			val deviceId = it.toString()
			prefManager.putString(AppConstants.DEVICE_ID,deviceId)
			Log.e("TAG", "getFirebaseId: " + deviceId )
		}
	}
}