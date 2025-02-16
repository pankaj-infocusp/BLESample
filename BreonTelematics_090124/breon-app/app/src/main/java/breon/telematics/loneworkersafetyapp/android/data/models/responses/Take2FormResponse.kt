package breon.telematics.loneworkersafetyapp.android.data.models.responses

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Take2FormResponse(

	@SerializedName("data") val data: Data?,

	@SerializedName("message") val message: String?,

	@SerializedName("status") val status: String?
) {
	@Keep
	data class Data(
		@SerializedName("Take2Enable")

		val take2Enable: String?
	)
}

@Keep
data class Take2FormFilledResponse(
	@SerializedName("message") val message: String?,

	@SerializedName("status") val status: String?
)

@Keep
data class Take2FormSubmitResponse(
 @SerializedName("message") val message: String?,

	@SerializedName("status") val status: String?
)
