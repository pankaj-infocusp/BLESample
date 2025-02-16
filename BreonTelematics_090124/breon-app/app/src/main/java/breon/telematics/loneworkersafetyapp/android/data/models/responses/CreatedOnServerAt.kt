package breon.telematics.loneworkersafetyapp.android.data.models.responses


import androidx.annotation.Keep

@Keep
data class CreatedOnServerAt(
    val nanoseconds: Int?,
    val seconds: Int?
)