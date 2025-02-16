package breon.telematics.loneworkersafetyapp.android.domain.usecases

import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.model.request.LocationTrackingRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.response.LocationTracking
import breon.telematics.loneworkersafetyapp.android.domain.repository.BreonRepository
import javax.inject.Inject

class LocationTrackingUseCase @Inject constructor(
    private val breonRepository: BreonRepository
) {

    suspend operator fun invoke(
        locationRequest: LocationTrackingRequest
    ): RequestResult<LocationTracking> {
        return breonRepository.sendLocation(locationRequest)
    }
}