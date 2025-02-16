package breon.telematics.loneworkersafetyapp.android.data.models.responses

import androidx.annotation.Keep

@Keep
data class ConfirmDetailsResponse(
    val error: Int?,
    val message: String?
)