package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import breon.telematics.loneworkersafetyapp.android.app.base.BaseViewModel
import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity
import breon.telematics.loneworkersafetyapp.android.domain.model.request.DeviceWebServiceSmartphoneRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.response.ConfirmDetails
import breon.telematics.loneworkersafetyapp.android.domain.usecases.DeviceWebServiceSmartphoneUseCase
import breon.telematics.loneworkersafetyapp.android.utils.UiState
import breon.telematics.loneworkersafetyapp.android.utils.getErrorMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel  @Inject constructor(
    private val deviceWebServiceSmartphoneUseCase: DeviceWebServiceSmartphoneUseCase
): BaseViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState = _uiState.asStateFlow()

    private val _deviceWebServiceSmartphone = MutableLiveData<Boolean>()
    val deviceWebServiceSmartphone: LiveData<Boolean> get() = _deviceWebServiceSmartphone


    fun deviceWebServiceSmartphone(
        deviceWebServiceSmartphoneRequest: DeviceWebServiceSmartphoneRequest
    ){
        viewModelScope.launch {
            _uiState.emit(UiState.Loading(true))
            val response = deviceWebServiceSmartphoneUseCase(deviceWebServiceSmartphoneRequest)
            _uiState.emit(UiState.Loading(false))
            when (response) {
                is RequestResult.Success -> {
                    _deviceWebServiceSmartphone.value = response.data
                }

                is RequestResult.ErrorResult -> {
                    getErrorMessage(response.entity)
                }

                else -> {
                    getErrorMessage(ErrorEntity.Unknown)
                }
            }
        }
    }
}