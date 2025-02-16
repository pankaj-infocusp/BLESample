package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.hazard

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
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
import breon.telematics.loneworkersafetyapp.android.databinding.FragmentHazardBinding
import breon.telematics.loneworkersafetyapp.android.domain.model.HazardAssetDetail
import breon.telematics.loneworkersafetyapp.android.domain.model.OffDutyStatus
import breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails
import breon.telematics.loneworkersafetyapp.android.ui.main.activity.MyDashboardActivity
import breon.telematics.loneworkersafetyapp.android.ui.main.callback.OnAssetDetailFetchListener
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants
import breon.telematics.loneworkersafetyapp.android.utils.CurrentStatus
import breon.telematics.loneworkersafetyapp.android.utils.PrefManager
import breon.telematics.loneworkersafetyapp.android.utils.UiState
import breon.telematics.loneworkersafetyapp.android.utils.createOptionDialog
import breon.telematics.loneworkersafetyapp.android.utils.getZonedDateTimeFromDate
import breon.telematics.loneworkersafetyapp.android.utils.isLocationPermissionGranted
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.time.Duration.Companion.minutes


@AndroidEntryPoint
class HazardFragment : Fragment(), OnAssetDetailFetchListener {
    private var _binding: FragmentHazardBinding? = null
    private val binding get() = _binding

    private lateinit var viewModel: HazardViewModel
    @Inject lateinit var fusedLocationClient: FusedLocationProviderClient
    @Inject lateinit var pref: PrefManager
    private var latitude: Double = 0.0
    private var longitude: Double = 0.0
    private var username: String = ""

