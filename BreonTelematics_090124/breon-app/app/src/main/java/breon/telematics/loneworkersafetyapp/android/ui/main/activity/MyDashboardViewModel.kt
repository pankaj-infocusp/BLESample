package breon.telematics.loneworkersafetyapp.android.ui.main.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import breon.telematics.loneworkersafetyapp.android.app.base.BaseViewModel
import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails
import breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyDashboardViewModel @Inject constructor(
    private val assetDetailsUseCase: AssetDetailsUseCase
): BaseViewModel() {

    private val _assetsDetails = MutableLiveData<AssetDetails?>()
    val assetDetails : LiveData<AssetDetails?> get() = _assetsDetails

    fun getAssetDetails(assetId: String) {
        viewModelScope.launch {
            when(val result = assetDetailsUseCase(assetId)) {
                is RequestResult.Success -> {
                    _assetsDetails.value = result.data
                }

                else -> {}
            }
        }
    }
}