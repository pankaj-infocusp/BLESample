package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.assist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import breon.telematics.loneworkersafetyapp.android.app.base.BaseViewModel
import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity
import breon.telematics.loneworkersafetyapp.android.domain.model.request.DeviceWebServiceSmartphoneRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails
import breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase
import breon.telematics.loneworkersafetyapp.android.domain.usecases.DeviceWebServiceSmartphoneUseCase
import breon.telematics.loneworkersafetyapp.android.utils.UiState
import breon.telematics.loneworkersafetyapp.android.utils.getErrorMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AssistsViewModel @Inject constructor(
    private val deviceWebServiceUseCase: DeviceWebServiceSmartphoneUseCase,
    private val assetDetailsUseCase: AssetDetailsUseCase
): BaseViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState = _uiState.asStateFlow()

    private val _deviceWebService = MutableLiveData<Boolean>()
    val deviceWebService: LiveData<Boolean> get() = _deviceWebService

    private val _assetDetailsMutableState = MutableStateFlow<AssetDetails?>(null)
    val assetDetailState = _assetDetailsMutableState.asStateFlow()

    var isAssisted = false

    fun deviceWebService(
        deviceWebServiceRequest: DeviceWebServiceSmartphoneRequest
    ){
        viewModelScope.launch {
            _uiState.emit(UiState.Loading(true))
            val response = deviceWebServiceUseCase(deviceWebServiceRequest)
            _uiState.emit(UiState.Loading(false))
            when (response) {
                is RequestResult.Success -> {
                    isAssisted = !isAssisted
                    _deviceWebService.value = response.data
                }

                is RequestResult.ErrorResult -> {
                    _uiState.emit(UiState.Loading(false))
                    getErrorMessage(response.entity)
                }

                else -> {
                    _uiState.emit(UiState.Loading(false))
                    getErrorMessage(ErrorEntity.Unknown)
                }
            }
        }
    }

    fun getAssetDetails(assetId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.emit(UiState.Loading(true))
            when(val result = assetDetailsUseCase(assetId)) {
                is RequestResult.Success -> {
                    _assetDetailsMutableState.emit(result.data)
                    _uiState.emit(UiState.Loading(false))
                }

                else -> { _uiState.emit(UiState.Loading(false)) }
            }
        }
    }
}