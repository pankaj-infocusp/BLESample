package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.hazard;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020$H\u0003J\u0010\u0010\'\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020$H\u0002J\u0010\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.H\u0016J\u0012\u0010/\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u000101H\u0016J&\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00108\u001a\u00020$H\u0016J\u0010\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020;H\u0007J\b\u0010<\u001a\u00020$H\u0016J\b\u0010=\u001a\u00020$H\u0016J\b\u0010>\u001a\u00020$H\u0016J\u0010\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020AH\u0007J\u001a\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u0002032\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0018\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020 H\u0002J\b\u0010H\u001a\u00020$H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006I"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/hazard/HazardFragment;", "Landroidx/fragment/app/Fragment;", "Lbreon/telematics/loneworkersafetyapp/android/ui/main/callback/OnAssetDetailFetchListener;", "()V", "_binding", "Lbreon/telematics/loneworkersafetyapp/android/databinding/FragmentHazardBinding;", "binding", "getBinding", "()Lbreon/telematics/loneworkersafetyapp/android/databinding/FragmentHazardBinding;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getFusedLocationClient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "setFusedLocationClient", "(Lcom/google/android/gms/location/FusedLocationProviderClient;)V", "hazardDuration", "Lkotlin/time/Duration;", "J", "latitude", "", "longitude", "pref", "Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "getPref", "()Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "setPref", "(Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;)V", "timer", "Landroid/os/CountDownTimer;", "timerTime", "", "username", "", "viewModel", "Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/hazard/HazardViewModel;", "callWebServiceApi", "", "action", "getLastLocation", "handleUi", "status", "Lbreon/telematics/loneworkersafetyapp/android/utils/CurrentStatus;", "initClickEvent", "observeState", "onAssetDetailsFetched", "assetDetails", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/AssetDetails;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onEvent", "time", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/HazardAssetDetail;", "onResume", "onStart", "onStop", "onTimerCompleted", "isComplete", "", "onViewCreated", "view", "setupLastCheckInTime", "hazardTime", "", "lastCheckInTime", "startTimer", "app_debug"})
public final class HazardFragment extends androidx.fragment.app.Fragment implements breon.telematics.loneworkersafetyapp.android.ui.main.callback.OnAssetDetailFetchListener {
    @org.jetbrains.annotations.Nullable()
    private breon.telematics.loneworkersafetyapp.android.databinding.FragmentHazardBinding _binding;
    private breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.hazard.HazardViewModel viewModel;
    @javax.inject.Inject()
    public com.google.android.gms.location.FusedLocationProviderClient fusedLocationClient;
    @javax.inject.Inject()
    public breon.telematics.loneworkersafetyapp.android.utils.PrefManager pref;
    private double latitude = 0.0;
    private double longitude = 0.0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String username = "";
    @org.jetbrains.annotations.Nullable()
    private android.os.CountDownTimer timer;
    private long timerTime = 0L;
    private long hazardDuration;
    
    public HazardFragment() {
        super();
    }
    
    private final breon.telematics.loneworkersafetyapp.android.databinding.FragmentHazardBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.location.FusedLocationProviderClient getFusedLocationClient() {
        return null;
    }
    
    public final void setFusedLocationClient(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.location.FusedLocationProviderClient p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.utils.PrefManager getPref() {
        return null;
    }
    
    public final void setPref(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.utils.PrefManager p0) {
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
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void handleUi(breon.telematics.loneworkersafetyapp.android.utils.CurrentStatus status) {
    }
    
    private final void observeState() {
    }
    
    private final void setupLastCheckInTime(int hazardTime, java.lang.String lastCheckInTime) {
    }
    
    private final void initClickEvent() {
    }
    
    private final void callWebServiceApi(java.lang.String action) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void getLastLocation() {
    }
    
    private final void startTimer() {
    }
    
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN_ORDERED)
    public final void onEvent(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.HazardAssetDetail time) {
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