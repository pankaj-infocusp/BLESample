package breon.telematics.loneworkersafetyapp.android.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import breon.telematics.loneworkersafetyapp.android.app.base.BaseViewModel
import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity
import breon.telematics.loneworkersafetyapp.android.domain.model.request.UserLoginRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.request.UserTemplateRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails
import breon.telematics.loneworkersafetyapp.android.domain.model.response.UserLogin
import breon.telematics.loneworkersafetyapp.android.domain.model.response.UserTemplatesUpdated
import breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase
import breon.telematics.loneworkersafetyapp.android.domain.usecases.LoginUseCase
import breon.telematics.loneworkersafetyapp.android.domain.usecases.TemplatesUseCase
import breon.telematics.loneworkersafetyapp.android.utils.UiState
import breon.telematics.loneworkersafetyapp.android.utils.getErrorMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val templatesUseCase: TemplatesUseCase,
    private val assetDetailsUseCase: AssetDetailsUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState = _uiState.asStateFlow()

    private val _userLoginData = MutableLiveData<UserLogin?>()
    val userLoginData: LiveData<UserLogin?> get() = _userLoginData

    private val _assetDetailsMutableState = MutableStateFlow<AssetDetails?>(null)
    val assetDetailState = _assetDetailsMutableState.asStateFlow()

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private var _templatesData = MutableLiveData<UserTemplatesUpdated?>()
    val templatesData: LiveData<UserTemplatesUpdated?> get() = _templatesData

    fun startDummyLoading(assetId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.emit(UiState.Success("Registering User Settings Service"))
            delay(500)
            _uiState.emit(UiState.Success("Registering Breon Sync Service"))
            delay(700)
            _uiState.emit(UiState.Success("Registering Safety Monitoring Service"))
            val result = assetDetailsUseCase.invoke(assetId)
            _uiState.emit(UiState.Success("Almost Done..."))
            delay(700)
            if (result is RequestResult.Success) {
                _assetDetailsMutableState.emit(result.data)
            } else {
                _assetDetailsMutableState.emit(null)
            }
        }
    }

    fun setIdleState() {
        _uiState.value = UiState.Idle
    }

    fun userLogin(loginRequest: UserLoginRequest) {
        viewModelScope.launch {
            _uiState.emit(UiState.Loading(true))

            when (val response = loginUseCase(loginRequest)) {
                is RequestResult.Success -> {
                    _userLoginData.value = response.data
                    Log.d("LoginAPIs", "userLogin: Success")

                    delay(5000)
                    val templateReq =
                        UserTemplateRequest(
                            callsign = loginRequest.user.username
                        )
                    getUserTemplates(templateReq, response.data.assetId)
                }

                is RequestResult.ErrorResult -> {
                    Log.d("LoginAPIs", "userLogin: Error : ${response.entity}")
                    _uiState.emit(UiState.Loading(false))
                    _error.value = getErrorMessage(response.entity)
                }

                else -> {
                    Log.d("LoginAPIs", "userLogin: Else :")
                    _uiState.emit(UiState.Loading(false))
                    _error.value = getErrorMessage(ErrorEntity.Unknown)
                }
            }
        }
    }

    private fun getUserTemplates(templateReq: UserTemplateRequest, assetId: String?) {
        viewModelScope.launch {
            when (val response = templatesUseCase(templateReq)) {
                is RequestResult.Success -> {
                    Log.d("LoginAPIs", "getUserTemplates: Success: ${response.data}")
                    _templatesData.value = response.data
                    getAssetDetails(assetId)
                }

                is RequestResult.ErrorResult -> {
                    Log.d("LoginAPIs", "getUserTemplates: ErrorResult : ${response.entity}")
                    _uiState.emit(UiState.Loading(false))
                    _error.value = getErrorMessage(response.entity)
                }

                else -> {
                    Log.d("LoginAPIs", "getUserTemplates: else")
                    _uiState.emit(UiState.Loading(false))
                    _error.value = getErrorMessage(ErrorEntity.Unknown)
                }
            }
        }
    }

    private fun getAssetDetails(assetId: String?) {
        viewModelScope.launch {
            if (assetId == null) {
                _uiState.emit(UiState.Loading(false))
                return@launch
            }
            when (val response = assetDetailsUseCase(assetId)) {
                is RequestResult.Success -> {
                    _uiState.emit(UiState.Loading(false))
                    _assetDetailsMutableState.emit(response.data)
//                    _assetDetailsData.value = response.data
                }

                is RequestResult.ErrorResult -> {
                    _uiState.emit(UiState.Loading(false))
                    _error.value = getErrorMessage(response.entity)
                }

                else -> {
                    _uiState.emit(UiState.Loading(false))
                    _error.value = getErrorMessage(ErrorEntity.Unknown)
                }
            }
        }
    }

}

