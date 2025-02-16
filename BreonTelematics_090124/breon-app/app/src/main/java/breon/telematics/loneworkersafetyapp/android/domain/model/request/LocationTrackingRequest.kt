package breon.telematics.loneworkersafetyapp.android.domain.model.request

import androidx.annotation.Keep

@Keep
data class LocationTrackingRequest(
    val assetID: String,
    val interval: String,
    val latitude: String,
    val longitude: String
)