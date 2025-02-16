package breon.telematics.loneworkersafetyapp.android.utils

sealed class UiState {
    object Idle : UiState()
    data class Loading(val isLoading: Boolean) : UiState()
    data class Success<T>(val data: T) : UiState()
    data class Error(val message: String) : UiState()
    object StartSignOnFlow : UiState()
    object StartNewScreen : UiState()
    object OpenDashboardFragment: UiState()
}