package breon.telematics.loneworkersafetyapp.android.ui.main.take2form

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import breon.telematics.loneworkersafetyapp.android.BuildConfig
import breon.telematics.loneworkersafetyapp.android.R
import breon.telematics.loneworkersafetyapp.android.databinding.ActivityTake2FormBinding
import breon.telematics.loneworkersafetyapp.android.databinding.RowFormStepOneQuestionsBinding
import breon.telematics.loneworkersafetyapp.android.domain.model.request.SWMSFormValues
import breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormActionsModel
import breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormStep1QuestionsModel
import breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants
import breon.telematics.loneworkersafetyapp.android.utils.PrefManager
import breon.telematics.loneworkersafetyapp.android.utils.UiState
import breon.telematics.loneworkersafetyapp.android.utils.showToast
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@AndroidEntryPoint
class Take2FormActivity : AppCompatActivity() {

	private lateinit var binding: ActivityTake2FormBinding
	private lateinit var swmsValuesAdapter: Take2FormSwmsOptionsAdapter
	private lateinit var taskActionsAdapter: Take2FormActionsAdapter
	private var step3Decision: String = "NO"
	private val questionsModels = ArrayList<Take2FormStep1QuestionsModel>()
	private val stepTwoQuestionsModels = ArrayList<Take2FormStep1QuestionsModel>()
	private val take2FormActionsModels = ArrayList<Take2FormActionsModel>()
	private val swmsFormValues = ArrayList<SWMSFormValues>()
	private val viewModel: Take2FormModelViewModel by viewModels()

