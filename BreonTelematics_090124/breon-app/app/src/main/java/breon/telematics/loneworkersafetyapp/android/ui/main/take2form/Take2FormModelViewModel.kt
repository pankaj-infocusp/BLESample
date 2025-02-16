package breon.telematics.loneworkersafetyapp.android.ui.main.take2form

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import breon.telematics.loneworkersafetyapp.android.app.base.BaseViewModel
import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity
import breon.telematics.loneworkersafetyapp.android.domain.model.response.SubmitTake2Form
import breon.telematics.loneworkersafetyapp.android.domain.usecases.Take2FormUseCase
import breon.telematics.loneworkersafetyapp.android.utils.UiState
import breon.telematics.loneworkersafetyapp.android.utils.getErrorMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Take2FormModelViewModel @Inject constructor(
	private val take2FormUseCase: Take2FormUseCase
) : BaseViewModel() {

	private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
	val uiState = _uiState.asStateFlow()

	private val take2Form = MutableLiveData<SubmitTake2Form?>()
	val take2FormData: LiveData<SubmitTake2Form?> get() = take2Form

	private val _error = MutableLiveData<String>()
	val error: LiveData<String> get() = _error

	fun setIdleState() {
		_uiState.value = UiState.Idle
	}

	fun submitTake2Form(take2FormData: Map<String, Any>) {
		viewModelScope.launch {
			_uiState.emit(UiState.Loading(true))

			when (val response = take2FormUseCase.submitForm(take2FormData)) {
				is RequestResult.Success -> {
					if (response.data != null && response.data.status.equals("success")) {
						_error.value = response.data.message.toString()
						take2Form.value = response.data
					} else {
						_error.value = response.data.message.toString()
					}
					_uiState.emit(UiState.Loading(false))
					Log.d("LoginAPIs", "userLogin: Success")
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

}
