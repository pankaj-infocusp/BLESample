package breon.telematics.loneworkersafetyapp.android.domain.model.request

import androidx.annotation.Keep

@Keep
data class UserLoginRequest(
    val user: UserData
)
{

    @Keep
    data class UserData(
        val password: String,
        val username: String
    )
}