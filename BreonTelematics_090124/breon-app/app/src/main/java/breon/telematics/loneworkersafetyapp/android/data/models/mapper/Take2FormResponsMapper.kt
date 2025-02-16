package breon.telematics.loneworkersafetyapp.android.data.models.mapper

import breon.telematics.loneworkersafetyapp.android.data.models.responses.Take2FormFilledResponse
import breon.telematics.loneworkersafetyapp.android.data.models.responses.Take2FormResponse
import breon.telematics.loneworkersafetyapp.android.data.models.responses.Take2FormSubmitResponse
import breon.telematics.loneworkersafetyapp.android.domain.model.response.SubmitTake2Form
import breon.telematics.loneworkersafetyapp.android.domain.model.response.Take2FormFilledStatus
import breon.telematics.loneworkersafetyapp.android.domain.model.response.Take2FormStatus


fun Take2FormResponse.toDomain() =
	Take2FormStatus(
		take2Enable = data?.take2Enable.orEmpty()
	)


fun Take2FormFilledResponse.toDomain() =
	Take2FormFilledStatus(
		status = status,
		message = message
	)

fun Take2FormSubmitResponse.toDomain() =
	SubmitTake2Form(
		status = status,
		message = message
	)