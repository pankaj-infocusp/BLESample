package breon.telematics.loneworkersafetyapp.android.data.models.mapper

import breon.telematics.loneworkersafetyapp.android.data.models.responses.ConfirmDetailsResponse
import breon.telematics.loneworkersafetyapp.android.domain.model.response.ConfirmDetails

fun ConfirmDetailsResponse.toDomain() =
    ConfirmDetails(
        message = message
    )