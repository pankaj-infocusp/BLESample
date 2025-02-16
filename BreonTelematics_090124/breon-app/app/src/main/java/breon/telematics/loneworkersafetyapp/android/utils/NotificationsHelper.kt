package breon.telematics.loneworkersafetyapp.android.utils

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import breon.telematics.loneworkersafetyapp.android.R
import breon.telematics.loneworkersafetyapp.android.ui.login.LoginActivity

internal object NotificationsHelper {
    private const val NOTIFICATION_CHANNEL_ID = "my_notification_channel"
    fun createNotificationChannel(context: Context?) {
        context?.let {
            val notificationManager = context.getSystemService(Service.NOTIFICATION_SERVICE) as NotificationManager

            // create the notification channel
            val channel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                "Foreground Service Notification",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun buildNotification(context: Context): Notification {
        return NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
            .setContentTitle(context.getString(R.string.foreground_service_notification_title))
            .setContentText(context.getString(R.string.foreground_service_notification_description))
            .setSmallIcon(R.mipmap.ic_globe_app_icon)
            .setForegroundServiceBehavior(NotificationCompat.FOREGROUND_SERVICE_IMMEDIATE)
            .setContentIntent(Intent(context, LoginActivity::class.java).let { notificationIntent ->
                PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE)
            })
            .build()
    }

    fun sendNotification(context: Context) {
        val intent = Intent(context, LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 4, intent, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(context, "BREON_CHANNEL_ID")
            .setSmallIcon(R.mipmap.ic_globe_app_icon)
            .setContentTitle("Button Tapped")
            .setContentText("You have tapped the button.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(context)) {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            notify(3, builder.build())
        }
    }
}