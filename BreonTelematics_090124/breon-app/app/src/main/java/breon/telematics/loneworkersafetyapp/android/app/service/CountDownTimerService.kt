package breon.telematics.loneworkersafetyapp.android.app.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.CountDownTimer
import android.os.IBinder
import android.util.Log
import breon.telematics.loneworkersafetyapp.android.R
import breon.telematics.loneworkersafetyapp.android.domain.model.CheckInAssetDetail
import breon.telematics.loneworkersafetyapp.android.domain.model.HazardAssetDetail
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants
import breon.telematics.loneworkersafetyapp.android.utils.CurrentStatus
import breon.telematics.loneworkersafetyapp.android.utils.PrefManager
import dagger.hilt.android.AndroidEntryPoint
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

@AndroidEntryPoint
class CountDownTimerService : Service() {

    private val binder = LocalBinder()
    private var countDownTimer: CountDownTimer? = null
    private var duration: Long = 3.seconds.inWholeMilliseconds
    @Inject
    lateinit var pref: PrefManager

    inner class LocalBinder : Binder() {
        fun getService(): CountDownTimerService = this@CountDownTimerService
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val status = pref.getString(AppConstants.CURRENT_STATUS)
        duration = when (status) {
            CurrentStatus.Normal.value -> {
                pref.getLong(AppConstants.SAFETY_TIMER)
            }

            CurrentStatus.Hazard.value -> {
                val time = pref.getLong(AppConstants.HAZARD_SELECTED_TIME)
                if (time == 0L) 30.minutes.inWholeMilliseconds else time
            }

            else -> {
                0L
            }
        }
        Log.d("CountDownService", "onStartCommand: $duration")
        setupTimer()
        return START_STICKY
    }

    private fun setupTimer() {
        countDownTimer?.cancel() // Cancel any existing timer

        countDownTimer = object : CountDownTimer(duration, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minute = (millisUntilFinished / 1000) / 60
                val seconds = (millisUntilFinished / 1000) % 60
                val time = getString(R.string.count_down_timer)
                    .format("$minute", "$seconds")
                Log.d("TimerTime", "Time: $time")
                val status = pref.getString(AppConstants.CURRENT_STATUS)
                if (status == CurrentStatus.Normal.value) {
                    EventBus.getDefault().post(
                        CheckInAssetDetail(
                            time = time
                        )
                    )
                } else if (status == CurrentStatus.Hazard.value) {
                    EventBus.getDefault().post(
                        HazardAssetDetail(
                            time = time
                        )
                    )
                }
            }

            override fun onFinish() {
                Log.d("CountDownService", "onFinish: ")
                EventBus.getDefault().post(true)
                stopSelf()
            }
        }.start()
    }

    fun setTimerTime(duration: Long) {
        this.duration = duration
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CountDownService", "onDestroy: ")
        countDownTimer?.cancel()
    }
}