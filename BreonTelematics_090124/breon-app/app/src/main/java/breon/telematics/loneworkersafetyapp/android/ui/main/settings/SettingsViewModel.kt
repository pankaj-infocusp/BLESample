package breon.telematics.loneworkersafetyapp.android.ui.main.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import breon.telematics.loneworkersafetyapp.android.app.base.BaseViewModel
import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity
import breon.telematics.loneworkersafetyapp.android.domain.model.request.ConfirmOrUpdateDetailsRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.request.UpdateTemplateRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.response.ConfirmDetails
import breon.telematics.loneworkersafetyapp.android.domain.model.response.TemplateDetails
import breon.telematics.loneworkersafetyapp.android.domain.usecases.ConfirmDetailsUseCase
import breon.telematics.loneworkersafetyapp.android.domain.usecases.TemplateDetailsUseCase
import breon.telematics.loneworkersafetyapp.android.domain.usecases.UpdateContactDetailsUseCase
import breon.telematics.loneworkersafetyapp.android.domain.usecases.UpdateTemplateUseCase
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
class SettingsViewModel @Inject constructor(
    private val confirmDetailsUseCase: ConfirmDetailsUseCase,
    private val updateContactDetailsUseCase: UpdateContactDetailsUseCase,
    private val updateTemplateUseCase: UpdateTemplateUseCase,
    private val templateDetailsUseCase: TemplateDetailsUseCase,
    private val prefManager: PrefManager
) : BaseViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState = _uiState.asStateFlow()

    private val _confirmOrUpdateOrTemplate = MutableLiveData<ConfirmDetails?>()
    val confirmOrUpdateOrTemplate: LiveData<ConfirmDetails?> get() = _confirmOrUpdateOrTemplate

    private val _templatesDetails = MutableLiveData<TemplateDetails?>()
    val templatesDetails: LiveData<TemplateDetails?> get() = _templatesDetails

    init {
        getTemplateDetails()
    }

    fun confirmDetails(
        confirmOrUpdateDetailsRequest: ConfirmOrUpdateDetailsRequest,
        updateTemplateRequest: UpdateTemplateRequest
    ) {
        viewModelScope.launch {
            _uiState.emit(UiState.Loading(true))
            when (val response = confirmDetailsUseCase(confirmOrUpdateDetailsRequest)) {
                is RequestResult.Success -> {
                    updateContactDetails(
                        confirmOrUpdateDetailsRequest,
                        updateTemplateRequest
                    )
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

    private fun updateContactDetails(
        confirmOrUpdateDetailsRequest: ConfirmOrUpdateDetailsRequest,
        updateTemplateRequest: UpdateTemplateRequest
    ) {
        viewModelScope.launch {
            when (val response = updateContactDetailsUseCase(confirmOrUpdateDetailsRequest)) {
                is RequestResult.Success -> {
                    updateTemplate(updateTemplateRequest)
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

    private fun updateTemplate(updateTemplateRequest: UpdateTemplateRequest) {
        viewModelScope.launch {
            when (val response = updateTemplateUseCase(updateTemplateRequest)) {
                is RequestResult.Success -> {
                    getTemplateDetails()
                    _confirmOrUpdateOrTemplate.value = response.data
                }

                is RequestResult.ErrorResult -> {
                    getErrorMessage(response.entity)
                    _uiState.emit(UiState.Loading(false))
                }

                else -> {
                    getErrorMessage(ErrorEntity.Unknown)
                    _uiState.emit(UiState.Loading(false))
                }
            }
        }
    }

    private fun getTemplateDetails() {
        viewModelScope.launch {
            val assetId = prefManager.getString(AppConstants.ASSETS_ID)
            val response = templateDetailsUseCase(assetId)
            _uiState.emit(UiState.Loading(false))
            when(response) {
                is RequestResult.Success -> {
                    _templatesDetails.value = response.data
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

    fun getTemplateDetailsById(templateId: String) {
        viewModelScope.launch {
            _uiState.emit(UiState.Loading(true))
            val response = templateDetailsUseCase.getTemplateDetailsById(templateId)
            _uiState.emit(UiState.Loading(false))

            when(response) {
                is RequestResult.Success -> {
                    _templatesDetails.value = response.data
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