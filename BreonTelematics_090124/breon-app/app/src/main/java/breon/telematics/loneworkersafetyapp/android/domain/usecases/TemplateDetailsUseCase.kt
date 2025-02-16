package breon.telematics.loneworkersafetyapp.android.domain.usecases

import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.model.response.TemplateDetails
import breon.telematics.loneworkersafetyapp.android.domain.repository.BreonRepository
import javax.inject.Inject

class TemplateDetailsUseCase @Inject constructor(
    private val breonRepository: BreonRepository
) {

    suspend operator fun invoke(assetId: String): RequestResult<TemplateDetails> {
        return breonRepository.getTemplateDetails(assetId)
    }

    suspend fun getTemplateDetailsById(templateId: String): RequestResult<TemplateDetails> {
        return breonRepository.getTemplateDetailsById(templateId)
    }
}