package breon.telematics.loneworkersafetyapp.android.ui.main.activity;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\u001f\u001a\u00020\u0015H\u0014J\b\u0010 \u001a\u00020\u0015H\u0014J\b\u0010!\u001a\u00020\"H\u0016J\u000e\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0006J\u000e\u0010\'\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0006J\u0006\u0010(\u001a\u00020\u0015J\u0006\u0010)\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/ui/main/activity/MyDashboardActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "appBarConfiguration", "Landroidx/navigation/ui/AppBarConfiguration;", "assistStateListener", "Lbreon/telematics/loneworkersafetyapp/android/ui/main/callback/OnAssetDetailFetchListener;", "binding", "Lbreon/telematics/loneworkersafetyapp/android/databinding/ActivityMyDashboardBinding;", "checkingStateListener", "hazardStateListener", "navController", "Landroidx/navigation/NavController;", "prefManager", "Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "getPrefManager", "()Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "setPrefManager", "(Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;)V", "sosStateListener", "navigateTo", "", "resourceId", "", "bundle", "Landroid/os/Bundle;", "onCreate", "savedInstanceState", "onEvent", "assetDetail", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/AssetDetails;", "onStart", "onStop", "onSupportNavigateUp", "", "setAssistStateListener", "listener", "setCheckInStateListener", "setHazardStateListener", "setSOSStateListener", "startBackgroundService", "stopBackgroundService", "app_debug"})
public final class MyDashboardActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.navigation.ui.AppBarConfiguration appBarConfiguration;
    private breon.telematics.loneworkersafetyapp.android.databinding.ActivityMyDashboardBinding binding;
    private androidx.navigation.NavController navController;
    @org.jetbrains.annotations.Nullable()
    private breon.telematics.loneworkersafetyapp.android.ui.main.callback.OnAssetDetailFetchListener checkingStateListener;
    @org.jetbrains.annotations.Nullable()
    private breon.telematics.loneworkersafetyapp.android.ui.main.callback.OnAssetDetailFetchListener assistStateListener;
    @org.jetbrains.annotations.Nullable()
    private breon.telematics.loneworkersafetyapp.android.ui.main.callback.OnAssetDetailFetchListener hazardStateListener;
    @org.jetbrains.annotations.Nullable()
    private breon.telematics.loneworkersafetyapp.android.ui.main.callback.OnAssetDetailFetchListener sosStateListener;
    @javax.inject.Inject()
    public breon.telematics.loneworkersafetyapp.android.utils.PrefManager prefManager;
    
    public MyDashboardActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.utils.PrefManager getPrefManager() {
        return null;
    }
    
    public final void setPrefManager(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.utils.PrefManager p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    public final void navigateTo(@androidx.annotation.IdRes()
    int resourceId, @org.jetbrains.annotations.Nullable()
    android.os.Bundle bundle) {
    }
    
    public final void startBackgroundService() {
    }
    
    public final void stopBackgroundService() {
    }
    
    public final void setCheckInStateListener(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.ui.main.callback.OnAssetDetailFetchListener listener) {
    }
    
    public final void setAssistStateListener(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.ui.main.callback.OnAssetDetailFetchListener listener) {
    }
    
    public final void setHazardStateListener(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.ui.main.callback.OnAssetDetailFetchListener listener) {
    }
    
    public final void setSOSStateListener(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.ui.main.callback.OnAssetDetailFetchListener listener) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN_ORDERED)
    public final void onEvent(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails assetDetail) {
    }
}