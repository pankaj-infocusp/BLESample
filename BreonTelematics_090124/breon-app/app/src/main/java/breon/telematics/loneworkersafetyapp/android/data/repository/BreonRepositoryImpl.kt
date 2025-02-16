package breon.telematics.loneworkersafetyapp.android.data.repository

import breon.telematics.loneworkersafetyapp.android.data.source.remote.BreonDataSource
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
import breon.telematics.loneworkersafetyapp.android.domain.repository.BreonRepository
import javax.inject.Inject

class BreonRepositoryImpl @Inject constructor(
	private val breonDataSource: BreonDataSource
) : BreonRepository {
	override suspend fun userLogin(loginRequest: UserLoginRequest): RequestResult<UserLogin> {
		return breonDataSource.userLogin(loginRequest)
	}

	override suspend fun getUserTemplates(templateReq: UserTemplateRequest): RequestResult<UserTemplatesUpdated> {
		return breonDataSource.getUserTemplates(templateReq)
	}

	override suspend fun confirmDetails(confirmOrUpdateDetailsRequest: ConfirmOrUpdateDetailsRequest): RequestResult<ConfirmDetails> {
		return breonDataSource.confirmDetails(confirmOrUpdateDetailsRequest)
	}

	override suspend fun updateContactDetails(confirmOrUpdateDetailsRequest: ConfirmOrUpdateDetailsRequest): RequestResult<ConfirmDetails> {
		return breonDataSource.updateContactDetails(confirmOrUpdateDetailsRequest)
	}

	override suspend fun updateTemplate(updateTemplateRequest: UpdateTemplateRequest): RequestResult<ConfirmDetails> {
		return breonDataSource.updateTemplate(updateTemplateRequest)
	}

	override suspend fun deviceWebServiceSmartphone(deviceWebServiceSmartphoneRequest: DeviceWebServiceSmartphoneRequest): RequestResult<Boolean> {
		return breonDataSource.deviceWebServiceSmartphone(deviceWebServiceSmartphoneRequest)
	}

	override suspend fun sendLocation(locationRequest: LocationTrackingRequest): RequestResult<LocationTracking> {
		return breonDataSource.sendLocation(locationRequest)
	}

	override suspend fun getAssetDetails(assetId: String): RequestResult<AssetDetails> {
		return breonDataSource.getAssetDetails(assetId)
	}

	override suspend fun getTemplateDetails(assetId: String): RequestResult<TemplateDetails> {
		return breonDataSource.getTemplateDetails(assetId)
	}

	override suspend fun getTemplateDetailsById(templateId: String): RequestResult<TemplateDetails> {
		return breonDataSource.getTemplateDetailsById(templateId)
	}

	override suspend fun getTake2FormStatus(assetId: String): RequestResult<Take2FormStatus> {
		return breonDataSource.getTake2FormStatus(assetId)
	}

	override suspend fun getIsTake2FormFilled(assetId: String): RequestResult<Take2FormFilledStatus> {
		return breonDataSource.getIsTake2FormFilled(assetId)
	}

	override suspend fun submitTake2Form(assetId: Map<String, Any>): RequestResult<SubmitTake2Form> {
		return breonDataSource.submitTake2Form(assetId)
	}
}