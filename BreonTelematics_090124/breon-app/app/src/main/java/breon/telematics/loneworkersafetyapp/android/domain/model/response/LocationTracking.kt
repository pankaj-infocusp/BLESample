package breon.telematics.loneworkersafetyapp.android.domain.model.response

import androidx.annotation.Keep

@Keep
data class LocationTracking(
    val hasError: Boolean?,
    val message: String?
)
