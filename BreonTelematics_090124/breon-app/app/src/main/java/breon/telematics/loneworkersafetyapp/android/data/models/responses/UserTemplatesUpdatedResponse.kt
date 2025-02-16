package breon.telematics.loneworkersafetyapp.android.data.models.responses

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class UserTemplatesUpdatedResponse(
    @SerializedName("ID")
    val templateId: String?,

    @SerializedName("OrganisationID")
    val organisationId: String?,

    @SerializedName("GroupID")
    val groupId: String?,

    @SerializedName("Name")
    val name: String?,

    @SerializedName("SafetyTimer")
    val safetyTimer: String?,

    @SerializedName("OffTimer")
    val offTimer: String?,
)
