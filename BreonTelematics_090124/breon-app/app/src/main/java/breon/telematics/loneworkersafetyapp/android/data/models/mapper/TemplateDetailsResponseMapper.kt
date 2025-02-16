package breon.telematics.loneworkersafetyapp.android.data.models.mapper

import breon.telematics.loneworkersafetyapp.android.data.models.responses.TemplateDetailsResponse
import breon.telematics.loneworkersafetyapp.android.domain.model.response.TemplateDetails

fun TemplateDetailsResponse.toDomain(): TemplateDetails {
    if (templatesData.isNullOrEmpty()) {
        return TemplateDetails()
    } else {
        return TemplateDetails(
            templateName = templatesData.first().templateName.orEmpty(),
            organizationName = templatesData.first().orgName.orEmpty(),
            groupName = templatesData.first().groupName.orEmpty(),
            l2Name = templatesData.first().l2Name.orEmpty(),
            l2Contact = templatesData.first().l2Contact.orEmpty(),
            l3Name = templatesData.first().l3Name.orEmpty(),
            l3Contact = templatesData.first().l3Contact.orEmpty(),
            l4Name = templatesData.first().l4Name.orEmpty(),
            l4Contact = templatesData.first().l4Contact.orEmpty(),
            note = templatesData.first().note.orEmpty(),
            safetyTimer = templatesData.first().safetyTimer.orEmpty(),
            offTimer = templatesData.first().offTimer.orEmpty(),
        )
    }
}