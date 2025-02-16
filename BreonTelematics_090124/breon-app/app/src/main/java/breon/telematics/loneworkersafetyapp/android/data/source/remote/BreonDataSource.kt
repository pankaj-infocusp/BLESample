package breon.telematics.loneworkersafetyapp.android.data.source.remote

import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.model.request.ConfirmOrUpdateDetailsRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.request.DeviceWebServiceSmartphoneRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.request.LocationTrackingRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.request.UpdateTemplateRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.request.UserLoginRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.request.UserTemplateRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails
import breon.telematics.loneworkersafetyapp.android.domain.model.response.ConfirmDetails
import breon.telematics.loneworkersafetyapp.android.domain.model.response.LocationTracking
import breon.telematics.loneworkersafetyapp.android.domain.model.response.SubmitTake2Form
import breon.telematics.loneworkersafetyapp.android.domain.model.response.Take2FormFilledStatus
import breon.telematics.loneworkersafetyapp.android.domain.model.response.Take2FormStatus
import breon.telematics.loneworkersafetyapp.android.domain.model.response.TemplateDetails
import breon.telematics.loneworkersafetyapp.android.domain.model.response.UserLogin
import breon.telematics.loneworkersafetyapp.android.domain.model.response.UserTemplatesUpdated

interface BreonDataSource {

	suspend fun userLogin(loginRequest: UserLoginRequest): RequestResult<UserLogin>
	suspend fun getUserTemplates(templateReq: UserTemplateRequest): RequestResult<UserTemplatesUpdated>
	suspend fun confirmDetails(confirmOrUpdateDetailsRequest: ConfirmOrUpdateDetailsRequest): RequestResult<ConfirmDetails>
	suspend fun updateContactDetails(confirmOrUpdateDetailsRequest: ConfirmOrUpdateDetailsRequest): RequestResult<ConfirmDetails>
	suspend fun updateTemplate(updateTemplateRequest: UpdateTemplateRequest): RequestResult<ConfirmDetails>
	suspend fun deviceWebServiceSmartphone(deviceWebServiceSmartphoneRequest: DeviceWebServiceSmartphoneRequest): RequestResult<Boolean>
	suspend fun sendLocation(locationRequest: LocationTrackingRequest): RequestResult<LocationTracking>
	suspend fun getAssetDetails(assetId: String): RequestResult<AssetDetails>
	suspend fun getTemplateDetails(assetId: String): RequestResult<TemplateDetails>
	suspend fun getTemplateDetailsById(templateId: String): RequestResult<TemplateDetails>
	/*Take2Form*/
	suspend fun getTake2FormStatus(assetId: String): RequestResult<Take2FormStatus>
	suspend fun getIsTake2FormFilled(assetId: String): RequestResult<Take2FormFilledStatus>
	suspend fun submitTake2Form(assetId: Map<String, Any>): RequestResult<SubmitTake2Form>


}