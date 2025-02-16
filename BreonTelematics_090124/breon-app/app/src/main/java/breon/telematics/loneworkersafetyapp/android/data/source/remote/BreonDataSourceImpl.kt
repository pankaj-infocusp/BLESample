package breon.telematics.loneworkersafetyapp.android.data.source.remote

import breon.telematics.loneworkersafetyapp.android.data.models.mapper.toDomain
import breon.telematics.loneworkersafetyapp.android.data.services.BreonService
import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity
import breon.telematics.loneworkersafetyapp.android.domain.error.ErrorHandler
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
import javax.inject.Inject
import javax.inject.Named

class BreonDataSourceImpl @Inject constructor(
	private val breonService: BreonService,
	@Named("dev_environment") private val breonServiceNew: BreonService,
	private val errorHandler: ErrorHandler
) : BreonDataSource {

	override suspend fun userLogin(loginRequest: UserLoginRequest): RequestResult<UserLogin> {
		runCatching {
			breonService.userLogin(
				callSign = loginRequest.user.username,
				password = loginRequest.user.password,
			)
		}.onSuccess {
			return RequestResult.Success(it.toDomain())
		}.onFailure {
			return RequestResult.ErrorResult(errorHandler.getError(it))
		}
		return RequestResult.ErrorResult(ErrorEntity.Unknown)
	}

	override suspend fun getUserTemplates(templateReq: UserTemplateRequest): RequestResult<UserTemplatesUpdated> {
		runCatching {
			breonService.getUserTemplates(templateReq.callsign)
		}.onSuccess {
			return RequestResult.Success(it.toDomain())
		}.onFailure {
			return RequestResult.ErrorResult(errorHandler.getError(it))
		}
		return RequestResult.ErrorResult(ErrorEntity.Unknown)
	}

	override suspend fun confirmDetails(confirmOrUpdateDetailsRequest: ConfirmOrUpdateDetailsRequest): RequestResult<ConfirmDetails> {
		runCatching {
			breonService.confirmDetails(
				assetId = confirmOrUpdateDetailsRequest.assetId,
				contact = confirmOrUpdateDetailsRequest.contact,
				phone = confirmOrUpdateDetailsRequest.phone,
				email = confirmOrUpdateDetailsRequest.email
			)
		}.onSuccess {
			return RequestResult.Success(it.toDomain())
		}.onFailure {
			return RequestResult.ErrorResult(errorHandler.getError(it))
		}
		return RequestResult.ErrorResult(ErrorEntity.Unknown)
	}

	override suspend fun updateContactDetails(confirmOrUpdateDetailsRequest: ConfirmOrUpdateDetailsRequest): RequestResult<ConfirmDetails> {
		runCatching {
			breonService.updateContactDetails(
				assetId = confirmOrUpdateDetailsRequest.assetId,
				contact = confirmOrUpdateDetailsRequest.contact,
				phone = confirmOrUpdateDetailsRequest.phone,
				email = confirmOrUpdateDetailsRequest.email
			)
		}.onSuccess {
			return RequestResult.Success(it.toDomain())
		}.onFailure {
			return RequestResult.ErrorResult(errorHandler.getError(it))
		}
		return RequestResult.ErrorResult(ErrorEntity.Unknown)
	}

	override suspend fun updateTemplate(updateTemplateRequest: UpdateTemplateRequest): RequestResult<ConfirmDetails> {
		runCatching {
			breonService.updateTemplate(
				callsign = updateTemplateRequest.callsign,
				templateId = updateTemplateRequest.templateId
			)
		}.onSuccess {
			return RequestResult.Success(it.toDomain())
		}.onFailure {
			return RequestResult.ErrorResult(errorHandler.getError(it))
		}
		return RequestResult.ErrorResult(ErrorEntity.Unknown)
	}

	override suspend fun deviceWebServiceSmartphone(deviceWebServiceSmartphoneRequest: DeviceWebServiceSmartphoneRequest): RequestResult<Boolean> {
		runCatching {
			breonService.deviceWebServiceSmartphone(
				message = deviceWebServiceSmartphoneRequest.message
			)
		}.onSuccess {
			return RequestResult.Success(true)
		}.onFailure {
			return RequestResult.ErrorResult(errorHandler.getError(it))
		}
		return RequestResult.ErrorResult(ErrorEntity.Unknown)
	}

	override suspend fun sendLocation(locationRequest: LocationTrackingRequest): RequestResult<LocationTracking> {
		runCatching {
			breonService.sendLocation(
				assetID = locationRequest.assetID,
				interval = "5",
				latitude = locationRequest.latitude,
				longitude = locationRequest.longitude
			)
		}.onSuccess {
			return RequestResult.Success(it.toDomain())
		}.onFailure {
			return RequestResult.ErrorResult(errorHandler.getError(it))
		}
		return RequestResult.ErrorResult(ErrorEntity.Unknown)
	}

	override suspend fun getAssetDetails(assetId: String): RequestResult<AssetDetails> {
		runCatching {
			breonService.getAssetDetails(assetId)
		}.onSuccess {
			return RequestResult.Success(it.toDomain())
		}.onFailure {
			return RequestResult.ErrorResult(errorHandler.getError(it))
		}
		return RequestResult.ErrorResult(ErrorEntity.Unknown)
	}

	override suspend fun getTemplateDetails(assetId: String): RequestResult<TemplateDetails> {
		runCatching {
			breonService.getTemplateDetails(assetId)
		}.onSuccess {
			return RequestResult.Success(it.toDomain())
		}.onFailure {
			return RequestResult.ErrorResult(errorHandler.getError(it))
		}
		return RequestResult.ErrorResult(ErrorEntity.Unknown)
	}

	override suspend fun getTemplateDetailsById(templateId: String): RequestResult<TemplateDetails> {
		runCatching {
			breonService.getTemplateDetailsById(templateId)
		}.onSuccess {
			return RequestResult.Success(it.toDomain())
		}.onFailure {
			return RequestResult.ErrorResult(errorHandler.getError(it))
		}
		return RequestResult.ErrorResult(ErrorEntity.Unknown)
	}

	override suspend fun getTake2FormStatus(assetId: String): RequestResult<Take2FormStatus> {
		runCatching {
			breonServiceNew.getTake2FormStatus(assetId)
		}.onSuccess {
			return RequestResult.Success(it.toDomain())
		}.onFailure {
			return RequestResult.ErrorResult(errorHandler.getError(it))
		}
		return RequestResult.ErrorResult(ErrorEntity.Unknown)
	}

	override suspend fun getIsTake2FormFilled(assetId: String): RequestResult<Take2FormFilledStatus> {
		runCatching {
			breonServiceNew.getIsTake2FormFilled(assetId)
		}.onSuccess {
			return RequestResult.Success(it.toDomain())
		}.onFailure {
			return RequestResult.ErrorResult(errorHandler.getError(it))
		}
		return RequestResult.ErrorResult(ErrorEntity.Unknown)
	}

	override suspend fun submitTake2Form(assetId: Map<String, Any>): RequestResult<SubmitTake2Form> {

		val stringFields = assetId.mapValues { it.value.toString() }

		runCatching {
			breonServiceNew.submitTake2Form(stringFields)
		}.onSuccess {
			return RequestResult.Success(it.toDomain())
		}.onFailure {
			return RequestResult.ErrorResult(errorHandler.getError(it))
		}
		return RequestResult.ErrorResult(ErrorEntity.Unknown)
	}
}