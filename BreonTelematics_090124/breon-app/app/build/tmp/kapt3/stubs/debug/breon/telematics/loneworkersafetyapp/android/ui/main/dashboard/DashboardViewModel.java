package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/DashboardViewModel;", "Lbreon/telematics/loneworkersafetyapp/android/app/base/BaseViewModel;", "deviceWebServiceSmartphoneUseCase", "Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/DeviceWebServiceSmartphoneUseCase;", "(Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/DeviceWebServiceSmartphoneUseCase;)V", "_deviceWebServiceSmartphone", "Landroidx/lifecycle/MutableLiveData;", "", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lbreon/telematics/loneworkersafetyapp/android/utils/UiState;", "deviceWebServiceSmartphone", "Landroidx/lifecycle/LiveData;", "getDeviceWebServiceSmartphone", "()Landroidx/lifecycle/LiveData;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "", "deviceWebServiceSmartphoneRequest", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/DeviceWebServiceSmartphoneRequest;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DashboardViewModel extends breon.telematics.loneworkersafetyapp.android.app.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.usecases.DeviceWebServiceSmartphoneUseCase deviceWebServiceSmartphoneUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<breon.telematics.loneworkersafetyapp.android.utils.UiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<breon.telematics.loneworkersafetyapp.android.utils.UiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _deviceWebServiceSmartphone = null;
    
    @javax.inject.Inject()
    public DashboardViewModel(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.usecases.DeviceWebServiceSmartphoneUseCase deviceWebServiceSmartphoneUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<breon.telematics.loneworkersafetyapp.android.utils.UiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getDeviceWebServiceSmartphone() {
        return null;
    }
    
    public final void deviceWebServiceSmartphone(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.DeviceWebServiceSmartphoneRequest deviceWebServiceSmartphoneRequest) {
    }
}