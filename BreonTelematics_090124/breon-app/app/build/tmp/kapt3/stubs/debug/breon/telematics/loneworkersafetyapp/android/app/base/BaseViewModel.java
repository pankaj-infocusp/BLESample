package breon.telematics.loneworkersafetyapp.android.app.base;

/**
 * Created By Pankaj Dholakiya at 12 March 2024
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0007\u00a8\u0006\u001d"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/app/base/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "showError", "Lbreon/telematics/loneworkersafetyapp/android/utils/SingleLiveEvent;", "", "getShowError", "()Lbreon/telematics/loneworkersafetyapp/android/utils/SingleLiveEvent;", "showErrorMessage", "", "getShowErrorMessage", "showErrorMessageInt", "", "getShowErrorMessageInt", "showLoading", "getShowLoading", "showNoData", "getShowNoData", "showSnackBar", "getShowSnackBar", "showSnackBarInt", "getShowSnackBarInt", "showToast", "getShowToast", "showToastInt", "getShowToastInt", "startIntent", "Landroid/content/Intent;", "getStartIntent", "app_debug"})
public abstract class BaseViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<java.lang.String> showErrorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<java.lang.Integer> showErrorMessageInt = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<java.lang.String> showSnackBar = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<java.lang.Integer> showSnackBarInt = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<java.lang.String> showToast = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<java.lang.Integer> showToastInt = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<java.lang.Boolean> showLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<java.lang.Boolean> showNoData = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<java.lang.Boolean> showError = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<android.content.Intent> startIntent = null;
    
    public BaseViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<java.lang.String> getShowErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<java.lang.Integer> getShowErrorMessageInt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<java.lang.String> getShowSnackBar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<java.lang.Integer> getShowSnackBarInt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<java.lang.String> getShowToast() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<java.lang.Integer> getShowToastInt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<java.lang.Boolean> getShowLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<java.lang.Boolean> getShowNoData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<java.lang.Boolean> getShowError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.utils.SingleLiveEvent<android.content.Intent> getStartIntent() {
        return null;
    }
}