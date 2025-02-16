package breon.telematics.loneworkersafetyapp.android.data.models.mapper

import breon.telematics.loneworkersafetyapp.android.data.models.responses.LoginResponse
import breon.telematics.loneworkersafetyapp.android.domain.model.response.UserLogin

fun LoginResponse.toDomain() = UserLogin(
    assetId = this.assetId,
    contact = this.contact,
    phone = phone,
    email = this.email,
    safetyTimer = safetyTimer,
    templateName = templateName,
    error = this.error,
    message = this.message
)
