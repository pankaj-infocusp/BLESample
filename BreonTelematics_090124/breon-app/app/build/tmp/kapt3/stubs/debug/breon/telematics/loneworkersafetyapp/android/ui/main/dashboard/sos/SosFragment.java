package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.sos;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0003J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\u001d2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010/\u001a\u00020\u001dH\u0016J\u001a\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020*2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/sos/SosFragment;", "Landroidx/fragment/app/Fragment;", "Lbreon/telematics/loneworkersafetyapp/android/ui/main/callback/OnAssetDetailFetchListener;", "()V", "_binding", "Lbreon/telematics/loneworkersafetyapp/android/databinding/FragmentSosBinding;", "binding", "getBinding", "()Lbreon/telematics/loneworkersafetyapp/android/databinding/FragmentSosBinding;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getFusedLocationClient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "setFusedLocationClient", "(Lcom/google/android/gms/location/FusedLocationProviderClient;)V", "latitude", "", "longitude", "pref", "Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "getPref", "()Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "setPref", "(Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;)V", "username", "", "viewModel", "Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/sos/SosViewModel;", "callWebServiceApi", "", "action", "getLastLocation", "handleUi", "initClickEvent", "observeState", "onAssetDetailsFetched", "assetDetails", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/AssetDetails;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "app_debug"})
public final class SosFragment extends androidx.fragment.app.Fragment implements breon.telematics.loneworkersafetyapp.android.ui.main.callback.OnAssetDetailFetchListener {
    @org.jetbrains.annotations.Nullable()
    private breon.telematics.loneworkersafetyapp.android.databinding.FragmentSosBinding _binding;
    private breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.sos.SosViewModel viewModel;
    @javax.inject.Inject()
    public com.google.android.gms.location.FusedLocationProviderClient fusedLocationClient;
    @javax.inject.Inject()
    public breon.telematics.loneworkersafetyapp.android.utils.PrefManager pref;
    private double latitude = 0.0;
    private double longitude = 0.0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String username = "";
    
    public SosFragment() {
        super();
    }
    
    private final breon.telematics.loneworkersafetyapp.android.databinding.FragmentSosBinding getBinding() {
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
    
    private final void handleUi() {
    }
    
    private final void observeState() {
    }
    
    private final void initClickEvent() {
    }
    
    private final void callWebServiceApi(java.lang.String action) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void getLastLocation() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @java.lang.Override()
    public void updateTimer(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails assetDetails) {
    }
}