package breon.telematics.loneworkersafetyapp.android.utils

enum class CurrentStatus(val value: String) {
    Assist("assist"),
    Hazard("hazard"),
    SOS("sos"),
    Safety("safety"),
    Normal("normal"),
    NotMonitoring("not monitoring"),
    OffDuty("offduty");

    companion object {
        fun from(findValue: String?): CurrentStatus =
            CurrentStatus.entries.find {
                it.value == (findValue?.lowercase() ?: "")
            } ?: Normal
    }
}