package breon.telematics.loneworkersafetyapp.android.domain.usecases

import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.model.request.DeviceWebServiceSmartphoneRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.response.ConfirmDetails
import breon.telematics.loneworkersafetyapp.android.domain.repository.BreonRepository
import javax.inject.Inject

class DeviceWebServiceSmartphoneUseCase@Inject constructor(
    private val breonRepository: BreonRepository
) {

    suspend operator fun invoke(
        deviceWebServiceSmartphoneRequest: DeviceWebServiceSmartphoneRequest
    ): RequestResult<Boolean> {
        return breonRepository.deviceWebServiceSmartphone(deviceWebServiceSmartphoneRequest)
    }
}