	@Inject
	lateinit var pref: PrefManager
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityTake2FormBinding.inflate(layoutInflater)
		setContentView(binding.root)
		initFormData()
		listeners()
		observeState()
		observeLiveData()
	}

	private fun observeLiveData() {
		viewModel.take2FormData.observe(this) { take2FormResponse ->
			if (take2FormResponse != null) {
				val status = take2FormResponse.status.equals("success", true)
				if (status) {
					setResult(RESULT_OK)
					finish()
				}
			}
		}

		viewModel.error.observe(this) {
			showToast(
				it.toString()
			)
		}
	}

	private fun observeState() {
		lifecycleScope.launch {
			repeatOnLifecycle(Lifecycle.State.STARTED) {
				launch {
					viewModel.uiState.collect { uiState ->
						Log.d("CollectionFlow", "observeState: UiState")
						when (uiState) {
							is UiState.Loading -> {
								if (uiState.isLoading) {
									binding.btnSubmit.visibility = View.INVISIBLE
									binding.circularLoader.visibility = View.VISIBLE
								} else {
									binding.btnSubmit.visibility = View.VISIBLE
									binding.circularLoader.visibility = View.INVISIBLE
								}
							}

							is UiState.Success<*> -> {
//								if (binding.clLoadUserData.isVisible.not()) {
//									binding.clLoadUserData.isVisible = true
//									binding.mainContent.isVisible = false
//									binding.appToolbar.root.isVisible = false
//								}
//								binding.tvProgress.text = uiState.data?.toString()
							}

							is UiState.StartNewScreen -> {
								withContext(Dispatchers.Main) {
//									startNewActivity()
								}
							}

							else -> {}
						}
					}
				}
			}
		}
	}

	private fun initFormData() {
		setTaskCompletedDate(Calendar.getInstance())
		addSwms()
		addStepOneQuestions()
		addStepTwoQuestions()
		addActions()
	}

	private fun addSwms() {
		val swmsActions = resources.getStringArray(R.array.swms_values_array)
		for (i in swmsActions.indices) {
			swmsFormValues.add(
				SWMSFormValues(
					swmsActions[i].toString()
				)
			)
		}
		swmsValuesAdapter = Take2FormSwmsOptionsAdapter(swmsFormValues)
		binding.rcvSwmsCheckBox.layoutManager = LinearLayoutManager(this)
		binding.rcvSwmsCheckBox.adapter = swmsValuesAdapter
	}

	private fun setTaskCompletedDate(calendar: Calendar) {
		val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
		val formattedDate = formatter.format(calendar.time)
		binding.tvCompletedDate.text = formattedDate
	}

	private fun addStepOneQuestions() {
		val question = resources.getStringArray(R.array.step_one_questions)
		val questionKey = resources.getStringArray(R.array.step_one_questions_key)

		for (i in question.indices) {
			questionsModels.add(
				Take2FormStep1QuestionsModel(
					question[i].toString(),
					questionKey[i].toString()
				)
			)
		}
		binding.llSteOneOptions.removeAllViews()

		for (questions in questionsModels) {
			val stepOneQuestions: RowFormStepOneQuestionsBinding =
				RowFormStepOneQuestionsBinding.inflate(
					layoutInflater,
					binding.llSteOneOptions,
					false
				)
			stepOneQuestions.tvQuestion.text = questions.question
			stepOneQuestions.tvQuestion.tag = questions.slug

			stepOneQuestions.checkBoxYes.setOnClickListener {
				if (stepOneQuestions.checkBoxNo.isChecked) {
					stepOneQuestions.checkBoxNo.isChecked = false
				}
				questions.value = "Y"
			}

			stepOneQuestions.checkBoxNo.setOnClickListener {
				if (stepOneQuestions.checkBoxYes.isChecked) {
					stepOneQuestions.checkBoxYes.isChecked = false
				}
				questions.value = "N"
			}

			binding.llSteOneOptions.addView(stepOneQuestions.root)
		}
	}

	private fun addStepTwoQuestions() {

		val question = resources.getStringArray(R.array.step_two_questions)
		val questionKey = resources.getStringArray(R.array.step_two_questions_key)

		for (i in question.indices) {
			stepTwoQuestionsModels.add(
				Take2FormStep1QuestionsModel(
					question[i].toString(),
					questionKey[i].toString()
				)
			)
		}
		binding.llStepTwoOptions.removeAllViews()

		for (questions in stepTwoQuestionsModels) {
			val stepOneQuestions: RowFormStepOneQuestionsBinding =
				RowFormStepOneQuestionsBinding.inflate(
					layoutInflater,
					binding.llStepTwoOptions,
					false
				)
			stepOneQuestions.tvQuestion.text = questions.question
			stepOneQuestions.tvQuestion.tag = questions.slug

			stepOneQuestions.checkBoxYes.setOnClickListener {
				if (stepOneQuestions.checkBoxNo.isChecked) {
					stepOneQuestions.checkBoxNo.isChecked = false
				}
				questions.value = "Y"
			}

			stepOneQuestions.checkBoxNo.setOnClickListener {
				if (stepOneQuestions.checkBoxYes.isChecked) {
					stepOneQuestions.checkBoxYes.isChecked = false
				}
				questions.value = "N"
			}

			binding.llStepTwoOptions.addView(stepOneQuestions.root)
		}

	}

	private fun addActions() {
		val actions = resources.getStringArray(R.array.actions_array)
		for (i in actions.indices) {
			take2FormActionsModels.add(
				Take2FormActionsModel(
					actions[i].toString()
				)
			)
		}
		taskActionsAdapter = Take2FormActionsAdapter(take2FormActionsModels)
		binding.rcvActions.layoutManager = LinearLayoutManager(this)
		binding.rcvActions.adapter = taskActionsAdapter
	}


	private fun getStepsAnswer(questionsModels: ArrayList<Take2FormStep1QuestionsModel>): JSONObject {
		val data = JSONObject()
		for (models in questionsModels) {
			data.put(models.slug, models.value)
		}
		return data
	}

	private fun listeners() {

		binding.btnSubmit.setOnClickListener {
			val completedBy = binding.etTaskCompletedBy.text.toString().trim()
			val participants = binding.etParticipants.text.toString().trim()
			val siteName = binding.etSiteName.text.toString().trim()
			val completedDate = binding.tvCompletedDate.text.toString().trim()
			val hazardsAddress = binding.etHazardsAddress.text.toString().trim()
			val step1JsonObject = getStepsAnswer(questionsModels)
			val step2JsonObject = getStepsAnswer(stepTwoQuestionsModels)
			val assetsId = pref.getString(AppConstants.ASSETS_ID)
			val deviceId = pref.getString(AppConstants.DEVICE_ID)

			if (completedBy.isEmpty()) {
				showToast(
					"Enter value for completed by"
				)
			} else if (participants.isEmpty()) {
				showToast(
					"Enter value for participants"
				)
			} else if (siteName.isEmpty()) {
				showToast(
					"Enter value for sites"
				)
			} else if (completedDate.isEmpty()) {
				showToast(
					"Enter value for completed date"
				)
			} else {
				val step3Json = JSONObject()
				step3Json.put("new_hazards_identified", step3Decision)
				step3Json.put("hazards_details", hazardsAddress)
				step3Json.put("safety_controls", "Use anti-slip mats")


//				val step3Json = JSONObject()
//				step3Json.put("new_hazards_identified", step3Decision)
//				step3Json.put("hazards_details", hazardsAddress)
//				step3Json.put("safety_controls", "Use anti-slip mats")

				val turnsType = object : TypeToken<Take2FormSubmitReques.StepOneRequest>() {}.type
				val stepOne = Gson().fromJson<Take2FormSubmitReques.StepOneRequest>(
					step1JsonObject.toString(),
					turnsType
				)

				val stepTwoRequestToken =
					object : TypeToken<Take2FormSubmitReques.StepTwoRequest>() {}.type
				val stepTwo = Gson().fromJson<Take2FormSubmitReques.StepTwoRequest>(
					step2JsonObject.toString(),
					stepTwoRequestToken
				)

				val stepThreeToken =
					object : TypeToken<Take2FormSubmitReques.StepThreeRequest>() {}.type
				val stepThree = Gson().fromJson<Take2FormSubmitReques.StepThreeRequest>(
					step3Json.toString(),
					stepThreeToken
				)

				val map = mapOf<String, Any>(
					"asset_id" to assetsId,
					"deviceID" to deviceId,
					"apikey" to BuildConfig.API_KEY,
					"activity_summary" to "Inspecting site hazards and risks.",
					"completed_by" to completedBy,
					"participants" to participants,
					"site" to siteName,
					"date" to completedDate,
					"swms_reviewed" to swmsValuesAdapter.getSwmsValues(),
					"step1_responses" to stepOne,
					"step2_responses" to stepTwo,
					"step3_decision" to stepThree,
					"action" to taskActionsAdapter.getSelectedActions(),
					"remarks" to ""
				)

				val take2Form =
					Take2FormSubmitReques(
						asset_id = "AST_66da71e4f37c5",
						deviceID = deviceId,
						apikey = BuildConfig.API_KEY,
						activity_summary = "Inspecting site hazards and risks.",
						completed_by = completedBy,
						participants = participants,
						site = siteName,
						date = completedDate,
						swms_reviewed = swmsValuesAdapter.getSwmsValues(),
						step1_responses = stepOne,
						step2_responses = stepTwo,
						step3_decision = stepThree,
						action = taskActionsAdapter.getSelectedActions(),
						remarks = "",
					)

				viewModel.submitTake2Form(map)
			}
		}

		binding.tvCompletedDate.setOnClickListener {
			openDatePickerDialog()
		}

		binding.cbDecideYes.setOnClickListener {
			step3Decision = "YES"
			binding.cbDecideYes.isChecked = true
			binding.cbDecideNo.isChecked = false
			binding.llHazardsControlAddress.visibility = View.VISIBLE
		}

		binding.cbDecideNo.setOnClickListener {
			step3Decision = "No"
			binding.cbDecideYes.isChecked = false
			binding.cbDecideNo.isChecked = true
			binding.etHazardsAddress.text.clear()
			binding.llHazardsControlAddress.visibility = View.GONE
		}

	}

	private fun openDatePickerDialog() {
		val calendar = Calendar.getInstance()
		val year = calendar.get(Calendar.YEAR)
		val month = calendar.get(Calendar.MONTH)
		val day = calendar.get(Calendar.DAY_OF_MONTH)

		// Create a DatePickerDialog
		val datePickerDialog = DatePickerDialog(
			this,
			{ _, selectedYear, selectedMonth, selectedDay ->
				val selectedDate = Calendar.getInstance()
				selectedDate.set(Calendar.YEAR, selectedYear)
				selectedDate.set(Calendar.MONTH, selectedMonth)
				selectedDate.set(Calendar.DAY_OF_MONTH, selectedDay)
				setTaskCompletedDate(selectedDate)
			},
			year,
			month,
			day
		)
		datePickerDialog.show()
	}

}