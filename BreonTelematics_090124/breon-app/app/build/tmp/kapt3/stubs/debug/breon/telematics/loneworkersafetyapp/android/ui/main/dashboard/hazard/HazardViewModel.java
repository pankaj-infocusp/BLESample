package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.hazard;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0013J6\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011\u00a8\u0006\'"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/hazard/HazardViewModel;", "Lbreon/telematics/loneworkersafetyapp/android/app/base/BaseViewModel;", "deviceWebServiceUseCase", "Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/DeviceWebServiceSmartphoneUseCase;", "assetDetailsUseCase", "Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/AssetDetailsUseCase;", "prefs", "Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "(Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/DeviceWebServiceSmartphoneUseCase;Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/AssetDetailsUseCase;Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;)V", "_assetDetailsMutableState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/AssetDetails;", "_uiState", "Lbreon/telematics/loneworkersafetyapp/android/utils/UiState;", "assetDetailState", "Lkotlinx/coroutines/flow/StateFlow;", "getAssetDetailState", "()Lkotlinx/coroutines/flow/StateFlow;", "isHazardStarted", "", "()Z", "setHazardStarted", "(Z)V", "uiState", "getUiState", "getAssetDetails", "", "assetId", "", "showLoader", "performHazardOperation", "username", "note", "latitude", "", "longitude", "action", "duration", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HazardViewModel extends breon.telematics.loneworkersafetyapp.android.app.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.usecases.DeviceWebServiceSmartphoneUseCase deviceWebServiceUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase assetDetailsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.utils.PrefManager prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<breon.telematics.loneworkersafetyapp.android.utils.UiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<breon.telematics.loneworkersafetyapp.android.utils.UiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails> _assetDetailsMutableState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails> assetDetailState = null;
    private boolean isHazardStarted = false;
    
    @javax.inject.Inject()
    public HazardViewModel(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.usecases.DeviceWebServiceSmartphoneUseCase deviceWebServiceUseCase, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase assetDetailsUseCase, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.utils.PrefManager prefs) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<breon.telematics.loneworkersafetyapp.android.utils.UiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails> getAssetDetailState() {
        return null;
    }
    
    public final boolean isHazardStarted() {
        return false;
    }
    
    public final void setHazardStarted(boolean p0) {
    }
    
    public final void performHazardOperation(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String note, double latitude, double longitude, @org.jetbrains.annotations.NotNull()
    java.lang.String action, long duration) {
    }
    
    public final void getAssetDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String assetId, boolean showLoader) {
    }
}