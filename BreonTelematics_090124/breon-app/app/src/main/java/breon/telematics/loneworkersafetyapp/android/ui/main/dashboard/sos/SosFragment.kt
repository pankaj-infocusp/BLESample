package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.sos

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import breon.telematics.loneworkersafetyapp.android.R
import breon.telematics.loneworkersafetyapp.android.databinding.FragmentSosBinding
import breon.telematics.loneworkersafetyapp.android.domain.model.OffDutyStatus
import breon.telematics.loneworkersafetyapp.android.domain.model.request.DeviceWebServiceSmartphoneRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails
import breon.telematics.loneworkersafetyapp.android.ui.main.activity.MyDashboardActivity
import breon.telematics.loneworkersafetyapp.android.ui.main.callback.OnAssetDetailFetchListener
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants
import breon.telematics.loneworkersafetyapp.android.utils.CurrentStatus
import breon.telematics.loneworkersafetyapp.android.utils.PrefManager
import breon.telematics.loneworkersafetyapp.android.utils.UiState
import breon.telematics.loneworkersafetyapp.android.utils.getCurrentDateTimeInUTCFormat
import breon.telematics.loneworkersafetyapp.android.utils.getCurrentUtcDate
import breon.telematics.loneworkersafetyapp.android.utils.getCurrentUtcTime
import breon.telematics.loneworkersafetyapp.android.utils.isLocationPermissionGranted
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

