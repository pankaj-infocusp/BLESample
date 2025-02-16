package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.checkin

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
import breon.telematics.loneworkersafetyapp.android.databinding.FragmentCheckInBinding
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
import breon.telematics.loneworkersafetyapp.android.utils.getDueTimeInUTCFormat
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
class CheckInFragment : Fragment(), OnAssetDetailFetchListener {
    private var _binding: FragmentCheckInBinding? = null
    private val binding get() = _binding
    private lateinit var viewModel: CheckInViewModel

    @Inject lateinit var pref: PrefManager
    @Inject lateinit var fusedLocationClient: FusedLocationProviderClient

    private var timer: CountDownTimer?= null
    private var latitude: Double = 0.0
    private var longitude: Double = 0.0
    private var timerTime: Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModels<CheckInViewModel>().value
        (activity as? MyDashboardActivity)?.setCheckInStateListener(this)
    }

    override fun onAssetDetailsFetched(assetDetails: AssetDetails) {
        val status = CurrentStatus.from(assetDetails.status)
        calculateCheckInTime(assetDetails.safetyTimer.toInt(),assetDetails.lastCheckIn)
        handleUi(status)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCheckInBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefStatus = pref.getString(AppConstants.CURRENT_STATUS)
        val status = CurrentStatus.from(prefStatus)
        handleUi(status)
        observeState()
        initClickEvent()
        if (requireContext().isLocationPermissionGranted()) {
            getLastLocation()
        }
        val assetId = pref.getString(AppConstants.ASSETS_ID)
        viewModel.getAssetDetails(assetId, false)
    }

    private fun handleUi(status: CurrentStatus) {
        when (status) {
            CurrentStatus.Assist -> {
                binding?.run {
                    checkinContent.isVisible = false
                    checkInDisableLayout.unavailableContent.isVisible = true
                    offDutyLayout.offDutyContent.isVisible = false
                    checkInDisableLayout.tvDescription.text =
                        getString(R.string.current_state).format("Assist")
                    checkInDisableLayout.tvUnAvailable.text =
                        getString(R.string.check_in_unavailable)
                }
            }

            CurrentStatus.Hazard -> {
                binding?.run {
                    checkinContent.isVisible = false
                    checkInDisableLayout.unavailableContent.isVisible = true
                    offDutyLayout.offDutyContent.isVisible = false
                    checkInDisableLayout.tvDescription.text =
                        getString(R.string.current_state).format("Hazard")
                    checkInDisableLayout.tvUnAvailable.text =
                        getString(R.string.check_in_unavailable)
                }
            }

            CurrentStatus.SOS -> {
                binding?.run {
                    checkinContent.isVisible = false
                    checkInDisableLayout.unavailableContent.isVisible = true
                    offDutyLayout.offDutyContent.isVisible = false
                    checkInDisableLayout.tvDescription.text =
                        getString(R.string.current_state).format("SOS")
                    checkInDisableLayout.tvUnAvailable.text =
                        getString(R.string.check_in_unavailable)
                }
            }

            CurrentStatus.Normal -> {
                binding?.run {
                    checkinContent.isVisible = true
                    checkInDisableLayout.unavailableContent.isVisible = false
                    offDutyLayout.offDutyContent.isVisible = false
                    val safetyTime = pref.getLong(AppConstants.SAFETY_TIMER)
                    clTimerContainer.isVisible = safetyTime > 0L
                    val userName = pref.getString(AppConstants.LOGGED_IN_USERNAME).uppercase()
                    val assetName = getString(R.string.check_in_asset_name).format(userName)
                    binding?.tvAssetName?.text = assetName
                    tvAssetName.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
                }
            }

            CurrentStatus.Safety -> {
                binding?.run {
                    checkinContent.isVisible = true
                    clTimerContainer.isVisible = false
                    checkInDisableLayout.unavailableContent.isVisible = false
                    offDutyLayout.offDutyContent.isVisible = false
                    val username = pref.getString(AppConstants.LOGGED_IN_USERNAME)
                    tvAssetName.text =
                        getString(R.string.name_status).format(username.uppercase(), "(SAFETY)")
                    tvAssetName.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
                }
            }

            CurrentStatus.NotMonitoring -> {
                pref.putString(AppConstants.CURRENT_STATUS, status.value)
                EventBus.getDefault().post(status)
                binding?.tvAssetName?.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            }

            CurrentStatus.OffDuty -> {
                binding?.run {
                    checkinContent.isVisible = false
                    checkInDisableLayout.unavailableContent.isVisible = false
                    offDutyLayout.offDutyContent.isVisible = true
                    checkInDisableLayout.tvUnAvailable.text = getString(R.string.check_in_unavailable)
                }
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
                                    binding?.btnCheckIn?.visibility = View.INVISIBLE
                                    binding?.circularLoader?.visibility = View.VISIBLE
                                } else {
                                    binding?.btnCheckIn?.visibility = View.VISIBLE
                                    binding?.circularLoader?.visibility = View.INVISIBLE
                                    binding?.etMain?.setText("")
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
                            val safetyTime = assetDetails.safetyTimer.toInt()
                            pref.putString(AppConstants.CURRENT_STATUS, status.value)
                            pref.putLong(AppConstants.SAFETY_TIMER, safetyTime.minutes.inWholeMilliseconds)
                            pref.putString(AppConstants.LAST_CHECK_IN_TIME, assetDetails.lastCheckIn)
                            setupLastCheckInTime(assetDetails.safetyTimer.toInt(), assetDetails.lastCheckIn)
                            calculateCheckInTime(safetyTime, assetDetails.lastCheckIn)
                            handleUi(status)
                        }
                    }
                }
            }
        }
    }

    private fun setupLastCheckInTime(safetyTime: Int, lastCheckInTime: String) {
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
            val differenceInMilliseconds = safetyTime.minutes.inWholeMilliseconds - durationMilli
            if (differenceInMilliseconds > 0) {
                timer?.cancel()
                timerTime = differenceInMilliseconds
                startTimer()
            }
        }
        binding?.clTimerContainer?.isVisible = safetyTime > 0
    }

    private fun calculateCheckInTime(safetyTime: Int, lastCheckInTime: String) {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        //Convert UTC time zone to system's default time zone
        val convertedDateTime = getZonedDateTimeFromDate(lastCheckInTime, formatter)

        //Convert Zoned time into String format
        val utcFormattedDate = convertedDateTime?.format(formatter)

        if (utcFormattedDate != null) {
            val dateUtc = LocalDateTime.parse(utcFormattedDate, formatter)
            setCheckInDescription(dateUtc, safetyTime.toLong())
        }
    }

    private fun initClickEvent() {
        binding?.btnCheckIn?.setOnClickListener {
            callWebServiceApi()
        }

        binding?.offDutyLayout?.btnSignOn?.setOnClickListener {
            EventBus.getDefault().post(OffDutyStatus("OffDuty"))
        }
    }

    private fun setCheckInDescription(date: LocalDateTime, plusTime: Long) {
        val futureDate = date.plusMinutes(plusTime)
        val dateFormat = DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy hh:mm a")
        val formattedTime = futureDate.format(dateFormat)

        val text = getString(R.string.check_in_desc).format(formattedTime)
        binding?.tvText?.text = text
    }

    private fun callWebServiceApi() {
        val safetyTime = pref.getLong(AppConstants.SAFETY_TIMER)
        val username = pref.getString(AppConstants.LOGGED_IN_USERNAME)
        val note = binding?.etMain?.text?.toString().orEmpty()
        val formattedDate = getCurrentDateTimeInUTCFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")

        val duration = if (safetyTime == 0L) 0 else safetyTime/60000
        val date = getCurrentUtcDate()
        val time = getCurrentUtcTime()
        val message = "$username,android,Checkin,$duration,$latitude,$longitude,0,0,$date,$time,$note,0"

        val dueAt = getDueTimeInUTCFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", safetyTime)

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
                dueAt = dueAt,
                followupCheckInAfterCancellation = "string"
            )
        viewModel.deviceWebService(deviceWebServiceRequest)
    }

    private fun startTimer() {
        timer = object : CountDownTimer(timerTime, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                updateTextUI(millisUntilFinished)
            }

            override fun onFinish() {
                val time = String.format("%s minutes, %s seconds", 0, 0)
                binding?.tvSecond?.text = time
            }
        }.start()

    }


    private fun updateTextUI(millisUntilFinished: Long) {
        val min = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
        val sec = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60
        val time = String.format("%s minutes, %s seconds", min, sec)
        binding?.tvSecond?.text = time
    }

    @SuppressLint("MissingPermission")
    private fun getLastLocation() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                latitude = location?.latitude ?: 0.0
                longitude = location?.longitude ?: 0.0
                Log.d("LatLng", "addOnSuccessListener: $latitude ==> $longitude")
            }
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    fun onTimerCompleted(isComplete: Boolean) {
        binding?.clTimerContainer?.isVisible = !isComplete
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
