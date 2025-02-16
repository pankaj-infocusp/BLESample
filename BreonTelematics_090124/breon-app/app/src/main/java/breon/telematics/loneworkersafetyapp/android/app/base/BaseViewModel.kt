package breon.telematics.loneworkersafetyapp.android.app.base

import android.content.Intent
import androidx.lifecycle.ViewModel
import breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent

/**
 * Created By Pankaj Dholakiya at 12 March 2024
 */

abstract class BaseViewModel: ViewModel() {
    val showErrorMessage: SingleLiveEvent<String> = SingleLiveEvent()
    val showErrorMessageInt: SingleLiveEvent<Int> = SingleLiveEvent()
    val showSnackBar: SingleLiveEvent<String> = SingleLiveEvent()
    val showSnackBarInt: SingleLiveEvent<Int> = SingleLiveEvent()
    val showToast: SingleLiveEvent<String> = SingleLiveEvent()
    val showToastInt: SingleLiveEvent<Int> = SingleLiveEvent()
    val showLoading: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val showNoData: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val showError: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val startIntent: SingleLiveEvent<Intent> = SingleLiveEvent()
}