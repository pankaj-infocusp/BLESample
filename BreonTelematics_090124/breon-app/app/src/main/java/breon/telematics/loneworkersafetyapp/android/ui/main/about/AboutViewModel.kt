package breon.telematics.loneworkersafetyapp.android.ui.main.about

import androidx.lifecycle.viewModelScope
import breon.telematics.loneworkersafetyapp.android.app.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AboutViewModel : BaseViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState = _uiState.asStateFlow()

    fun startLoading() {
        viewModelScope.launch {
            _uiState.emit(UiState.Loading(true))
            delay(1000)
            _uiState.emit(UiState.Loading(false))
        }
    }

    fun setIdleState() {
        _uiState.value = UiState.Idle
    }

}

sealed class UiState {
    object Idle : UiState()
    data class Loading(val isLoading: Boolean) : UiState()
    data class Success<T>(val data: T) : UiState()
    data class Error(val message: String) : UiState()
}