    private var timer: CountDownTimer?= null
    private var timerTime = 0L
    private var hazardDuration = 30.minutes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModels<HazardViewModel>().value
        (activity as? MyDashboardActivity)?.setHazardStateListener(this)
    }

    override fun onAssetDetailsFetched(assetDetails: AssetDetails) {
        val status = CurrentStatus.from(assetDetails.status)
        handleUi(status)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHazardBinding.inflate(inflater, container, false)
        val prefStatus = pref.getString(AppConstants.CURRENT_STATUS)
        val status = CurrentStatus.from(prefStatus)
        username = pref.getString(AppConstants.LOGGED_IN_USERNAME)
        handleUi(status)
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

    override fun onResume() {
        super.onResume()
        initClickEvent()
        val assetId = pref.getString(AppConstants.ASSETS_ID)
        viewModel.getAssetDetails(assetId, false)
    }

    private fun handleUi(status: CurrentStatus) {
        when (status) {
            CurrentStatus.Normal -> {
                binding?.run {
                    viewModel.isHazardStarted = false
                    hazardContent.isVisible = true
                    viewModel.isHazardStarted = false
                    hazardDisableLayout.unavailableContent.isVisible = false
                    offDutyLayout.offDutyContent.isVisible = false
                    tvText1.text =
                        getString(R.string.name_status).format(username.uppercase(), "(NORMAL)")
                    binding?.tvText1?.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
                    btnHazard.text = getString(R.string.start_hazard)
                }
            }

            CurrentStatus.Assist -> {
                binding?.run {
                    viewModel.isHazardStarted = false
                    hazardContent.isVisible = true
                    viewModel.isHazardStarted = false
                    hazardDisableLayout.unavailableContent.isVisible = false
                    offDutyLayout.offDutyContent.isVisible = false
                    tvText1.text =
                        getString(R.string.name_status).format(username.uppercase(), "(ASSIST)")
                    binding?.tvText1?.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
                    btnHazard.text = getString(R.string.start_hazard)
                }
            }

            CurrentStatus.Hazard -> {
                binding?.run {
                    viewModel.isHazardStarted = true
                    hazardContent.isVisible = true
                    val hazardTime = pref.getLong(AppConstants.HAZARD_SELECTED_TIME)
                    binding?.timerView?.isVisible = hazardTime > 0
                    binding?.edtMinutes?.isEnabled = hazardTime <= 0
                    binding?.edtNotes?.isEnabled = hazardTime <= 0
                    hazardDisableLayout.unavailableContent.isVisible = false
                    offDutyLayout.offDutyContent.isVisible = false
                    binding?.tvText1?.text = getString(R.string.name_status).format(username.uppercase(), "(HAZARD)")
                    binding?.tvText1?.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
                }
            }

            CurrentStatus.SOS -> {
                binding?.run {
                    hazardContent.isVisible = false
                    viewModel.isHazardStarted = false
                    hazardDisableLayout.unavailableContent.isVisible = true
                    offDutyLayout.offDutyContent.isVisible = false
                    hazardDisableLayout.tvDescription.text = getString(R.string.current_state).format("SOS")
                    hazardDisableLayout.tvUnAvailable.text = getString(R.string.hazard_unavailable)
                    binding?.tvText1?.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
                }
            }

            CurrentStatus.Safety -> {
                binding?.run {
                    viewModel.isHazardStarted = false
                    hazardContent.isVisible = true
                    hazardDisableLayout.unavailableContent.isVisible = false
                    offDutyLayout.offDutyContent.isVisible = false
                    timerView.isVisible = false
                    val username = pref.getString(AppConstants.LOGGED_IN_USERNAME)
                    tvText1.text =
                        getString(R.string.name_status).format(username.uppercase(), "(SAFETY)")
                    tvText1.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
                    btnHazard.text = getString(R.string.start_hazard)
                }
            }

            CurrentStatus.NotMonitoring -> {
                pref.putString(AppConstants.CURRENT_STATUS, status.value)
                EventBus.getDefault().post(status)
            }

            CurrentStatus.OffDuty -> {
                binding?.run {
                    hazardContent.isVisible = false
                    hazardDisableLayout.unavailableContent.isVisible = false
                    offDutyLayout.offDutyContent.isVisible = true
                    offDutyLayout.tvUnAvailable.text = getString(R.string.hazard_unavailable)
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
                                    binding?.btnHazard?.visibility = View.INVISIBLE
                                    binding?.circularLoader?.visibility = View.VISIBLE
                                } else {
                                    binding?.btnHazard?.visibility = View.VISIBLE
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
                            val hazardTime = assetDetails.hazardTimer.toInt()
                            binding?.btnHazard?.text = if (hazardTime > 0) {
                                viewModel.isHazardStarted = true
                                getString(R.string.cancel_hazard)
                            }
                            else {
                                viewModel.isHazardStarted = false
                                timer?.cancel()
                                binding?.timerView?.isVisible = false
                                binding?.etMain1?.setText("")
                                getString(R.string.start_hazard)
                            }
                            pref.putLong(AppConstants.HAZARD_SELECTED_TIME, hazardTime.minutes.inWholeMilliseconds)
                            pref.putString(AppConstants.CURRENT_STATUS, status.value)
                            if (hazardTime > 0) {
                                setupLastCheckInTime(hazardTime, assetDetails.hazardTimerStartedTime)
                            } else {
                                binding?.edtNotes?.isEnabled = true
                                binding?.edtMinutes?.isEnabled = true
                            }
                            handleUi(status)
                        }
                    }
                }
            }
        }
    }

    private fun setupLastCheckInTime(hazardTime: Int, lastCheckInTime: String) {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        //Convert UTC time zone to system's default time zone
        val convertedDateTime = getZonedDateTimeFromDate(lastCheckInTime, formatter)

        // Get the current local date and time
        val current = ZonedDateTime.now(ZoneId.systemDefault())

        if (current != null && convertedDateTime != null) {
            // Parse the string dates to LocalDateTime
            val utcFormattedDate = convertedDateTime.format(formatter)
            val currentFormattedDate = current.format(formatter)

            val dateUtc = LocalDateTime.parse(utcFormattedDate, formatter)
            val dateCurrent = LocalDateTime.parse(currentFormattedDate, formatter)

            // Calculate the duration between local time and UTC time
            val duration = Duration.between(dateUtc, dateCurrent)

            // Get the difference in milliseconds
            val durationMilli = duration.toMillis()
            val differenceInMilliseconds = hazardTime.minutes.inWholeMilliseconds - durationMilli
            if (differenceInMilliseconds > 0) {
                timer?.cancel()
                timerTime = differenceInMilliseconds
                binding?.edtNotes?.isEnabled = false
                binding?.edtMinutes?.isEnabled = false
                startTimer()
            }
        }
    }

    private fun initClickEvent() {
        binding?.etMain?.setOnClickListener {
            val options = arrayOf("30 Minutes", "60 Minutes", "90 Minutes", "120 Minutes")
            createOptionDialog(
                context = requireContext(),
                title = getString(R.string.choose_option),
                options = options,
                onOptionSelected = { option, pos ->
                    binding?.edtMinutes?.hint = option
                    when(pos) {
                        0 -> hazardDuration = 30.minutes
                        1 -> hazardDuration = 60.minutes
                        2 -> hazardDuration = 90.minutes
                        3 -> hazardDuration = 120.minutes
                        else -> { hazardDuration }
                    }
                }
            )
        }

        binding?.btnHazard?.setOnClickListener {
            val action = if (viewModel.isHazardStarted) {
                hazardDuration = 0.minutes
                binding?.etMain1?.text?.clear() // Clear notes
                AppConstants.ACTION_CANCEL_HAZARD
            } else {
                AppConstants.ACTION_HAZARD
            }

            pref.putLong(AppConstants.HAZARD_SELECTED_TIME, hazardDuration.inWholeMilliseconds)
            callWebServiceApi(action)
        }

        binding?.offDutyLayout?.btnSignOn?.setOnClickListener {
            EventBus.getDefault().post(OffDutyStatus("OffDuty"))
        }
    }

    private fun callWebServiceApi(action: String) {
        val note = if (action == AppConstants.ACTION_CANCEL_HAZARD) "" else {
            binding?.etMain1?.text?.toString().orEmpty()
        }
        viewModel.performHazardOperation(
            username = username,
            note = note,
            latitude = latitude,
            longitude = longitude,
            action = action,
            duration = hazardDuration.inWholeMinutes
        )
    }

    @SuppressLint("MissingPermission")
    private fun getLastLocation() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                latitude = location?.latitude ?: 0.0
                longitude = location?.longitude ?: 0.0
            }
    }

    private fun startTimer() {
        timer = object : CountDownTimer(timerTime, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val min = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                val sec = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60
                val time = String.format("%s minutes, %s seconds", min, sec)
                binding?.tvSecond?.text = time
            }

            override fun onFinish() {
                binding?.run {
                    edtMinutes.isVisible = true
                    edtNotes.isEnabled = true
                    timerView.isVisible = false
                    edtNotes.editText?.setText("")
                    btnHazard.text = getString(R.string.start_hazard)
                    tvText1.text = getString(R.string.name_status).format(username.uppercase(), "(NORMAL)")
                }
            }
        }.start()
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    fun onEvent(time: HazardAssetDetail) {
        Log.d("Hazard", "onEvent time: ${time.time}")
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    fun onTimerCompleted(isComplete: Boolean) {
        Log.d("Hazard", "onEvent isComplete: $isComplete")
    }

    override fun onStart() {
        super.onStart()
        timer?.start()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        timer?.cancel()
        EventBus.getDefault().unregister(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}