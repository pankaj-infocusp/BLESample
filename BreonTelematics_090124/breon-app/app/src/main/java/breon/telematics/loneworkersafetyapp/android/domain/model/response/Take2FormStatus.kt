package breon.telematics.loneworkersafetyapp.android.domain.model.response

import androidx.annotation.Keep

@Keep
data class Take2FormStatus(
	val take2Enable: String?
)

@Keep
data class Take2FormFilledStatus(
	val status: String?,
	val message: String?
)

@Keep
data class SubmitTake2Form(
	val status: String?,
	val message: String?
)