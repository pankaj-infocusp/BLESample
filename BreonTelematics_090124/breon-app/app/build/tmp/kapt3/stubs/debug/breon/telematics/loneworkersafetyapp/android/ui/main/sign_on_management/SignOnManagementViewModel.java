package breon.telematics.loneworkersafetyapp.android.ui.main.sign_on_management;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ \u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0016H\u0002J*\u0010,\u001a\u00020&2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010-\u001a\u00020\u00142\b\b\u0002\u0010.\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0016J&\u0010/\u001a\u00020&2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020(2\u0006\u0010+\u001a\u00020\u0016J\u0016\u00104\u001a\u00020&2\u0006\u0010+\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0014J\u0016\u00105\u001a\u00020&2\u0006\u0010+\u001a\u00020\u00162\u0006\u00106\u001a\u00020\u0014J\u000e\u00107\u001a\u00020&2\u0006\u0010+\u001a\u00020\u0016J\u0006\u00108\u001a\u00020&R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160 8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00180\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001e\u00a8\u00069"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/ui/main/sign_on_management/SignOnManagementViewModel;", "Lbreon/telematics/loneworkersafetyapp/android/app/base/BaseViewModel;", "loginUseCase", "Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/LoginUseCase;", "deviceWebServiceSmartphoneUseCase", "Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/DeviceWebServiceSmartphoneUseCase;", "confirmDetailsUseCase", "Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/ConfirmDetailsUseCase;", "assetDetailsUseCase", "Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/AssetDetailsUseCase;", "take2FormUseCase", "Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/Take2FormUseCase;", "(Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/LoginUseCase;Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/DeviceWebServiceSmartphoneUseCase;Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/ConfirmDetailsUseCase;Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/AssetDetailsUseCase;Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/Take2FormUseCase;)V", "_assetDetailsMutableState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/AssetDetails;", "_confirmDetails", "Landroidx/lifecycle/MutableLiveData;", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/ConfirmDetails;", "_deviceWebService", "", "_error", "", "_uiState", "Lbreon/telematics/loneworkersafetyapp/android/utils/UiState;", "_userLoginData", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/UserLogin;", "assetDetailState", "Lkotlinx/coroutines/flow/StateFlow;", "getAssetDetailState", "()Lkotlinx/coroutines/flow/StateFlow;", "error", "Landroidx/lifecycle/LiveData;", "getError", "()Landroidx/lifecycle/LiveData;", "uiState", "getUiState", "callConfirmDetailsApi", "", "confirmOrUpdateDetailsRequest", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/ConfirmOrUpdateDetailsRequest;", "deviceWebServiceSmartphoneRequest", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/DeviceWebServiceSmartphoneRequest;", "assetId", "callDeviceWebApi", "showLoading", "shouldRedirectToDashboard", "callSignOnApis", "loginRequest", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/UserLoginRequest;", "deviceWebServiceRequest", "confirmDetailsRequest", "getAssetDetails", "getIsTake2FormFilled", "isShowProgress", "getTake2FormStatus", "setIdleState", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SignOnManagementViewModel extends breon.telematics.loneworkersafetyapp.android.app.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.usecases.LoginUseCase loginUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.usecases.DeviceWebServiceSmartphoneUseCase deviceWebServiceSmartphoneUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.usecases.ConfirmDetailsUseCase confirmDetailsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase assetDetailsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.usecases.Take2FormUseCase take2FormUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<breon.telematics.loneworkersafetyapp.android.utils.UiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<breon.telematics.loneworkersafetyapp.android.utils.UiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<breon.telematics.loneworkersafetyapp.android.domain.model.response.UserLogin> _userLoginData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _deviceWebService = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<breon.telematics.loneworkersafetyapp.android.domain.model.response.ConfirmDetails> _confirmDetails = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails> _assetDetailsMutableState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails> assetDetailState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _error = null;
    
    @javax.inject.Inject()
    public SignOnManagementViewModel(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.usecases.LoginUseCase loginUseCase, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.usecases.DeviceWebServiceSmartphoneUseCase deviceWebServiceSmartphoneUseCase, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.usecases.ConfirmDetailsUseCase confirmDetailsUseCase, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase assetDetailsUseCase, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.usecases.Take2FormUseCase take2FormUseCase) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getError() {
        return null;
    }
    
    public final void setIdleState() {
    }
    
    public final void callSignOnApis(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.UserLoginRequest loginRequest, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.DeviceWebServiceSmartphoneRequest deviceWebServiceRequest, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.ConfirmOrUpdateDetailsRequest confirmDetailsRequest, @org.jetbrains.annotations.NotNull()
    java.lang.String assetId) {
    }
    
    private final void callConfirmDetailsApi(breon.telematics.loneworkersafetyapp.android.domain.model.request.ConfirmOrUpdateDetailsRequest confirmOrUpdateDetailsRequest, breon.telematics.loneworkersafetyapp.android.domain.model.request.DeviceWebServiceSmartphoneRequest deviceWebServiceSmartphoneRequest, java.lang.String assetId) {
    }
    
    public final void callDeviceWebApi(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.DeviceWebServiceSmartphoneRequest deviceWebServiceSmartphoneRequest, boolean showLoading, boolean shouldRedirectToDashboard, @org.jetbrains.annotations.NotNull()
    java.lang.String assetId) {
    }
    
    public final void getAssetDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String assetId, boolean shouldRedirectToDashboard) {
    }
    
    public final void getTake2FormStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String assetId) {
    }
    
    public final void getIsTake2FormFilled(@org.jetbrains.annotations.NotNull()
    java.lang.String assetId, boolean isShowProgress) {
    }
}