package breon.telematics.loneworkersafetyapp.android.domain.model.response

import androidx.annotation.Keep

@Keep
data class UserTemplates(
    val templatesResponse: List<UserTemplatesItem>
) {
    @Keep
    data class UserTemplatesItem(
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

    ) {
        @Keep
        data class CreatedOnServerAt(
            val nanoseconds: Int?,
            val seconds: Int?
        )

        @Keep
        data class UpdatedOnServerAt(
            val nanoseconds: Int?,
            val seconds: Int?
        )
    }
}

@Keep
data class UserTemplatesUpdated(
    val templates: List<UserTemplatesUpdatedItem>
) {

    @Keep
    data class UserTemplatesUpdatedItem(
        val templateId: String?,
        val organisationId: String?,
        val groupId: String?,
        val name: String?,
        val safetyTimer: String?,
        val offTimer: String?,
    )
}