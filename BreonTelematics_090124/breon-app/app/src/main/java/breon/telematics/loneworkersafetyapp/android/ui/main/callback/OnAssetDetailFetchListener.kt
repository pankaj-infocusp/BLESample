package breon.telematics.loneworkersafetyapp.android.ui.main.callback

import breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails

interface OnAssetDetailFetchListener {
    fun onAssetDetailsFetched(assetDetails: AssetDetails)
    fun updateTimer(assetDetails: AssetDetails) {}
}