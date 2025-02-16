package breon.telematics.loneworkersafetyapp.android.data.models.mapper

import breon.telematics.loneworkersafetyapp.android.data.models.responses.CreatedOnServerAt
import breon.telematics.loneworkersafetyapp.android.data.models.responses.UserTemplatesResponse
import breon.telematics.loneworkersafetyapp.android.data.models.responses.UpdatedOnServerAt
import breon.telematics.loneworkersafetyapp.android.data.models.responses.UserTemplatesUpdatedResponse
import breon.telematics.loneworkersafetyapp.android.domain.model.response.UserTemplates
import breon.telematics.loneworkersafetyapp.android.domain.model.response.UserTemplatesUpdated

fun List<UserTemplatesResponse>.toDomain() =
    UserTemplates(
        templatesResponse = this.map { it.toDomain() }
    )

fun UserTemplatesResponse.toDomain() =
    UserTemplates.UserTemplatesItem(
        createdAt = createdAt,
        createdBy = createdBy,
        createdOnServerAt = createdOnServerAt?.toDomain(),
        docType = docType,
        id = id,
        isDeleted = isDeleted,
        name = name,
        safetyTimer = safetyTimer,
        signOffTime = signOffTime,
        updatedAt = updatedAt,
        updatedBy = updatedBy,
        updatedOnServerAt = updatedOnServerAt?.toDomain()
    )

fun CreatedOnServerAt.toDomain() =
    UserTemplates.UserTemplatesItem.CreatedOnServerAt(
        nanoseconds = nanoseconds,
        seconds = seconds
    )

fun UpdatedOnServerAt.toDomain() =
    UserTemplates.UserTemplatesItem.UpdatedOnServerAt(
        nanoseconds = nanoseconds,
        seconds = seconds
    )

fun List<UserTemplatesUpdatedResponse>.toDomain() =
    UserTemplatesUpdated(
        templates = this.map { it.toDomain() }
    )

fun UserTemplatesUpdatedResponse.toDomain() =
    UserTemplatesUpdated.UserTemplatesUpdatedItem(
        templateId, organisationId, groupId, name, safetyTimer, offTimer
    )