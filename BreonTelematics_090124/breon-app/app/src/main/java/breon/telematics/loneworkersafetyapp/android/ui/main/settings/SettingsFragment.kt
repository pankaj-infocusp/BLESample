package breon.telematics.loneworkersafetyapp.android.ui.main.settings

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import breon.telematics.loneworkersafetyapp.android.R
import breon.telematics.loneworkersafetyapp.android.databinding.FragmentSettingsBinding
import breon.telematics.loneworkersafetyapp.android.domain.model.request.ConfirmOrUpdateDetailsRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.request.UpdateTemplateRequest
import breon.telematics.loneworkersafetyapp.android.domain.model.response.UserTemplatesUpdated
import breon.telematics.loneworkersafetyapp.android.ui.main.activity.UserPermissionActivity
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants
import breon.telematics.loneworkersafetyapp.android.utils.CurrentStatus
import breon.telematics.loneworkersafetyapp.android.utils.PrefManager
import breon.telematics.loneworkersafetyapp.android.utils.UiState
import breon.telematics.loneworkersafetyapp.android.utils.createAlertDialog
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.lang.reflect.Type
import javax.inject.Inject
import kotlin.time.Duration.Companion.minutes

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val viewModel: SettingsViewModel by viewModels()
    private val binding get() = _binding!!
    @Inject
    lateinit var prefManager: PrefManager
    private var arrayList: ArrayList<UserTemplatesUpdated.UserTemplatesUpdatedItem>? = null
    var templateId: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        binding.tvLocationTracking.text =
            getString(R.string.location_tracking_interval).format("5", "60 ")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefManager = PrefManager(requireContext())
        handleUi()
        observeState()
        initClickEvents()
        getSharePrefTemplates()
        setSeekBarListener()
    }

    private fun getSharePrefTemplates() {
        var templates: List<UserTemplatesUpdated.UserTemplatesUpdatedItem> = emptyList()
        val serializedObject = prefManager.getString(AppConstants.USER_TEMPLATES)
        Log.d("TemplatesData", "serializedObject data: $serializedObject")
        if (serializedObject.isNotEmpty()) {
            val type: Type =
                object : TypeToken<List<UserTemplatesUpdated.UserTemplatesUpdatedItem>>() {}.type
            templates = Gson().fromJson(serializedObject, type)
            Log.d("TemplatesData", "templates data: $templates")
        }
        if (arrayList == null) {
            arrayList = ArrayList()
        }

        arrayList?.addAll(templates)
        getStringArray()
    }

    private fun getStringArray() {
        if (arrayList != null && arrayList?.isNotEmpty() == true) {
            val templateNames = arrayList?.map { it.name }?.toMutableList() ?: emptyList<String>()
            val arrayAdapter = activity?.let {
                ArrayAdapter<String>(it, R.layout.dropdown_item, templateNames)
            }
            arrayAdapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            // Set adapter to Spinner
            binding.etGetSelectSafetyTemplate.adapter = arrayAdapter

            val pos = prefManager.getInt(AppConstants.SELECTED_TEMP_POS)
            binding.etGetSelectSafetyTemplate.setSelection(pos)

            // Set click listener on Spinner
            binding.etGetSelectSafetyTemplate.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        templateId = arrayList?.get(position)?.templateId.orEmpty()
                        val safetyTime = "${arrayList?.get(position)?.safetyTimer ?: 0} minutes"
                        val signOffTime = "${arrayList?.get(position)?.offTimer ?: 0} hours"

                        /*val localTime = LocalTime.parse(safetyTime)
                        val duration = Duration.between(LocalTime.MIN, localTime)
                        val durationInMin = "${duration.toMinutes()} minutes"

                        val localTimeSignOff = LocalTime.parse(signOffTime)
                        val signOffDuration = Duration.between(LocalTime.MIN, localTimeSignOff)
                        val durationInHour = "${signOffDuration.toHours()} hours"*/

                        binding.etSafetyTimer.editText?.setText(safetyTime)
                        binding.etSignOffTime.editText?.setText(signOffTime)

                        viewModel.getTemplateDetailsById(templateId)
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                        // Do nothing
                    }
                }
        }
    }

    private fun handleUi() {
        val prefStatus = prefManager.getString(AppConstants.CURRENT_STATUS)
        val status = CurrentStatus.entries.find { it.value == prefStatus }
        when (status) {
            CurrentStatus.NotMonitoring, CurrentStatus.OffDuty -> {
                binding.settingsContent.isVisible = true
                binding.disableLayout.unavailableContent.isVisible = false
            }

            else -> {
                binding.settingsContent.isVisible = false
                binding.disableLayout.unavailableContent.isVisible = true
            }
        }
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    when (uiState) {
                        is UiState.Loading -> {
                            if (uiState.isLoading) {
                                binding.btnLogOff.visibility = View.INVISIBLE
                                binding.btnSave.visibility = View.INVISIBLE
                                binding.circularLoader.visibility = View.VISIBLE
                            } else {
                                binding.btnLogOff.visibility = View.VISIBLE
                                binding.btnSave.visibility = View.VISIBLE
                                binding.circularLoader.visibility = View.INVISIBLE
                            }
                        }

                        else -> {}
                    }
                }
            }
        }

        viewModel.confirmOrUpdateOrTemplate.observe(viewLifecycleOwner) {
            if (it != null) {
//                Toast.makeText(requireContext(), "Details updated!", Toast.LENGTH_SHORT).show()
                val contact = binding.etGetContactName.text?.toString().orEmpty()
                val phone = binding.etGetContactPhone.text?.toString().orEmpty()
                prefManager.putString(AppConstants.CONTACT, contact)
                prefManager.putString(AppConstants.PHONE, phone)
            }
        }

        viewModel.templatesDetails.observe(viewLifecycleOwner) { details ->
            if (details != null) {
                binding.run {
                    tvTemplateNameValue.text = details.templateName
                    tvOrgNameValue.text = details.organizationName
                    tvGroupNameValue.text = details.groupName
                    val l2nameContact = "${details.l2Name} ${details.l2Contact}"
                    if (l2nameContact.trim().isNotEmpty())
                        tvL2NameContactValue.text = l2nameContact
                    val l3nameContact = "${details.l3Name} ${details.l3Contact}"
                    if (l3nameContact.trim().isNotEmpty())
                        tvL3NameContactValue.text = l3nameContact
                    val l4nameContact = "${details.l4Name} ${details.l4Contact}"
                    if (l4nameContact.trim().isNotEmpty())
                        tvL4NameContactValue.text = l4nameContact
                    tvNoteValue.text = details.note
                    tvCheckinDurationValue.text = details.safetyTimer
                    tvShiftDurationValue.text = details.offTimer
                }
            }
        }
    }

    private fun initClickEvents() {
        // get details from login page userDetails
        val username = prefManager.getString(AppConstants.LOGGED_IN_USERNAME)
        val assetsId = prefManager.getString(AppConstants.ASSETS_ID)
        val prefContact = prefManager.getString(AppConstants.CONTACT)
        val prefPhone = prefManager.getString(AppConstants.PHONE)
        val email = prefManager.getString(AppConstants.EMAIL)
        binding.etGetContactName.setText(prefContact)
        binding.etGetContactPhone.setText(prefPhone)

        binding.btnSave.setOnClickListener {
            val confirmOrUpdateDetailsRequest =
                ConfirmOrUpdateDetailsRequest(
                    assetId = assetsId,
                    contact = binding.etGetContactName.text?.toString().orEmpty(),
                    phone = binding.etGetContactPhone.text?.toString().orEmpty(),
                    email = email
                )

            val updateTemplateRequest =
                UpdateTemplateRequest(
                    callsign = username,
                    templateId = templateId
                )

            val selectedTempPos = binding.etGetSelectSafetyTemplate.selectedItemPosition
            if (arrayList != null && selectedTempPos >= 0) {
                prefManager.putInt(AppConstants.SELECTED_TEMP_POS, selectedTempPos)
                val safetyTimer = arrayList?.get(selectedTempPos)?.safetyTimer
                safetyTimer?.let {
                    prefManager.putLong(
                        AppConstants.SAFETY_TIMER,
                        it.toInt().minutes.inWholeMilliseconds
                    )
                }
            }
            viewModel.confirmDetails(confirmOrUpdateDetailsRequest, updateTemplateRequest)
        }

        binding.btnLogOff.setOnClickListener {
            createAlertDialog(
                context = requireContext(),
                title = getString(R.string.logoff),
                message = getString(R.string.are_you_sure_you_want_to_log_off),
                positiveBtnText = "Yes",
                negativeBtnText = "No",
                onPositiveBtnClick = {
                    prefManager.clearPreference()
                    startActivity(Intent(context, UserPermissionActivity::class.java))
                    activity?.finish()
                },
                onNegativeBtnClick = {}
            )
        }

        binding.btnMinus.setOnClickListener {
            binding.seekbar.progress -= 1
        }

        binding.btnPlus.setOnClickListener {
            binding.seekbar.progress += 1
        }
    }

    private fun setSeekBarListener() {
        binding.seekbar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.tvLocationTracking.text =
                    getString(R.string.location_tracking_interval).format("$progress", "60 ")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                val progress = seekBar?.progress ?: 0
                binding.tvLocationTracking.text =
                    getString(R.string.location_tracking_interval).format("$progress", "60 ")
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}