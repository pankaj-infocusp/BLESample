package breon.telematics.loneworkersafetyapp.android.domain.usecases

import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.model.request.UserTemplateRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.response.UserTemplates
import breon.telematics.loneworkersafetyapp.android.domain.model.response.UserTemplatesUpdated
import breon.telematics.loneworkersafetyapp.android.domain.repository.BreonRepository
import javax.inject.Inject

class TemplatesUseCase @Inject constructor (
    private val breonRepository: BreonRepository
) {
    suspend operator fun invoke (templateReq: UserTemplateRequest) : RequestResult<UserTemplatesUpdated> {
        return breonRepository.getUserTemplates(templateReq)
    }

}