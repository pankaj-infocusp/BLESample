package breon.telematics.loneworkersafetyapp.android.data.models.responses


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class AssetsDetailsResponse(
    @SerializedName("Contact")
    val contact: String?,

    @SerializedName("Email")
    val email: String?,

    @SerializedName("HazardTimer")
    val hazardTimer: String?,

    @SerializedName("HazardTimerStartedTime")
    val hazardTimerStartedTime: String?,

    @SerializedName("ID")
    val id: String?,

    @SerializedName("IMEI")
    val iMEI: String?,

    @SerializedName("LastCheckin")
    val lastCheckIn: String?,

    @SerializedName("LastSignedOn")
    val lastSignedOn: String?,

    @SerializedName("OffTimer")
    val offTimer: String?,

    @SerializedName("Phone")
    val phone: String?,

    @SerializedName("SafetyTimer")
    val safetyTimer: String?,

    @SerializedName("Status")
    val status: String?,

    @SerializedName("TemplateName")
    val templateName: String?,

    @SerializedName("TrackingInterval")
    val trackingInterval: String?,

    @SerializedName("TrackingOn")
    val trackingOn: String?
)