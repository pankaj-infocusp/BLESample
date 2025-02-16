package breon.telematics.loneworkersafetyapp.android.domain.model.request

import androidx.annotation.Keep

@Keep
data class ConfirmOrUpdateDetailsRequest(
    val assetId: String,
    val contact: String,
    val phone: String,
    val email: String
)
