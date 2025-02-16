package breon.telematics.loneworkersafetyapp.android.ui.main.sign_on_management

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import breon.telematics.loneworkersafetyapp.android.app.base.BaseViewModel
import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity
import breon.telematics.loneworkersafetyapp.android.domain.model.request.ConfirmOrUpdateDetailsRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.request.DeviceWebServiceSmartphoneRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.request.UserLoginRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails
import breon.telematics.loneworkersafetyapp.android.domain.model.response.ConfirmDetails
import breon.telematics.loneworkersafetyapp.android.domain.model.response.UserLogin
import breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase
import breon.telematics.loneworkersafetyapp.android.domain.usecases.ConfirmDetailsUseCase
import breon.telematics.loneworkersafetyapp.android.domain.usecases.DeviceWebServiceSmartphoneUseCase
import breon.telematics.loneworkersafetyapp.android.domain.usecases.LoginUseCase
import breon.telematics.loneworkersafetyapp.android.domain.usecases.Take2FormUseCase
import breon.telematics.loneworkersafetyapp.android.utils.UiState
import breon.telematics.loneworkersafetyapp.android.utils.getErrorMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignOnManagementViewModel @Inject constructor(
	private val loginUseCase: LoginUseCase,
	private val deviceWebServiceSmartphoneUseCase: DeviceWebServiceSmartphoneUseCase,
	private val confirmDetailsUseCase: ConfirmDetailsUseCase,
	private val assetDetailsUseCase: AssetDetailsUseCase,
	private val take2FormUseCase: Take2FormUseCase
) : BaseViewModel() {

	private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
	val uiState = _uiState.asStateFlow()


	private val _userLoginData = MutableLiveData<UserLogin?>()

	private val _deviceWebService = MutableLiveData<Boolean>()

	private val _confirmDetails = MutableLiveData<ConfirmDetails?>()

	private val _assetDetailsMutableState = MutableStateFlow<AssetDetails?>(null)
	val assetDetailState = _assetDetailsMutableState.asStateFlow()

	private val _error = MutableLiveData<String>()
	val error: LiveData<String> get() = _error

	fun setIdleState() {
		_uiState.value = UiState.Idle
	}

	fun callSignOnApis(
		loginRequest: UserLoginRequest,
		deviceWebServiceRequest: DeviceWebServiceSmartphoneRequest,
		confirmDetailsRequest: ConfirmOrUpdateDetailsRequest,
		assetId: String
	) {
		viewModelScope.launch {
			_uiState.emit(UiState.Loading(true))

			when (val response = loginUseCase(loginRequest)) {
				is RequestResult.Success -> {
					Log.d("API_TRACING", "SignOnApis Success:")
					_userLoginData.value = response.data
					callConfirmDetailsApi(
						confirmDetailsRequest,
						deviceWebServiceRequest,
						assetId
					)
				}

				is RequestResult.ErrorResult -> {
					Log.d("API_TRACING", "SignOnApis ErrorResult: ${response.entity}")
					_uiState.emit(UiState.Loading(false))
					_error.value = getErrorMessage(response.entity)
				}

				else -> {
					Log.d("API_TRACING", "SignOnApis else: $response")
					_uiState.emit(UiState.Loading(false))
					_error.value = getErrorMessage(ErrorEntity.Unknown)
				}
			}
		}
	}

	private fun callConfirmDetailsApi(
		confirmOrUpdateDetailsRequest: ConfirmOrUpdateDetailsRequest,
		deviceWebServiceSmartphoneRequest: DeviceWebServiceSmartphoneRequest,
		assetId: String
	) {
		viewModelScope.launch {
			_uiState.emit(UiState.Loading(true))
			when (val response = confirmDetailsUseCase(confirmOrUpdateDetailsRequest)) {
				is RequestResult.Success -> {
					Log.d("API_TRACING", "ConfirmDetailsApi Success:")
					_confirmDetails.value = response.data
					callDeviceWebApi(
						deviceWebServiceSmartphoneRequest,
						shouldRedirectToDashboard = true,
						assetId = assetId
					)
				}

				is RequestResult.ErrorResult -> {
					Log.d("API_TRACING", "ConfirmDetailsApi ErrorResult: ${response.entity}")
					_uiState.emit(UiState.Loading(false))
					getErrorMessage(response.entity)
				}

				else -> {
					Log.d("API_TRACING", "ConfirmDetailsApi else: $response")
					_uiState.emit(UiState.Loading(false))
					getErrorMessage(ErrorEntity.Unknown)
				}
			}
		}
	}

	fun callDeviceWebApi(
		deviceWebServiceSmartphoneRequest: DeviceWebServiceSmartphoneRequest,
		showLoading: Boolean = false,
		shouldRedirectToDashboard: Boolean = false,
		assetId: String,
	) {
		viewModelScope.launch {
			if (showLoading) _uiState.emit(UiState.Loading(true))
			val response = deviceWebServiceSmartphoneUseCase(deviceWebServiceSmartphoneRequest)
			when (response) {
				is RequestResult.Success -> {
					Log.d("API_TRACING", "DeviceWebApi Success: $showLoading")
					// If user wants to logoff only then assign a data to observe in UI.
					if (showLoading) _deviceWebService.value = response.data
//					getTake2FormStatus(assetId, shouldRedirectToDashboard)
					getAssetDetails(assetId, shouldRedirectToDashboard)
				}

				is RequestResult.ErrorResult -> {
					Log.d("API_TRACING", "DeviceWebApi ErrorResult: ${response.entity}")
					getErrorMessage(response.entity)
					_uiState.emit(UiState.Loading(false))
				}

				else -> {
					Log.d("API_TRACING", "DeviceWebApi else: $response")
					getErrorMessage(ErrorEntity.Unknown)
					_uiState.emit(UiState.Loading(false))
				}
			}
		}
	}

	fun getAssetDetails(assetId: String, shouldRedirectToDashboard: Boolean) {
		viewModelScope.launch(Dispatchers.IO) {
			when (val result = assetDetailsUseCase(assetId)) {
				is RequestResult.Success -> {
					_assetDetailsMutableState.emit(result.data)
					_uiState.emit(UiState.Loading(false))
					if (shouldRedirectToDashboard)
						_uiState.emit(UiState.OpenDashboardFragment)
				}


				else -> {
					_uiState.emit(UiState.Loading(false))
				}
			}
		}
	}

	fun getTake2FormStatus(assetId: String) {
		viewModelScope.launch {
			_uiState.emit(UiState.Loading(true))
			val response = take2FormUseCase.getTake2FormStatus(
				assetId
			)
			when (response) {
				is RequestResult.Success -> {
					Log.d("getTake2FormStatus", "DeviceWebApi Success: ${response.data}")
					val isTake1Enable = response.data.take2Enable.equals("Yes", true)
					if (isTake1Enable) {
						getIsTake2FormFilled(assetId, false)
					} else {
						_uiState.emit(UiState.StartSignOnFlow)
					}
				}

				is RequestResult.ErrorResult -> {
					Log.d("getTake2FormStatus", "DeviceWebApi ErrorResult: ${response.entity}")
					getErrorMessage(response.entity)
					_uiState.emit(UiState.Loading(false))
				}

				else -> {
					Log.d("getTake2FormStatus", "DeviceWebApi else: $response")
					getErrorMessage(ErrorEntity.Unknown)
					_uiState.emit(UiState.Loading(false))
				}
			}
		}

	}

	fun getIsTake2FormFilled(assetId: String, isShowProgress: Boolean) {
		viewModelScope.launch {
			val response = take2FormUseCase.getTake2FormFilledStatus(
				assetId
			)
			when (response) {
				is RequestResult.Success -> {
					Log.d("getIsTake2FormFilled", "getIsTake2FormFilled: ${response.data} ")
					val isTake2Filled = response.data.message.equals("Yes", true)
					if (isTake2Filled) {
						_uiState.emit(UiState.Loading(false))
						_uiState.emit(UiState.StartNewScreen)
					} else {
						_uiState.emit(UiState.StartSignOnFlow)
					}
				}

				is RequestResult.ErrorResult -> {
					Log.d("getTake2FormStatus", "DeviceWebApi ErrorResult: ${response.entity}")
					getErrorMessage(response.entity)
					_uiState.emit(UiState.Loading(false))
				}

				else -> {
					Log.d("getTake2FormStatus", "DeviceWebApi else: $response")
					getErrorMessage(ErrorEntity.Unknown)
					_uiState.emit(UiState.Loading(false))
				}
			}
		}
	}
}
