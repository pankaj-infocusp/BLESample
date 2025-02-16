package breon.telematics.loneworkersafetyapp.android.ui.login;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\u0012\u0010$\u001a\u00020\"2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010%\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020\"H\u0002J\u0010\u0010\'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u000bH\u0002J\b\u0010+\u001a\u00020\"H\u0002J\b\u0010,\u001a\u00020\"H\u0002J\u0012\u0010-\u001a\u00020\"2\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\b\u00100\u001a\u00020\"H\u0002J\b\u00101\u001a\u00020\"H\u0002J\b\u00102\u001a\u00020\"H\u0002J\b\u00103\u001a\u00020\"H\u0002J\b\u00104\u001a\u00020\"H\u0002J\b\u00105\u001a\u00020\"H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00170\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00190\u00190\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e\u00a8\u00066"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/ui/login/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "_binding", "Lbreon/telematics/loneworkersafetyapp/android/databinding/ActivityMainBinding;", "assetDetails", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/AssetDetails;", "binding", "getBinding", "()Lbreon/telematics/loneworkersafetyapp/android/databinding/ActivityMainBinding;", "isLoggedIn", "", "notificationPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "prefManager", "Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "getPrefManager", "()Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "setPrefManager", "(Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;)V", "requestMultiplePermissionsLauncher", "", "startForResult", "Landroid/content/Intent;", "templateName", "viewModel", "Lbreon/telematics/loneworkersafetyapp/android/ui/login/LoginViewModel;", "getViewModel", "()Lbreon/telematics/loneworkersafetyapp/android/ui/login/LoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkAndRequestNotificationPermission", "", "getFirebaseId", "handleAssetDetails", "initClickEvent", "initToolbar", "isLocationEnabled", "context", "Landroid/content/Context;", "isLocationPermissionGranted", "observeLiveData", "observeState", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showLocationEnablingDialog", "showNotificationPermissionDialog", "showPermissionDeniedDialog", "startBackgroundService", "startNewActivity", "userConsentDialog", "app_debug"})
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private breon.telematics.loneworkersafetyapp.android.databinding.ActivityMainBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails assetDetails;
    @javax.inject.Inject()
    public breon.telematics.loneworkersafetyapp.android.utils.PrefManager prefManager;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String templateName;
    private boolean isLoggedIn = false;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestMultiplePermissionsLauncher = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> notificationPermissionLauncher = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> startForResult = null;
    
    public LoginActivity() {
        super();
    }
    
    private final breon.telematics.loneworkersafetyapp.android.databinding.ActivityMainBinding getBinding() {
        return null;
    }
    
    private final breon.telematics.loneworkersafetyapp.android.ui.login.LoginViewModel getViewModel() {
        return null;
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
    
    private final void initToolbar() {
    }
    
    private final void observeState() {
    }
    
    private final void observeLiveData() {
    }
    
    private final void handleAssetDetails(breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails assetDetails) {
    }
    
    private final void startBackgroundService() {
    }
    
    private final void startNewActivity() {
    }
    
    private final void initClickEvent() {
    }
    
    private final boolean isLocationEnabled(android.content.Context context) {
        return false;
    }
    
    private final boolean isLocationPermissionGranted() {
        return false;
    }
    
    private final void checkAndRequestNotificationPermission() {
    }
    
    private final void showPermissionDeniedDialog() {
    }
    
    private final void showLocationEnablingDialog() {
    }
    
    private final void userConsentDialog() {
    }
    
    private final void showNotificationPermissionDialog() {
    }
    
    private final void getFirebaseId() {
    }
}