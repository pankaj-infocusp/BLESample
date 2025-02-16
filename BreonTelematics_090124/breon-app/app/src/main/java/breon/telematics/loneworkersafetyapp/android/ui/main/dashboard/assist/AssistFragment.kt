package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.assist

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
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
import breon.telematics.loneworkersafetyapp.android.databinding.FragmentAssistantBinding
import breon.telematics.loneworkersafetyapp.android.domain.model.OffDutyStatus
import breon.telematics.loneworkersafetyapp.android.domain.model.request.DeviceWebServiceSmartphoneRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails
import breon.telematics.loneworkersafetyapp.android.ui.main.activity.MyDashboardActivity
import breon.telematics.loneworkersafetyapp.android.ui.main.callback.OnAssetDetailFetchListener
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants.ACTION_ASSIST
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants.ACTION_CANCEL_ASSIST
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
import kotlin.time.Duration.Companion.minutes

@AndroidEntryPoint
class AssistFragment : Fragment(), OnAssetDetailFetchListener {

    private var _binding: FragmentAssistantBinding? = null
    private val binding get() = _binding
    private lateinit var viewModel: AssistsViewModel

    @Inject
    lateinit var fusedLocationClient: FusedLocationProviderClient
    private var latitude: Double = 0.0
    private var longitude: Double = 0.0

