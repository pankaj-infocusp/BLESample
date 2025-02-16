package breon.telematics.loneworkersafetyapp.android.domain.model.response

data class TemplateDetails(
    val templateName: String = "",
    val organizationName: String = "",
    val groupName: String = "",
    val l2Name: String = "",
    val l2Contact: String = "",
    val l3Name: String = "",
    val l3Contact: String = "",
    val l4Name: String = "",
    val l4Contact: String = "",
    val note: String = "",
    val safetyTimer: String = "",
    val offTimer: String = ""
)
