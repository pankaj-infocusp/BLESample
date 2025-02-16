package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.checkin

import android.util.Log
import androidx.lifecycle.viewModelScope
import breon.telematics.loneworkersafetyapp.android.app.base.BaseViewModel
import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity
import breon.telematics.loneworkersafetyapp.android.domain.model.request.DeviceWebServiceSmartphoneRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails
import breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase
import breon.telematics.loneworkersafetyapp.android.domain.usecases.DeviceWebServiceSmartphoneUseCase
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants
import breon.telematics.loneworkersafetyapp.android.utils.PrefManager
import breon.telematics.loneworkersafetyapp.android.utils.UiState
import breon.telematics.loneworkersafetyapp.android.utils.getErrorMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckInViewModel @Inject constructor(
    private val deviceWebServiceSmartphoneUseCase: DeviceWebServiceSmartphoneUseCase,
    private val assetDetailsUseCase: AssetDetailsUseCase,
    private val prefs: PrefManager
) : BaseViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState = _uiState.asStateFlow()

    private val _assetDetailsMutableState = MutableStateFlow<AssetDetails?>(null)
    val assetDetailState = _assetDetailsMutableState.asStateFlow()

    fun deviceWebService(
        deviceWebServiceRequest: DeviceWebServiceSmartphoneRequest
    ){
        viewModelScope.launch {
            _uiState.emit(UiState.Loading(true))
            when (val response = deviceWebServiceSmartphoneUseCase(deviceWebServiceRequest)) {
                is RequestResult.Success -> {
                    Log.d("ClickEventTracking", "deviceWebService: Success")
                    val assetId = prefs.getString(AppConstants.ASSETS_ID)
                    getAssetDetails(assetId)
                }

                is RequestResult.ErrorResult -> {
                    Log.d("ClickEventTracking", "deviceWebService: ErrorResult : ${response.entity}")
                    _uiState.emit(UiState.Loading(false))
                    getErrorMessage(response.entity)
                }

                else -> {
                    Log.d("ClickEventTracking", "deviceWebService: ErrorResult.Unknown ")
                    _uiState.emit(UiState.Loading(false))
                    getErrorMessage(ErrorEntity.Unknown)
                }
            }
        }
    }

    fun getAssetDetails(assetId: String, showLoader: Boolean = true) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.emit(UiState.Loading(showLoader))
            val result = assetDetailsUseCase(assetId)
            _uiState.emit(UiState.Loading(false))

            when(result) {
                is RequestResult.Success -> {
                    _assetDetailsMutableState.emit(result.data)
                }

                else -> { _uiState.emit(UiState.Loading(false)) }
            }
        }
    }
}
