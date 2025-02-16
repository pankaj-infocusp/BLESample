package breon.telematics.loneworkersafetyapp.android.utils

object AppConstants {
	const val DEVICE_ID= "DEVICE_ID"

	// Shared Pref Constants
	const val IS_LOGGED_IN = "IS_LOGGED_IN"
	const val IS_SIGN_IN = "IS_SIGN_IN"
	const val LOGGED_IN_USERNAME = "LOGGED_IN_USERNAME"
	const val SIGN_ON_USERNAME = "SIGN_ON_USERNAME"
	const val LOGGED_IN_PASSWORD = "LOGGED_IN_PASSWORD"
	const val SIGNED_IN_PHONE = "SIGNED_IN_PHONE"
	const val USER_TEMPLATES = "user_templates"
	const val ASSETS_ID = "assets_id"
	const val CONTACT = "contact"
	const val PHONE = "phone"
	const val EMAIL = "email"
	const val SELECTED_TEMP_POS = "selected_template_position"
	const val SAFETY_TIMER = "safety_timer_value"
	const val TEMPLATE_TIME = "template_timer_value"
	const val HAZARD_TIMER = "hazard_timer_value"
	const val CURRENT_STATUS = "current_status"
	const val HAZARD_SELECTED_TIME = "hazard_selected_time"
	const val LAST_CHECK_IN_TIME = "last_check_in_time"

	// Fragments Title
	const val CHECK_IN_TITLE = "CHECK IN"
	const val ASSIST_TITLE = "ASSIST"
	const val HAZARD_TITLE = "HAZARD"
	const val SOS_TITLE = "SOS"

	// Actions for Checkin, Assist, Hazard, Sos
	const val ACTION_ASSIST = "Assist"
	const val ACTION_CANCEL_ASSIST = "CancelAssist"
	const val ACTION_HAZARD = "Hazard"
	const val ACTION_CANCEL_HAZARD = "CancelHazard"
	const val ACTION_SOS = "SOS"
	const val ACTION_CANCEL_SOS = "CancelSOS"
	const val ACTION_SIGN_ON = "Signon"
	const val ACTION_SIGN_OFF = "Signoff"
}