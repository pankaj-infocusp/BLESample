package breon.telematics.loneworkersafetyapp.android.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.provider.Settings
import android.widget.Toast
import androidx.core.app.ActivityCompat
import breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity
import com.google.firebase.Firebase
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.installations.installations
import okhttp3.internal.wait
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

val permissions = arrayOf(
    Manifest.permission.ACCESS_COARSE_LOCATION,
    Manifest.permission.ACCESS_FINE_LOCATION
)

fun Context.showToast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun getCurrentDateTimeInUTCFormat(format: String = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"): String {
    val currentDateTime = LocalDateTime.now().atOffset(ZoneOffset.UTC)
    val formatter = DateTimeFormatter.ofPattern(format)
    return formatter.format(currentDateTime)
}

fun getCurrentUtcDate(): String {
    val format = "yyyy-MM-dd"
    val currentDateTime = LocalDateTime.now().atOffset(ZoneOffset.UTC)
    val formatter = DateTimeFormatter.ofPattern(format)
    return formatter.format(currentDateTime)
}

fun getCurrentUtcTime(): String {
    val format = "HH:mm:ss"
    val currentDateTime = LocalDateTime.now().atOffset(ZoneOffset.UTC)
    val formatter = DateTimeFormatter.ofPattern(format)
    return formatter.format(currentDateTime)
}

fun getDueTimeInUTCFormat(format: String, minutes: Long): String {
    val currentDateTime = LocalDateTime.now().atOffset(ZoneOffset.UTC)
    currentDateTime.plusMinutes(minutes)
    val formatter = DateTimeFormatter.ofPattern(format)
    return formatter.format(currentDateTime)
}


fun getZonedDateTimeFromDate(date: String, dateFormatter: DateTimeFormatter): ZonedDateTime? {
    // Parse the string to a LocalDateTime
    val localDateTime = LocalDateTime.parse(date, dateFormatter)

    // Create a ZonedDateTime in UTC
    val utcZonedDateTime = localDateTime?.atZone(ZoneId.of("UTC"))

    // Convert it to System default time zone
    val systemZonedDateTime = utcZonedDateTime?.withZoneSameInstant(ZoneId.systemDefault())

    return systemZonedDateTime
}

fun Context.isLocationPermissionGranted(): Boolean {
    return permissions.all {
        ActivityCompat.checkSelfPermission(
            this, it
        ) == PackageManager.PERMISSION_GRANTED
    }
}

fun getErrorMessage(entity: ErrorEntity): String {
    return when (entity) {
        is ErrorEntity.AccessDenied -> "Access Denied."
        is ErrorEntity.Authentication -> "Authentication Error. Please check your credential."
        is ErrorEntity.BadRequest -> "Bad Request."
        is ErrorEntity.Network -> "Network error. Please check your internet connection."
        is ErrorEntity.NotFound -> "User not found."
        is ErrorEntity.ServiceUnavailable -> "Service is temporary unavailable."
        is ErrorEntity.ServerError -> "Server error. Please try again later."
        is ErrorEntity.Unknown -> "Unknown Error"
    }
}

fun isNetworkAvailable(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val networkCapabilities =
            connectivityManager?.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (networkCapabilities != null) {
            (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                    || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                    || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET))
        } else false
    } else {
        val info = connectivityManager?.activeNetworkInfo
        info != null && info.isConnected
    }
}