package breon.telematics.loneworkersafetyapp.android.ui.main.activity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/ui/main/activity/UserPermissionActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "_binding", "Lbreon/telematics/loneworkersafetyapp/android/databinding/ActivityUserPermissionBinding;", "binding", "getBinding", "()Lbreon/telematics/loneworkersafetyapp/android/databinding/ActivityUserPermissionBinding;", "notificationPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "requestMultiplePermissionsLauncher", "", "checkAndRequestNotificationPermission", "", "initClickEvent", "initToolbar", "isLocationPermissionGranted", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showNotificationPermissionDialog", "showPermissionDeniedDialog", "userConsentDialog", "app_debug"})
public final class UserPermissionActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private breon.telematics.loneworkersafetyapp.android.databinding.ActivityUserPermissionBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestMultiplePermissionsLauncher = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> notificationPermissionLauncher = null;
    
    public UserPermissionActivity() {
        super();
    }
    
    private final breon.telematics.loneworkersafetyapp.android.databinding.ActivityUserPermissionBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initToolbar() {
    }
    
    private final void initClickEvent() {
    }
    
    private final boolean isLocationPermissionGranted() {
        return false;
    }
    
    private final void userConsentDialog() {
    }
    
    private final void showPermissionDeniedDialog() {
    }
    
    private final void checkAndRequestNotificationPermission() {
    }
    
    private final void showNotificationPermissionDialog() {
    }
}