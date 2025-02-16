package breon.telematics.loneworkersafetyapp.android.domain.model.request

import androidx.annotation.Keep

@Keep
data class DeviceWebServiceSmartphoneRequest(
    val createdAt: String,
    val createdBy: String,
    val createdOnServerAt: CreatedOnServerAt,
    val docType: String,
    val dueAt: String,
    val followupCheckInAfterCancellation: String,
    val id: String,
    val isDeleted: Boolean,
    val message: String,
    val mode: String,
    val type: Int,
    val updatedAt: String,
    val updatedBy: String,
    val updatedOnServerAt: UpdatedOnServerAt
) {
    @Keep
    data class UpdatedOnServerAt(
        val nanoseconds: Int,
        val seconds: Int
    )

    @Keep
    data class CreatedOnServerAt(
        val nanoseconds: Int,
        val seconds: Int
    )
}