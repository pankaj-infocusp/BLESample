package breon.telematics.loneworkersafetyapp.android.domain.model.request

import androidx.annotation.Keep

@Keep
data class UpdateTemplateRequest(
    val callsign: String,
    val templateId: String
)
