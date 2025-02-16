package breon.telematics.loneworkersafetyapp.android.data.models.mapper

import breon.telematics.loneworkersafetyapp.android.data.models.responses.LocationTrackingResponse
import breon.telematics.loneworkersafetyapp.android.domain.model.response.LocationTracking

fun LocationTrackingResponse.toDomain() =
    LocationTracking(
        hasError = hasError,
        message = message
    )