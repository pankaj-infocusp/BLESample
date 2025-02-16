package breon.telematics.loneworkersafetyapp.android.domain.usecases

import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.model.request.ConfirmOrUpdateDetailsRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.response.ConfirmDetails
import breon.telematics.loneworkersafetyapp.android.domain.repository.BreonRepository
import javax.inject.Inject

class UpdateContactDetailsUseCase @Inject constructor(
    private val breonRepository: BreonRepository
) {

    suspend operator fun invoke(confirmOrUpdateDetailsRequest: ConfirmOrUpdateDetailsRequest): RequestResult<ConfirmDetails> {
        return breonRepository.updateContactDetails(confirmOrUpdateDetailsRequest)
    }
}