@AndroidEntryPoint
class SosFragment : Fragment(), OnAssetDetailFetchListener {
    private var _binding: FragmentSosBinding? = null
    private val binding get() = _binding
    private lateinit var viewModel: SosViewModel
    @Inject lateinit var fusedLocationClient: FusedLocationProviderClient
    @Inject lateinit var pref: PrefManager
    private var latitude: Double = 0.0
    private var longitude: Double = 0.0
    private var username: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModels<SosViewModel>().value
        (activity as? MyDashboardActivity)?.setSOSStateListener(this)
    }

    override fun onAssetDetailsFetched(assetDetails: AssetDetails) {
        handleUi()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSosBinding.inflate(inflater, container, false)
        username = pref.getString(AppConstants.LOGGED_IN_USERNAME)
        handleUi()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeState()
        initClickEvent()
        if (requireContext().isLocationPermissionGranted()) {
            getLastLocation()
        }
    }

    private fun handleUi() {
        val state = pref.getString(AppConstants.CURRENT_STATUS).ifEmpty { CurrentStatus.Normal.value }
        when (val currentState = CurrentStatus.from(state)) {
            CurrentStatus.Safety -> {
                binding?.offDutyLayout?.offDutyContent?.isVisible = false
                binding?.tvNameStatus?.text = getString(R.string.name_status).format(username.uppercase(), "(SAFETY)")
                binding?.tvNameStatus?.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
            }

            CurrentStatus.Hazard -> {
                binding?.offDutyLayout?.offDutyContent?.isVisible = false
                binding?.tvNameStatus?.text = getString(R.string.name_status).format(username.uppercase(), "(HAZARD)")
                binding?.tvNameStatus?.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            }

            CurrentStatus.Assist -> {
                binding?.offDutyLayout?.offDutyContent?.isVisible = false
                binding?.tvNameStatus?.text = getString(R.string.name_status).format(username.uppercase(), "(ASSIST)")
                binding?.tvNameStatus?.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            }

            CurrentStatus.Normal -> {
                binding?.tvNameStatus?.text = getString(R.string.name_status).format(username.uppercase(), "(NORMAL)")
                binding?.tvNameStatus?.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            }

            CurrentStatus.SOS -> {
                viewModel.isSosSet = true
                binding?.etMain?.isEnabled = false
                binding?.offDutyLayout?.offDutyContent?.isVisible = false
                binding?.btnSos?.text = getString(R.string.cancel_sos)
                binding?.tvNameStatus?.text = getString(R.string.name_status).format(username.uppercase(), "(SOS)")
                binding?.tvNameStatus?.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))

            }

            CurrentStatus.NotMonitoring -> {
                pref.putString(AppConstants.CURRENT_STATUS, state)
                EventBus.getDefault().post(currentState)
            }

            CurrentStatus.OffDuty -> {
                binding?.run {
                    sosContent.isVisible = false
                    offDutyLayout.offDutyContent.isVisible = true
                    offDutyLayout.tvUnAvailable.text = getString(R.string.sos_unavailable)
                }
            }
        }
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.uiState.collect { uiState ->
                        when(uiState) {
                            is UiState.Loading -> {
                                if (uiState.isLoading) {
                                    binding?.btnSos?.visibility = View.INVISIBLE
                                    binding?.circularLoader?.visibility = View.VISIBLE
                                } else {
                                    binding?.btnSos?.visibility = View.VISIBLE
                                    binding?.circularLoader?.visibility = View.INVISIBLE
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
                            if (status == CurrentStatus.SOS) {
                                pref.putString(AppConstants.CURRENT_STATUS, CurrentStatus.SOS.value)
                                binding?.etMain?.isEnabled = false
                                binding?.btnSos?.text = getString(R.string.cancel_sos)
                                binding?.tvNameStatus?.text = getString(R.string.name_status).format(username.uppercase(), "(SOS)")
                                pref.putLong(AppConstants.SAFETY_TIMER, 0L)
                                pref.putLong(AppConstants.HAZARD_SELECTED_TIME, 0L)
                            } else {
                                binding?.etMain?.isEnabled = true
                                pref.putLong(AppConstants.SAFETY_TIMER, 0L)
                                pref.putLong(AppConstants.HAZARD_SELECTED_TIME, 0L)
                                pref.putString(AppConstants.CURRENT_STATUS, CurrentStatus.Normal.value)
                                binding?.btnSos?.text = getString(R.string.sos)
                                binding?.tvNameStatus?.text = getString(R.string.name_status).format(username.uppercase(), "(NORMAL)")
                            }
                        }
                    }
                }
            }
        }

        viewModel.deviceWebService.observe(viewLifecycleOwner) { isSuccess ->
            if (isSuccess != null) {
                val assetId = pref.getString(AppConstants.ASSETS_ID)
                viewModel.getAssetDetails(assetId)
            }
        }
    }

    private fun initClickEvent() {
        binding?.btnSos?.setOnClickListener {
            val action = if (viewModel.isSosSet) {
                binding?.etMain?.text?.clear() // Clear notes
                AppConstants.ACTION_CANCEL_SOS
            } else AppConstants.ACTION_SOS

            callWebServiceApi(action)
        }

        binding?.offDutyLayout?.btnSignOn?.setOnClickListener {
            EventBus.getDefault().post(OffDutyStatus("OffDuty"))
        }
    }

    private fun callWebServiceApi(action: String) {
        val note = if (action == AppConstants.ACTION_CANCEL_SOS) "" else {
            binding?.etMain?.text?.toString().orEmpty()
        }
        val formattedDate = getCurrentDateTimeInUTCFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val date = getCurrentUtcDate()
        val time = getCurrentUtcTime()
        val message = "$username,android,$action,0,$latitude,$longitude,0,0,$date,$time,$note,0"

        val deviceWebServiceRequest =
            DeviceWebServiceSmartphoneRequest(
                createdAt = formattedDate,
                updatedAt = formattedDate,
                createdBy = "string",
                updatedBy = "string",
                isDeleted = true,
                id = "string",
                createdOnServerAt = DeviceWebServiceSmartphoneRequest.CreatedOnServerAt(
                    seconds = 0,
                    nanoseconds = 0
                ),
                updatedOnServerAt = DeviceWebServiceSmartphoneRequest.UpdatedOnServerAt(
                    seconds = 0,
                    nanoseconds = 0
                ),
                docType = "string",
                type = 2,
                mode = "operations",
                message = message,
                dueAt = "2024-04-05T05:59:42.179Z",
                followupCheckInAfterCancellation = "string"
            )

        viewModel.deviceWebService(deviceWebServiceRequest)
    }

    @SuppressLint("MissingPermission")
    private fun getLastLocation() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                latitude = location?.latitude ?: 0.0
                longitude = location?.longitude ?: 0.0
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}