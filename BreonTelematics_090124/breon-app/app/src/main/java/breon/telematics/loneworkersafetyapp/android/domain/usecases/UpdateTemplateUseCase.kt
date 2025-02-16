package breon.telematics.loneworkersafetyapp.android.domain.usecases

import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.model.request.UpdateTemplateRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.response.ConfirmDetails
import breon.telematics.loneworkersafetyapp.android.domain.repository.BreonRepository
import javax.inject.Inject

class UpdateTemplateUseCase @Inject constructor(
    private val breonRepository: BreonRepository
) {

    suspend operator fun invoke(updateTemplateRequest: UpdateTemplateRequest): RequestResult<ConfirmDetails> {
        return breonRepository.updateTemplate(updateTemplateRequest)
    }
}