package breon.telematics.loneworkersafetyapp.android.domain.model.response

import androidx.annotation.Keep

@Keep
data class AssetDetails(
    val contact: String,
    val email: String,
    val hazardTimer: String,
    val hazardTimerStartedTime: String,
    val id: String,
    val iMEI: String,
    val lastCheckIn: String,
    val lastSignedOn: String,
    val offTimer: String,
    val phone: String,
    val safetyTimer: String,
    val status: String,
    val templateName: String,
    val trackingInterval: String,
    val trackingOn: String?
)
