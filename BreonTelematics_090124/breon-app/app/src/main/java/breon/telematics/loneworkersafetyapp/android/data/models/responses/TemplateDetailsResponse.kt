package breon.telematics.loneworkersafetyapp.android.data.models.responses


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class TemplateDetailsResponse(
    @SerializedName("data")
    val templatesData: List<TemplateDataResponse>?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("status")
    val status: String?
) {

    @Keep
    data class TemplateDataResponse(
        @SerializedName("Active")
        val active: String?,

        @SerializedName("Address")
        val address: String?,

        @SerializedName("Address2")
        val address2: String?,

        @SerializedName("AssistEmail")
        val assistEmail: String?,

        @SerializedName("AssistSMS")
        val assistSMS: String?,

        @SerializedName("CheckinEmail")
        val checkinEmail: String?,

        @SerializedName("CheckinSMS")
        val checkinSMS: String?,

        @SerializedName("CostCentre")
        val costCentre: String?,

        @SerializedName("Country")
        val country: String?,

        @SerializedName("CreatedDate")
        val createdDate: String?,

        @SerializedName("GeneralEmail")
        val generalEmail: String?,

        @SerializedName("GroupID")
        val groupID: String?,

        @SerializedName("HazardEmail")
        val hazardEmail: String?,

        @SerializedName("HazardSMS")
        val hazardSMS: String?,

        @SerializedName("ID")
        val id: String?,

        @SerializedName("L2Contact")
        val l2Contact: String?,

        @SerializedName("L2Name")
        val l2Name: String?,

        @SerializedName("L3Contact")
        val l3Contact: String?,

        @SerializedName("L3Name")
        val l3Name: String?,

        @SerializedName("L4Contact")
        val l4Contact: String?,

        @SerializedName("L4Name")
        val l4Name: String?,

        @SerializedName("LastModified")
        val lastModified: String?,

        @SerializedName("LastModifiedBy")
        val lastModifiedBy: String?,

        @SerializedName("Latitude")
        val latitude: String?,

        @SerializedName("Longitude")
        val longitude: String?,

        @SerializedName("Name")
        val name: String?,

        @SerializedName("Note")
        val note: String?,

        @SerializedName("OffTimer")
        val offTimer: String?,

        @SerializedName("OrganisationID")
        val organisationId: String?,

        @SerializedName("OverdueEmail")
        val overdueEmail: String?,

        @SerializedName("OverdueSMS")
        val overdueSMS: String?,

        @SerializedName("PostCode")
        val postCode: String?,

        @SerializedName("SMSNotification")
        val smsNotification: String?,

        @SerializedName("SOSEmail")
        val sosEmail: String?,

        @SerializedName("SOSSMS")
        val sosSMS: String?,

        @SerializedName("SafetyTimer")
        val safetyTimer: String?,

        @SerializedName("SignonOffEmail")
        val signOnOffEmail: String?,

        @SerializedName("SignonOffSMS")
        val signOnOffSMS: String?,

        @SerializedName("State")
        val state: String?,

        @SerializedName("Suburb")
        val suburb: String?,

        @SerializedName("SupervisorID")
        val supervisorId: String?,

        @SerializedName("Take2Email")
        val take2Email: String?,

        @SerializedName("Take2SMS")
        val take2SMS: String?,

        @SerializedName("groupName")
        val groupName: String?,

        @SerializedName("isDemo")
        val isDemo: Boolean?,

        @SerializedName("orgName")
        val orgName: String?,

        @SerializedName("templateName")
        val templateName: String?
    )
}