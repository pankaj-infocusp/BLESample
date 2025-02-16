package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.hazard

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
import breon.telematics.loneworkersafetyapp.android.utils.getCurrentDateTimeInUTCFormat
import breon.telematics.loneworkersafetyapp.android.utils.getCurrentUtcDate
import breon.telematics.loneworkersafetyapp.android.utils.getCurrentUtcTime
import breon.telematics.loneworkersafetyapp.android.utils.getDueTimeInUTCFormat
import breon.telematics.loneworkersafetyapp.android.utils.getErrorMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HazardViewModel @Inject constructor(
    private val deviceWebServiceUseCase: DeviceWebServiceSmartphoneUseCase,
    private val assetDetailsUseCase: AssetDetailsUseCase,
    private val prefs: PrefManager
) : BaseViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState = _uiState.asStateFlow()

    private val _assetDetailsMutableState = MutableStateFlow<AssetDetails?>(null)
    val assetDetailState = _assetDetailsMutableState.asStateFlow()

    var isHazardStarted = false

    fun performHazardOperation(
        username: String,
        note: String,
        latitude: Double,
        longitude: Double,
        action: String,
        duration: Long,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.emit(UiState.Loading(true))

            val formattedDate = getCurrentDateTimeInUTCFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")

            val date = getCurrentUtcDate()
            val time = getCurrentUtcTime()
            val message = "$username,android,$action,$duration,$latitude,$longitude,0,0,$date,$time,$note,0"

            val dueAt = getDueTimeInUTCFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", duration)

            val deviceWebServiceRequest =
                DeviceWebServiceSmartphoneRequest(
                    createdAt = formattedDate,
                    updatedAt = formattedDate,
                    createdBy = username,
                    updatedBy = username,
                    isDeleted = true,
                    id = "string",
                    createdOnServerAt = DeviceWebServiceSmartphoneRequest.CreatedOnServerAt(
                        seconds = 0,
                        nanoseconds = 0
                    ),
                    updatedOnServerAt = DeviceWebServiceSmartphoneRequest.UpdatedOnServerAt(
                        seconds = 0,
                        nanoseconds = 0
                    ),
                    docType = "string",
                    type = 2,
                    mode = "operations",
                    message = message,
                    dueAt = dueAt,
                    followupCheckInAfterCancellation = "string"
                )
            when (val response = deviceWebServiceUseCase(deviceWebServiceRequest)) {
                is RequestResult.Success -> {
                    Log.d("ClickEventTracking", "Hazard Success ")
                    isHazardStarted = !isHazardStarted
                    val assetId = prefs.getString(AppConstants.ASSETS_ID)
                    getAssetDetails(assetId)
                }

                is RequestResult.ErrorResult -> {
                    Log.d("ClickEventTracking", "Hazard ErrorResult : ${response.entity}")
                    _uiState.emit(UiState.Loading(false))
                    getErrorMessage(response.entity)
                }

                else -> {
                    Log.d("ClickEventTracking", "Hazard Error ${ErrorEntity.Unknown}")
                    _uiState.emit(UiState.Loading(false))
                    getErrorMessage(ErrorEntity.Unknown)
                }
            }
        }
    }

    fun getAssetDetails(assetId: String, showLoader: Boolean = true) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.emit(UiState.Loading(showLoader))
            when (val result = assetDetailsUseCase(assetId)) {
                is RequestResult.Success -> {
                    _assetDetailsMutableState.emit(result.data)
                    _uiState.emit(UiState.Loading(false))
                }

                else -> {
                    _uiState.emit(UiState.Loading(false))
                }
            }
        }
    }
}
