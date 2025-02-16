package breon.telematics.loneworkersafetyapp.android.data.models.mapper

import breon.telematics.loneworkersafetyapp.android.data.models.responses.AssetsDetailsResponse
import breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails


fun AssetsDetailsResponse.toDomain() =
    AssetDetails(
        contact = contact.orEmpty(),
        email = email.orEmpty(),
        hazardTimer = hazardTimer.orEmpty(),
        hazardTimerStartedTime = hazardTimerStartedTime.orEmpty(),
        id = id.orEmpty(),
        iMEI = iMEI.orEmpty(),
        lastCheckIn = lastCheckIn.orEmpty(),
        lastSignedOn = lastSignedOn.orEmpty(),
        offTimer = offTimer.orEmpty(),
        phone = phone.orEmpty(),
        safetyTimer = safetyTimer.orEmpty(),
        status = status.orEmpty(),
        templateName = templateName.orEmpty(),
        trackingInterval = trackingInterval.orEmpty(),
        trackingOn = trackingOn.orEmpty()
    )