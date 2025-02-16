package breon.telematics.loneworkersafetyapp.android.data.models.responses


import androidx.annotation.Keep

@Keep
data class LocationTrackingResponse(
    val error: String?,
    val hasError: Boolean?,
    val message: String?
)