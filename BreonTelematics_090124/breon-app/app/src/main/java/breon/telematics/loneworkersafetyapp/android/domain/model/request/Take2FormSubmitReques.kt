package breon.telematics.loneworkersafetyapp.android.domain.model.request

import androidx.annotation.Keep

@Keep
data class Take2FormSubmitReques(
	val asset_id: String,
	val deviceID: String,
	val apikey: String,
	val activity_summary: String,
	val completed_by: String,
	val participants: String,
	val site: String,
	val date: String,
	val swms_reviewed: ArrayList<String>,
	val step1_responses: StepOneRequest,
	val step2_responses: StepTwoRequest,
	val step3_decision: StepThreeRequest,
	val action: ArrayList<String>,
	val remarks: String,
) {
	@Keep
	data class StepOneRequest(
		val understand_risks: String,
		val know_injury: String,
		val access_knowledge_confidence: String,
		val mandatory_ppe: String
	)

	@Keep
	data class StepTwoRequest(
		val unsure_circumstances: String,
		val checked_resources: String,
		val hazard_significance: String,
		val additional_controls: String
	)

	@Keep
	data class StepThreeRequest(
		val new_hazards_identified: String,
		val hazards_details: String,
		val safety_controls: String
	)
}