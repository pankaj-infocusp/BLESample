package breon.telematics.loneworkersafetyapp.android.app

import android.app.Activity
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Bundle
import android.util.Log
import breon.telematics.loneworkersafetyapp.android.app.service.BackgroundLocationService
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application(), Application.ActivityLifecycleCallbacks {

    private var isAppInForeground = false

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        registerActivityLifecycleCallbacks(this)
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            BackgroundLocationService.NOTIFICATION_CHANNEL_ID,
            "Foreground Service Channel",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        val manager = getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(channel)
    }

    companion object {
        private var INSTANCE: MyApplication? = null
        private fun getMyApplication(): MyApplication {
            return INSTANCE ?: synchronized(this) {
                val instance = MyApplication()
                INSTANCE = instance
                instance
            }
        }

        fun isAppInForeground(): Boolean {
            Log.d("MyApplicationTag", "isAppInForeground: ")
            return getMyApplication().isAppInForeground
        }
    }

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {}

    override fun onActivityStarted(p0: Activity) {}

    override fun onActivityResumed(p0: Activity) {
        Log.d("MyApplicationTag", "onActivityResumed: ")
        isAppInForeground = true
    }

    override fun onActivityPaused(p0: Activity) {
        Log.d("MyApplicationTag", "onActivityPaused: ")
        isAppInForeground = false
    }

    override fun onActivityStopped(p0: Activity) {}

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {}

    override fun onActivityDestroyed(p0: Activity) {}
}