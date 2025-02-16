package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import breon.telematics.loneworkersafetyapp.android.R
import breon.telematics.loneworkersafetyapp.android.app.service.BackgroundLocationService
import breon.telematics.loneworkersafetyapp.android.databinding.FragmentDashboardBinding
import breon.telematics.loneworkersafetyapp.android.domain.model.OffDutyStatus
import breon.telematics.loneworkersafetyapp.android.ui.main.activity.MyDashboardActivity
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.adapter.FragmentPagerAdapter
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.assist.AssistFragment
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.checkin.CheckInFragment
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.hazard.HazardFragment
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.sos.SosFragment
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants.ASSIST_TITLE
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants.CHECK_IN_TITLE
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants.HAZARD_TITLE
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants.SOS_TITLE
import breon.telematics.loneworkersafetyapp.android.utils.CurrentStatus
import breon.telematics.loneworkersafetyapp.android.utils.PrefManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DashboardViewModel by viewModels()
    private val titles = listOf(CHECK_IN_TITLE, ASSIST_TITLE, HAZARD_TITLE, SOS_TITLE)

    @Inject
    lateinit var prefManager: PrefManager
    private var username: String = ""
    private val checkInFragment by lazy { CheckInFragment() }
    private val assistFragment by lazy { AssistFragment() }
    private val hazardFragment by lazy { HazardFragment() }
    private val sosFragment by lazy { SosFragment() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        username = prefManager.getString(AppConstants.LOGGED_IN_USERNAME)
        handleUiLogic()
        setUpViewPager()
        observeData()
        return binding.root
    }

    private fun setUpViewPager() {
        val fragments = listOf(checkInFragment, assistFragment, hazardFragment, sosFragment)
        val pagerAdapter = FragmentPagerAdapter(fragments, requireActivity())

        val icons = listOf(
            ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_checkin),
            ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_assistant),
            ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_hazard),
            ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_sos)
        )

        binding.viewpager.adapter = pagerAdapter
        binding.viewpager.registerOnPageChangeCallback(onPageChangeCallback)

        TabLayoutMediator(binding.tablayout, binding.viewpager) { tab, position ->
            tab.text = titles[position]
            tab.icon = icons[position]
            if (position == titles.lastIndex) {
                tab.icon?.setTint(
                    ContextCompat.getColor(
                        requireContext(), R.color.red
                    )
                )
            }
        }.attach()

        binding.tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Handler(Looper.getMainLooper()).postDelayed({
                    tab?.let { selectedTab ->
                        if (selectedTab.text == titles.last()) {
                            selectedTab.icon?.setTint(
                                ContextCompat.getColor(
                                    requireContext(), R.color.red
                                )
                            )
                        }
                    }
                }, 100)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Handler(Looper.getMainLooper()).postDelayed({
                    tab?.let { selectedTab ->
                        if (selectedTab.text == titles.last()) {
                            selectedTab.icon?.setTint(
                                ContextCompat.getColor(
                                    requireContext(), R.color.red
                                )
                            )
                        }
                    }
                }, 100)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        binding.btnSignOn.setOnClickListener {
            (activity as? MyDashboardActivity)?.navigateTo(R.id.nav_sign_on_management)
//            Sentry.captureException(RuntimeException("This app uses Sentry! :)"))
        }
    }

    private fun handleUiLogic() {
        val prefStatus = prefManager.getString(AppConstants.CURRENT_STATUS)
        val status = CurrentStatus.from(prefStatus)
        when (status) {
            CurrentStatus.NotMonitoring -> {
                binding.clTabLayout.visibility = View.GONE
                binding.clSignOn.visibility = View.VISIBLE
            }

            else -> {
                binding.clTabLayout.visibility = View.VISIBLE
                binding.clSignOn.visibility = View.GONE
            }
        }
    }

    private fun observeData() {
        viewModel.deviceWebServiceSmartphone.observe(viewLifecycleOwner) {
            (activity as? MyDashboardActivity)?.navigateTo(R.id.nav_sign_on_management)
        }
    }

    private val onPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            Log.d("PageChange", "onPageSelected: $position")
            binding.tablayout.getTabAt(titles.lastIndex)
                ?.icon
                ?.setTint(
                    ContextCompat.getColor(
                        requireContext(), R.color.red
                    )
                )
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    fun changeUi(status: CurrentStatus) {
        handleUiLogic()
        activity?.stopService(Intent(requireContext(), BackgroundLocationService::class.java))
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    fun openSignOnManagementPage(status: OffDutyStatus) {
        prefManager.putString(AppConstants.CURRENT_STATUS, status.name)
        (activity as? MyDashboardActivity)?.navigateTo(R.id.nav_sign_on_management)
        activity?.stopService(Intent(requireContext(), BackgroundLocationService::class.java))
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onPause() {
        super.onPause()
        EventBus.getDefault().unregister(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.viewpager.unregisterOnPageChangeCallback(onPageChangeCallback)
        _binding = null
    }
}