package breon.telematics.loneworkersafetyapp.android.data.models.responses


import androidx.annotation.Keep

@Keep
data class UserTemplatesResponse(
    val createdAt: String?,
    val createdBy: String?,
    val createdOnServerAt: CreatedOnServerAt?,
    val docType: String?,
    val id: String?,
    val isDeleted: Boolean?,
    val name: String?,
    val safetyTimer: String?,
    val signOffTime: String?,
    val updatedAt: String?,
    val updatedBy: String?,
    val updatedOnServerAt: UpdatedOnServerAt?
)