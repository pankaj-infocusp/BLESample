package breon.telematics.loneworkersafetyapp.android.app.service

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.content.pm.ServiceInfo
import android.location.Location
import android.os.Binder
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import androidx.core.app.ServiceCompat
import breon.telematics.loneworkersafetyapp.android.app.MyApplication
import breon.telematics.loneworkersafetyapp.android.data.models.mapper.toDomain
import breon.telematics.loneworkersafetyapp.android.data.services.BreonService
import breon.telematics.loneworkersafetyapp.android.domain.model.request.LocationTrackingRequest
import breon.telematics.loneworkersafetyapp.android.domain.network.NetworkConnectivity
import breon.telematics.loneworkersafetyapp.android.domain.network.NetworkStatus
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants
import breon.telematics.loneworkersafetyapp.android.utils.NotificationsHelper
import breon.telematics.loneworkersafetyapp.android.utils.PrefManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

@AndroidEntryPoint
class BackgroundLocationService : Service() {

    private val binder = LocalBinder()
    private val serviceJob = Job()
    private val serviceScope = CoroutineScope(Dispatchers.IO + serviceJob)
    @Inject
    lateinit var networkConnectivity: NetworkConnectivity
    @Inject
    lateinit var breonService: BreonService
    @Inject
    lateinit var pref: PrefManager
    @Inject
    lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback
    private val handler = Handler(Looper.getMainLooper())
    private var isRunning = false

    private val _locationFlow = MutableStateFlow<Location?>(null)
    private var locationFlow: StateFlow<Location?> = _locationFlow

    inner class LocalBinder : Binder() {
        fun getService(): BackgroundLocationService = this@BackgroundLocationService
    }

    companion object {
        const val NOTIFICATION_CHANNEL_ID = "my_notification_channel"
        private const val TAG = "ExampleForegroundService"
        private val LOCATION_UPDATES_INTERVAL_MS = 5.minutes.inWholeMilliseconds
        private val MONITORING_INTERVAL_MS = 10.seconds.inWholeMilliseconds
    }

    override fun onCreate() {
        super.onCreate()
        setupLocationUpdates()
        observeLocation()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startAsForegroundService()
//        sendNotification()
        startLocationUpdates()
        if (isRunning.not()) {
            Log.d("CheckRunnable", "Service is running: ")
            handler.post(runnable)
        }

        // If you want the service to continue running until explicitly stopped
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }

    private fun observeLocation() {
        serviceScope.launch {
            locationFlow.collect { location ->
                location?.let {
                    callLocationApi(
                        location.latitude.toString(),
                        location.longitude.toString()
                    )
                }
            }
        }
    }

    private fun sendDataToServer(location: Location?) {
        serviceScope.launch {
            networkConnectivity.observe().collect {
                when(it) {
                    NetworkStatus.Status.Unavailable -> {}
                    NetworkStatus.Status.Available -> {
                        location?.let {
                            callLocationApi(
                                location.latitude.toString(),
                                location.longitude.toString()
                            )
                        }
                    }
                    else -> {}
                }
            }
        }
    }

    private fun startAsForegroundService() {
        // create the notification channel
        NotificationsHelper.createNotificationChannel(this)

        // promote service to foreground service
        ServiceCompat.startForeground(
            this,
            101,
            NotificationsHelper.buildNotification(this),
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                ServiceInfo.FOREGROUND_SERVICE_TYPE_LOCATION
            } else {
                0
            }
        )
    }

    private fun sendNotification() {
        NotificationsHelper.sendNotification(this)
    }

    /**
     * Stops the foreground service and removes the notification.
     * Can be called from inside or outside the service.
     */
    fun stopForegroundService() {
        Log.d("GetAssetDetailAPI", "stopForegroundService stopSelf() called")
        stopSelf()
    }

    /**
     * Sets up the location updates using the FusedLocationProviderClient, but doesn't actually start them.
     * To start the location updates, call [startLocationUpdates].
     */
    private fun setupLocationUpdates() {
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                for (location in locationResult.locations) {
                    _locationFlow.value = location
                    Log.d(TAG, "onLocationResult Latitude : ${location?.latitude}")
                    Log.d(TAG, "onLocationResult Longitude : ${location?.longitude}")
                }
            }
        }
    }

    /**
     * Starts the location updates using the FusedLocationProviderClient.
     */
    @SuppressLint("MissingPermission")
    private fun startLocationUpdates() {
        val locationRequest = LocationRequest.create()
        locationRequest.setInterval(LOCATION_UPDATES_INTERVAL_MS)
        fusedLocationClient.requestLocationUpdates(
            locationRequest, locationCallback, Looper.getMainLooper()
        )
    }

    private suspend fun callLocationApi(latitude: String, longitude: String) {
        val assetId = pref.getString(AppConstants.ASSETS_ID)
        val locationTrackingRequest =
            LocationTrackingRequest(
                assetID = assetId,
                interval = "5",
                latitude = latitude,
                longitude = longitude
            )

        runCatching {
            breonService.sendLocation(
                assetID = assetId,
                interval = "5",
                latitude = latitude,
                longitude = longitude
            )
        }.onSuccess {
            val message = it.message
            Log.d(TAG, "callLocationApi Success: $message")
        }.onFailure {
            Log.d(TAG, "callLocationApi Error: ${it.message}")
        }
    }

    private val runnable = object : Runnable {
        override fun run() {
            isRunning = true
            callGetAssetDetailApi()
            handler.postDelayed(this, MONITORING_INTERVAL_MS)
        }
    }

    private fun callGetAssetDetailApi() {
        serviceScope.launch(Dispatchers.IO) {
            getAssetDetails()
        }
    }

    private suspend fun getAssetDetails() {
        runCatching {
            val assetId = pref.getString(AppConstants.ASSETS_ID)
            breonService.getAssetDetails(assetId)
        }.onSuccess {
            EventBus.getDefault().post(it.toDomain())
            Log.d("GetAssetDetailAPI", "SERVICE : ${it.id}")
        }.onFailure {
            Log.d("GetAssetDetailAPI", "Api Error: ${it.message}")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("GetAssetDetailAPI", "onDestroy")
        // Cancel the job when service is destroyed
        serviceScope.cancel()
        handler.removeCallbacks(runnable)
    }
}