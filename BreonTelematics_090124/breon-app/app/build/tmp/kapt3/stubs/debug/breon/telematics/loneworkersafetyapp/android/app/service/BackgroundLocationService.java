package breon.telematics.loneworkersafetyapp.android.app.service;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u0000 I2\u00020\u0001:\u0002IJB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010.\u001a\u00020/H\u0002J\u001e\u00100\u001a\u00020/2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000202H\u0082@\u00a2\u0006\u0002\u00104J\u000e\u00105\u001a\u00020/H\u0082@\u00a2\u0006\u0002\u00106J\b\u00107\u001a\u00020/H\u0002J\u0012\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020/H\u0016J\b\u0010=\u001a\u00020/H\u0016J\"\u0010>\u001a\u00020?2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020?H\u0016J\u0012\u0010B\u001a\u00020/2\b\u0010C\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010D\u001a\u00020/H\u0002J\b\u0010E\u001a\u00020/H\u0002J\b\u0010F\u001a\u00020/H\u0002J\b\u0010G\u001a\u00020/H\u0003J\u0006\u0010H\u001a\u00020/R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00060\u0007R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u000e\u0010(\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006K"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/app/service/BackgroundLocationService;", "Landroid/app/Service;", "()V", "_locationFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroid/location/Location;", "binder", "Lbreon/telematics/loneworkersafetyapp/android/app/service/BackgroundLocationService$LocalBinder;", "breonService", "Lbreon/telematics/loneworkersafetyapp/android/data/services/BreonService;", "getBreonService", "()Lbreon/telematics/loneworkersafetyapp/android/data/services/BreonService;", "setBreonService", "(Lbreon/telematics/loneworkersafetyapp/android/data/services/BreonService;)V", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getFusedLocationClient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "setFusedLocationClient", "(Lcom/google/android/gms/location/FusedLocationProviderClient;)V", "handler", "Landroid/os/Handler;", "isRunning", "", "locationCallback", "Lcom/google/android/gms/location/LocationCallback;", "locationFlow", "Lkotlinx/coroutines/flow/StateFlow;", "networkConnectivity", "Lbreon/telematics/loneworkersafetyapp/android/domain/network/NetworkConnectivity;", "getNetworkConnectivity", "()Lbreon/telematics/loneworkersafetyapp/android/domain/network/NetworkConnectivity;", "setNetworkConnectivity", "(Lbreon/telematics/loneworkersafetyapp/android/domain/network/NetworkConnectivity;)V", "pref", "Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "getPref", "()Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "setPref", "(Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;)V", "runnable", "Ljava/lang/Runnable;", "serviceJob", "Lkotlinx/coroutines/CompletableJob;", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "callGetAssetDetailApi", "", "callLocationApi", "latitude", "", "longitude", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAssetDetails", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeLocation", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "", "flags", "startId", "sendDataToServer", "location", "sendNotification", "setupLocationUpdates", "startAsForegroundService", "startLocationUpdates", "stopForegroundService", "Companion", "LocalBinder", "app_debug"})
public final class BackgroundLocationService extends android.app.Service {
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.app.service.BackgroundLocationService.LocalBinder binder = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CompletableJob serviceJob = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope serviceScope = null;
    @javax.inject.Inject()
    public breon.telematics.loneworkersafetyapp.android.domain.network.NetworkConnectivity networkConnectivity;
    @javax.inject.Inject()
    public breon.telematics.loneworkersafetyapp.android.data.services.BreonService breonService;
    @javax.inject.Inject()
    public breon.telematics.loneworkersafetyapp.android.utils.PrefManager pref;
    @javax.inject.Inject()
    public com.google.android.gms.location.FusedLocationProviderClient fusedLocationClient;
    private com.google.android.gms.location.LocationCallback locationCallback;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler handler = null;
    private boolean isRunning = false;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<android.location.Location> _locationFlow = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.StateFlow<? extends android.location.Location> locationFlow;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTIFICATION_CHANNEL_ID = "my_notification_channel";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "ExampleForegroundService";
    private static final long LOCATION_UPDATES_INTERVAL_MS = 0L;
    private static final long MONITORING_INTERVAL_MS = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Runnable runnable = null;
    @org.jetbrains.annotations.NotNull()
    public static final breon.telematics.loneworkersafetyapp.android.app.service.BackgroundLocationService.Companion Companion = null;
    
    public BackgroundLocationService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.domain.network.NetworkConnectivity getNetworkConnectivity() {
        return null;
    }
    
    public final void setNetworkConnectivity(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.network.NetworkConnectivity p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.data.services.BreonService getBreonService() {
        return null;
    }
    
    public final void setBreonService(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.data.services.BreonService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.utils.PrefManager getPref() {
        return null;
    }
    
    public final void setPref(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.utils.PrefManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.location.FusedLocationProviderClient getFusedLocationClient() {
        return null;
    }
    
    public final void setFusedLocationClient(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.location.FusedLocationProviderClient p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
        return null;
    }
    
    private final void observeLocation() {
    }
    
    private final void sendDataToServer(android.location.Location location) {
    }
    
    private final void startAsForegroundService() {
    }
    
    private final void sendNotification() {
    }
    
    /**
     * Stops the foreground service and removes the notification.
     * Can be called from inside or outside the service.
     */
    public final void stopForegroundService() {
    }
    
    /**
     * Sets up the location updates using the FusedLocationProviderClient, but doesn't actually start them.
     * To start the location updates, call [startLocationUpdates].
     */
    private final void setupLocationUpdates() {
    }
    
    /**
     * Starts the location updates using the FusedLocationProviderClient.
     */
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void startLocationUpdates() {
    }
    
    private final java.lang.Object callLocationApi(java.lang.String latitude, java.lang.String longitude, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void callGetAssetDetailApi() {
    }
    
    private final java.lang.Object getAssetDetails(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/app/service/BackgroundLocationService$Companion;", "", "()V", "LOCATION_UPDATES_INTERVAL_MS", "", "MONITORING_INTERVAL_MS", "NOTIFICATION_CHANNEL_ID", "", "TAG", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/app/service/BackgroundLocationService$LocalBinder;", "Landroid/os/Binder;", "(Lbreon/telematics/loneworkersafetyapp/android/app/service/BackgroundLocationService;)V", "getService", "Lbreon/telematics/loneworkersafetyapp/android/app/service/BackgroundLocationService;", "app_debug"})
    public final class LocalBinder extends android.os.Binder {
        
        public LocalBinder() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final breon.telematics.loneworkersafetyapp.android.app.service.BackgroundLocationService getService() {
            return null;
        }
    }
}