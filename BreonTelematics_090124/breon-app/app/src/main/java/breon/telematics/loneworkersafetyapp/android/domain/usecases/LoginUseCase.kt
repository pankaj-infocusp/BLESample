package breon.telematics.loneworkersafetyapp.android.domain.usecases

import breon.telematics.loneworkersafetyapp.android.domain.RequestResult
import breon.telematics.loneworkersafetyapp.android.domain.model.response.UserLogin
import breon.telematics.loneworkersafetyapp.android.domain.model.request.UserLoginRequest
import breon.telematics.loneworkersafetyapp.android.domain.repository.BreonRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val breonRepository: BreonRepository
) {
    suspend operator fun invoke (loginRequest: UserLoginRequest) : RequestResult<UserLogin> {
       return breonRepository.userLogin(loginRequest)
    }

}