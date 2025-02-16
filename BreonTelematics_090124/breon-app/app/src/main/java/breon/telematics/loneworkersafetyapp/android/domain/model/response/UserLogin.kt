package breon.telematics.loneworkersafetyapp.android.domain.model.response

import androidx.annotation.Keep

@Keep
data class UserLogin (
    val assetId: String?,
    val contact: String?,
    val phone: String?,
    val email: String?,
    val safetyTimer: String?,
    val templateName: String?,
    val error: String?,
    val message: String?
)
