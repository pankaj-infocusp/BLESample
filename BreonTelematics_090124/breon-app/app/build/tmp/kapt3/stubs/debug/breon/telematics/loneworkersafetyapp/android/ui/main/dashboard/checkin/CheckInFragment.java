package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.checkin;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u001fH\u0003J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010\'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u001fH\u0002J\b\u0010*\u001a\u00020\u001fH\u0002J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-H\u0016J\u0012\u0010.\u001a\u00020\u001f2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J&\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00107\u001a\u00020\u001fH\u0016J\b\u00108\u001a\u00020\u001fH\u0016J\b\u00109\u001a\u00020\u001fH\u0016J\u0010\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020<H\u0007J\u001a\u0010=\u001a\u00020\u001f2\u0006\u0010>\u001a\u0002022\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0018\u0010?\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u001bH\u0002J\u0018\u0010C\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010D\u001a\u00020\u001fH\u0002J\u0010\u0010E\u001a\u00020\u001f2\u0006\u0010F\u001a\u00020\u001bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006G"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/checkin/CheckInFragment;", "Landroidx/fragment/app/Fragment;", "Lbreon/telematics/loneworkersafetyapp/android/ui/main/callback/OnAssetDetailFetchListener;", "()V", "_binding", "Lbreon/telematics/loneworkersafetyapp/android/databinding/FragmentCheckInBinding;", "binding", "getBinding", "()Lbreon/telematics/loneworkersafetyapp/android/databinding/FragmentCheckInBinding;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getFusedLocationClient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "setFusedLocationClient", "(Lcom/google/android/gms/location/FusedLocationProviderClient;)V", "latitude", "", "longitude", "pref", "Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "getPref", "()Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "setPref", "(Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;)V", "timer", "Landroid/os/CountDownTimer;", "timerTime", "", "viewModel", "Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/checkin/CheckInViewModel;", "calculateCheckInTime", "", "safetyTime", "", "lastCheckInTime", "", "callWebServiceApi", "getLastLocation", "handleUi", "status", "Lbreon/telematics/loneworkersafetyapp/android/utils/CurrentStatus;", "initClickEvent", "observeState", "onAssetDetailsFetched", "assetDetails", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/AssetDetails;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onStart", "onStop", "onTimerCompleted", "isComplete", "", "onViewCreated", "view", "setCheckInDescription", "date", "Ljava/time/LocalDateTime;", "plusTime", "setupLastCheckInTime", "startTimer", "updateTextUI", "millisUntilFinished", "app_debug"})
public final class CheckInFragment extends androidx.fragment.app.Fragment implements breon.telematics.loneworkersafetyapp.android.ui.main.callback.OnAssetDetailFetchListener {
    @org.jetbrains.annotations.Nullable()
    private breon.telematics.loneworkersafetyapp.android.databinding.FragmentCheckInBinding _binding;
    private breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.checkin.CheckInViewModel viewModel;
    @javax.inject.Inject()
    public breon.telematics.loneworkersafetyapp.android.utils.PrefManager pref;
    @javax.inject.Inject()
    public com.google.android.gms.location.FusedLocationProviderClient fusedLocationClient;
    @org.jetbrains.annotations.Nullable()
    private android.os.CountDownTimer timer;
    private double latitude = 0.0;
    private double longitude = 0.0;
    private long timerTime = 0L;
    
    public CheckInFragment() {
        super();
    }
    
    private final breon.telematics.loneworkersafetyapp.android.databinding.FragmentCheckInBinding getBinding() {
        return null;
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
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onAssetDetailsFetched(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails assetDetails) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void handleUi(breon.telematics.loneworkersafetyapp.android.utils.CurrentStatus status) {
    }
    
    private final void observeState() {
    }
    
    private final void setupLastCheckInTime(int safetyTime, java.lang.String lastCheckInTime) {
    }
    
    private final void calculateCheckInTime(int safetyTime, java.lang.String lastCheckInTime) {
    }
    
    private final void initClickEvent() {
    }
    
    private final void setCheckInDescription(java.time.LocalDateTime date, long plusTime) {
    }
    
    private final void callWebServiceApi() {
    }
    
    private final void startTimer() {
    }
    
    private final void updateTextUI(long millisUntilFinished) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void getLastLocation() {
    }
    
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN_ORDERED)
    public final void onTimerCompleted(boolean isComplete) {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @java.lang.Override()
    public void updateTimer(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails assetDetails) {
    }
}