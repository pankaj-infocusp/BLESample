package breon.telematics.loneworkersafetyapp.android.domain.usecases

import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails
import breon.telematics.loneworkersafetyapp.android.domain.repository.BreonRepository
import javax.inject.Inject

class AssetDetailsUseCase @Inject constructor(
    private val breonRepository: BreonRepository
) {

    suspend operator fun invoke(assetId: String): RequestResult<AssetDetails> {
        return breonRepository.getAssetDetails(assetId)
    }
}