package breon.telematics.loneworkersafetyapp.android.ui.main.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import breon.telematics.loneworkersafetyapp.android.R
import breon.telematics.loneworkersafetyapp.android.app.service.BackgroundLocationService
import breon.telematics.loneworkersafetyapp.android.databinding.ActivityMyDashboardBinding
import breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails
import breon.telematics.loneworkersafetyapp.android.ui.main.callback.OnAssetDetailFetchListener
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants
import breon.telematics.loneworkersafetyapp.android.utils.CurrentStatus
import breon.telematics.loneworkersafetyapp.android.utils.PrefManager
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject

@AndroidEntryPoint
class MyDashboardActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMyDashboardBinding
    private lateinit var navController: NavController
    private var checkingStateListener: OnAssetDetailFetchListener? = null
    private var assistStateListener: OnAssetDetailFetchListener? = null
    private var hazardStateListener: OnAssetDetailFetchListener? = null
    private var sosStateListener: OnAssetDetailFetchListener? = null

    @Inject
    lateinit var prefManager: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_dashboard)

        setSupportActionBar(binding.appBarMyDashboard.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        navController = findNavController(R.id.nav_host_fragment_content_my_dashboard)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_dashboard, R.id.nav_sign_on_management, R.id.nav_settings, R.id.nav_about
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.itemDashboard -> {
                    navController.navigate(R.id.nav_dashboard)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.itemSignOnManagement -> {
                    navController.navigate(R.id.nav_sign_on_management)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.itemSettings -> {
                    navController.navigate(R.id.nav_settings)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.itemAbout -> {
                    navController.navigate(R.id.nav_about)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                else -> {
                    false
                }
            }
        }

       val backButton =  binding.navView.getHeaderView(0).findViewById<ImageView>(R.id.imageView)
        backButton?.setOnClickListener {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_my_dashboard)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun navigateTo(@IdRes resourceId: Int, bundle: Bundle? = null) {
        if (bundle != null)
            navController.navigate(resourceId, bundle)
        else navController.navigate(resourceId)
    }

    fun startBackgroundService() {
        val intent = Intent(this@MyDashboardActivity, BackgroundLocationService::class.java)
        startForegroundService(intent)
        //bindService(intent, mConnection, Context.BIND_AUTO_CREATE)
    }

    fun stopBackgroundService() {
        stopService(Intent(this@MyDashboardActivity, BackgroundLocationService::class.java))
    }

    fun setCheckInStateListener(listener: OnAssetDetailFetchListener) {
        this.checkingStateListener = listener
    }

    fun setAssistStateListener(listener: OnAssetDetailFetchListener) {
        this.assistStateListener = listener
    }

    fun setHazardStateListener(listener: OnAssetDetailFetchListener) {
        this.hazardStateListener = listener
    }

    fun setSOSStateListener(listener: OnAssetDetailFetchListener) {
        this.sosStateListener = listener
    }


    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        //Unregister Event Bus
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    fun onEvent(assetDetail: AssetDetails) {
        Log.d("GetAssetDetailAPI", "ACTIVITY : ${assetDetail.id}")
        val status = CurrentStatus.from(assetDetail.status)
//        val status = when (assetDetail.status) {
//            "Not monitoring" -> CurrentStatus.NotMonitoring
//            "Off Duty" -> CurrentStatus.OffDuty
//            else -> CurrentStatus.valueOf(assetDetail.status)
//        }
        prefManager.putString(AppConstants.CURRENT_STATUS, status.value)
        checkingStateListener?.onAssetDetailsFetched(assetDetail)
        assistStateListener?.onAssetDetailsFetched(assetDetail)
        hazardStateListener?.onAssetDetailsFetched(assetDetail)
        sosStateListener?.onAssetDetailsFetched(assetDetail)
    }
}