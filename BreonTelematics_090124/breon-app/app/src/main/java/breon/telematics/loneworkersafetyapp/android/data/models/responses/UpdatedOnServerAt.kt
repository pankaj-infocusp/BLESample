package breon.telematics.loneworkersafetyapp.android.data.models.responses


import androidx.annotation.Keep

@Keep
data class UpdatedOnServerAt(
    val nanoseconds: Int?,
    val seconds: Int?
)