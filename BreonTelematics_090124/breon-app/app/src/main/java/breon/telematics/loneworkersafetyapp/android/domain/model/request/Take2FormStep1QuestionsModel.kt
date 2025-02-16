package breon.telematics.loneworkersafetyapp.android.domain.model.request

import androidx.annotation.Keep

@Keep
data class Take2FormStep1QuestionsModel(
	val question: String,
	val slug: String,
	var value: String = "",
)

@Keep
data class Take2FormActionsModel(
	val action: String,
	val isSelected: Boolean = false,
)

@Keep
data class SWMSFormValues(
	val action: String,
	val isSelected: Boolean = false,
)