    @Inject
    lateinit var pref: PrefManager
    private var username: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModels<AssistsViewModel>().value
        (activity as? MyDashboardActivity)?.setAssistStateListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentAssistantBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        username = pref.getString(AppConstants.LOGGED_IN_USERNAME)
        handleUi()
        observeState()
        initClickEvent()
        if (requireContext().isLocationPermissionGranted()) {
            getLastLocation()
        }
    }

    override fun onResume() {
        super.onResume()
        handleUi()
    }

    private fun handleUi() {
        val state = pref.getString(AppConstants.CURRENT_STATUS)
        Log.d("hahahaahaha", "handleUi aasist: $state")
        when (state) {
            CurrentStatus.Normal.value -> {
                viewModel.isAssisted = false
                pref.putString(AppConstants.CURRENT_STATUS, CurrentStatus.Normal.value)
                binding?.run {
                    assistContent.isVisible = true
                    assistDisableLayout.unavailableContent.isVisible = false
                    offDutyLayout.offDutyContent.isVisible = false
                    etEditText.editText?.isEnabled = true
                    btnRequestAssistance.text = getString(R.string.request_assistance)
                    tvNameStatus.text =
                        getString(R.string.name_status).format(username.uppercase(), "(NORMAL)")
                    tvNameStatus.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.colorPrimary
                        )
                    )
                }
            }

            CurrentStatus.Assist.value -> {
                binding?.run {
                    assistContent.isVisible = true
                    viewModel.isAssisted = true
                    assistDisableLayout.unavailableContent.isVisible = false
                    offDutyLayout.offDutyContent.isVisible = false
                    binding?.etEditText?.editText?.isEnabled = false
                    binding?.btnRequestAssistance?.text = getString(R.string.cancel_assist_req)
                    binding?.tvNameStatus?.text =
                        getString(R.string.name_status).format(username.uppercase(), "(ASSIST)")
                    tvNameStatus.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.colorPrimary
                        )
                    )
                }
            }

            CurrentStatus.Hazard.value -> {
                binding?.run {
                    assistContent.isVisible = false
                    assistDisableLayout.unavailableContent.isVisible = true
                    offDutyLayout.offDutyContent.isVisible = false
                    assistDisableLayout.tvDescription.text =
                        getString(R.string.current_state).format("Hazard")
                    assistDisableLayout.tvUnAvailable.text = getString(R.string.assist_unavailable)
                    tvNameStatus.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.colorPrimary
                        )
                    )
                }
            }

            CurrentStatus.SOS.value -> {
                binding?.run {
                    assistContent.isVisible = false
                    assistDisableLayout.unavailableContent.isVisible = true
                    offDutyLayout.offDutyContent.isVisible = false
                    offDutyLayout.offDutyContent.isVisible = false
                    assistDisableLayout.tvDescription.text =
                        getString(R.string.current_state).format("SOS")
                    assistDisableLayout.tvUnAvailable.text = getString(R.string.assist_unavailable)
                    tvNameStatus.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.colorPrimary
                        )
                    )
                }
            }

            CurrentStatus.Safety.value -> {
                binding?.run {
                    assistContent.isVisible = true
                    assistDisableLayout.unavailableContent.isVisible = false
                    tvNameStatus.text =
                        getString(R.string.name_status).format(username.uppercase(), "(SAFETY)")
                    tvNameStatus.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
                }
            }

            CurrentStatus.NotMonitoring.value -> {
                pref.putString(AppConstants.CURRENT_STATUS, state)
                EventBus.getDefault().post(CurrentStatus.from(state))
            }

            CurrentStatus.OffDuty.value -> {
                binding?.run {
                    assistContent.isVisible = false
                    assistDisableLayout.unavailableContent.isVisible = false
                    offDutyLayout.offDutyContent.isVisible = true
                    offDutyLayout.tvUnAvailable.text = getString(R.string.assist_unavailable)
                }
            }

        }
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.uiState.collect { uiState ->
                        when (uiState) {
                            is UiState.Loading -> {
                                if (uiState.isLoading) {
                                    binding?.btnRequestAssistance?.visibility = View.INVISIBLE
                                    binding?.circularLoader?.visibility = View.VISIBLE
                                } else {
                                    binding?.btnRequestAssistance?.visibility = View.VISIBLE
                                    binding?.circularLoader?.visibility = View.INVISIBLE
                                }
                            }

                            else -> {}
                        }
                    }
                }

                launch {
                    viewModel.assetDetailState.collect { details ->
                        handleAssetDetails(details)
                        binding?.tvNameStatus?.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.colorPrimary
                            )
                        )
                    }
                }
            }
        }

        viewModel.deviceWebService.observe(viewLifecycleOwner) { isSuccess ->
            isSuccess?.let {
                val assetId = pref.getString(AppConstants.ASSETS_ID)
                viewModel.getAssetDetails(assetId)
            }
        }
    }

    private fun initClickEvent() {
        binding?.btnRequestAssistance?.setOnClickListener {
            val action = if (viewModel.isAssisted) {
                ACTION_CANCEL_ASSIST
            } else ACTION_ASSIST

            callWebServiceApi(action)
        }

        binding?.offDutyLayout?.btnSignOn?.setOnClickListener {
            EventBus.getDefault().post(OffDutyStatus("OffDuty"))
        }
    }

    private fun handleAssetDetails(details: AssetDetails?) {
        details?.let {
            val status = CurrentStatus.from(it.status)
            if (status == CurrentStatus.Assist) {
                viewModel.isAssisted = true
                pref.putString(AppConstants.CURRENT_STATUS, CurrentStatus.Assist.value)
                binding?.etEditText?.editText?.isEnabled = false
                binding?.btnRequestAssistance?.text = getString(R.string.cancel_assist_req)
                binding?.tvNameStatus?.text =
                    getString(R.string.name_status).format(username.uppercase(), "(ASSIST)")
            } else {
                viewModel.isAssisted = false
                pref.putString(AppConstants.CURRENT_STATUS, CurrentStatus.Normal.value)
                pref.putLong(
                    AppConstants.SAFETY_TIMER,
                    details.safetyTimer.toInt().minutes.inWholeMilliseconds
                )
                binding?.etEditText?.editText?.isEnabled = true
                binding?.etEditText?.editText?.setText("")
                binding?.btnRequestAssistance?.text = getString(R.string.request_assistance)
                binding?.tvNameStatus?.text =
                    getString(R.string.name_status).format(username.uppercase(), "(NORMAL)")
            }
        }
    }

    private fun callWebServiceApi(action: String) {
        val note = if (action == ACTION_CANCEL_ASSIST) {
            ""
        } else binding?.etMain?.text?.toString().orEmpty()
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

    override fun onAssetDetailsFetched(assetDetails: AssetDetails) {
        handleUi()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}