package breon.telematics.loneworkersafetyapp.android.domain.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/domain/network/NetworkConnectivity;", "Lbreon/telematics/loneworkersafetyapp/android/domain/network/NetworkStatus;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "observe", "Lkotlinx/coroutines/flow/Flow;", "Lbreon/telematics/loneworkersafetyapp/android/domain/network/NetworkStatus$Status;", "app_debug"})
public final class NetworkConnectivity implements breon.telematics.loneworkersafetyapp.android.domain.network.NetworkStatus {
    @org.jetbrains.annotations.NotNull()
    private final android.net.ConnectivityManager connectivityManager = null;
    
    public NetworkConnectivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<breon.telematics.loneworkersafetyapp.android.domain.network.NetworkStatus.Status> observe() {
        return null;
    }
}