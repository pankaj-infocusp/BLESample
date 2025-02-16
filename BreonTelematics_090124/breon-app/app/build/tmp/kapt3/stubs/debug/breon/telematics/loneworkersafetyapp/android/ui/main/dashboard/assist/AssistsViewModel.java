package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.assist;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012\u00a8\u0006#"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/assist/AssistsViewModel;", "Lbreon/telematics/loneworkersafetyapp/android/app/base/BaseViewModel;", "deviceWebServiceUseCase", "Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/DeviceWebServiceSmartphoneUseCase;", "assetDetailsUseCase", "Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/AssetDetailsUseCase;", "(Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/DeviceWebServiceSmartphoneUseCase;Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/AssetDetailsUseCase;)V", "_assetDetailsMutableState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/AssetDetails;", "_deviceWebService", "Landroidx/lifecycle/MutableLiveData;", "", "_uiState", "Lbreon/telematics/loneworkersafetyapp/android/utils/UiState;", "assetDetailState", "Lkotlinx/coroutines/flow/StateFlow;", "getAssetDetailState", "()Lkotlinx/coroutines/flow/StateFlow;", "deviceWebService", "Landroidx/lifecycle/LiveData;", "getDeviceWebService", "()Landroidx/lifecycle/LiveData;", "isAssisted", "()Z", "setAssisted", "(Z)V", "uiState", "getUiState", "", "deviceWebServiceRequest", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/DeviceWebServiceSmartphoneRequest;", "getAssetDetails", "assetId", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AssistsViewModel extends breon.telematics.loneworkersafetyapp.android.app.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.usecases.DeviceWebServiceSmartphoneUseCase deviceWebServiceUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase assetDetailsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<breon.telematics.loneworkersafetyapp.android.utils.UiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<breon.telematics.loneworkersafetyapp.android.utils.UiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _deviceWebService = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails> _assetDetailsMutableState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails> assetDetailState = null;
    private boolean isAssisted = false;
    
    @javax.inject.Inject()
    public AssistsViewModel(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.usecases.DeviceWebServiceSmartphoneUseCase deviceWebServiceUseCase, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase assetDetailsUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<breon.telematics.loneworkersafetyapp.android.utils.UiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getDeviceWebService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails> getAssetDetailState() {
        return null;
    }
    
    public final boolean isAssisted() {
        return false;
    }
    
    public final void setAssisted(boolean p0) {
    }
    
    public final void deviceWebService(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.DeviceWebServiceSmartphoneRequest deviceWebServiceRequest) {
    }
    
    public final void getAssetDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String assetId) {
    }
}