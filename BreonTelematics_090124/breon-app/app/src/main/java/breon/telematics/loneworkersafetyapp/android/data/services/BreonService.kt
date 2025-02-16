package breon.telematics.loneworkersafetyapp.android.data.services

import breon.telematics.loneworkersafetyapp.android.data.models.responses.AssetsDetailsResponse
import breon.telematics.loneworkersafetyapp.android.data.models.responses.ConfirmDetailsResponse
import breon.telematics.loneworkersafetyapp.android.data.models.responses.LocationTrackingResponse
import breon.telematics.loneworkersafetyapp.android.data.models.responses.LoginResponse
import breon.telematics.loneworkersafetyapp.android.data.models.responses.Take2FormFilledResponse
import breon.telematics.loneworkersafetyapp.android.data.models.responses.Take2FormResponse
import breon.telematics.loneworkersafetyapp.android.data.models.responses.Take2FormSubmitResponse
import breon.telematics.loneworkersafetyapp.android.data.models.responses.TemplateDetailsResponse
import breon.telematics.loneworkersafetyapp.android.data.models.responses.UserTemplatesUpdatedResponse
import retrofit2.Response
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface BreonService {

	@POST("_userLogin.php")
	suspend fun userLogin(
		@Query("callsign") callSign: String,
		@Query("password") password: String
	): LoginResponse

	@POST("_confirmDetails.php")
	suspend fun confirmDetails(
		@Query("assetId") assetId: String,
		@Query("contact") contact: String,
		@Query("phone") phone: String,
		@Query("email") email: String,
	): ConfirmDetailsResponse

	@POST("_updateDetails.php")
	suspend fun updateContactDetails(
		@Query("assetid") assetId: String,
		@Query("contact") contact: String,
		@Query("phone") phone: String,
		@Query("email") email: String,
	): ConfirmDetailsResponse

	@POST("_updateTemplate.php")
	suspend fun updateTemplate(
		@Query("callsign") callsign: String,
		@Query("templateID") templateId: String,
	): ConfirmDetailsResponse

	@GET("_userTemplates.php")
	suspend fun getUserTemplates(
		@Query("callsign") callsign: String,
	): List<UserTemplatesUpdatedResponse>

	@POST("_deviceWebservice_smartPhone.php")
	suspend fun deviceWebServiceSmartphone(
		@Query("msg") message: String
	): Response<String?>

	@POST("_trackingUpdate.php")
	suspend fun sendLocation(
		@Query("assetID") assetID: String,
		@Query("interval") interval: String,
		@Query("lat") latitude: String,
		@Query("lon") longitude: String
	): LocationTrackingResponse

	@GET("_assetDetails.php")
	suspend fun getAssetDetails(
		@Query("assetID") assetID: String
	): AssetsDetailsResponse

	@GET("_GetTemplateDetails.php")
	suspend fun getTemplateDetails(
		@Query("userid") assetId: String
	): TemplateDetailsResponse

	@GET("_GetTemplateDetailsById.php")
	suspend fun getTemplateDetailsById(
		@Query("template_id") templateId: String
	): TemplateDetailsResponse

	@GET("_getTake2FormStatus.php")
	suspend fun getTake2FormStatus(
		@Query("asset_id") assetID: String,
	): Take2FormResponse

	@GET("_isTake2FormFilled.php")
	suspend fun getIsTake2FormFilled(
		@Query("asset_id") assetID: String,
	): Take2FormFilledResponse

	@FormUrlEncoded
	@POST("_storeTake2Form.php")
	suspend fun submitTake2Form(@FieldMap formData: Map<String, String>): Take2FormSubmitResponse
}