package breon.telematics.loneworkersafetyapp.android.domain.usecases

import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.model.response.SubmitTake2Form
import breon.telematics.loneworkersafetyapp.android.domain.model.response.Take2FormFilledStatus
import breon.telematics.loneworkersafetyapp.android.domain.model.response.Take2FormStatus
import breon.telematics.loneworkersafetyapp.android.domain.repository.BreonRepository
import javax.inject.Inject

class Take2FormUseCase @Inject constructor(
	private val breonRepository: BreonRepository
) {

	suspend fun getTake2FormStatus(request: String): RequestResult<Take2FormStatus> {
		return breonRepository.getTake2FormStatus(request)
	}

	suspend fun getTake2FormFilledStatus(request: String): RequestResult<Take2FormFilledStatus> {
		return breonRepository.getIsTake2FormFilled(request)
	}

	suspend fun submitForm(formData: Map<String, Any>): RequestResult<SubmitTake2Form> {
		return breonRepository.submitTake2Form(formData)
	}

}