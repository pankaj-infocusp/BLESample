package breon.telematics.loneworkersafetyapp.android.ui.main.settings;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020 H\u0002J\u000e\u0010&\u001a\u00020 2\u0006\u0010\'\u001a\u00020(J\u0018\u0010)\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010*\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0002R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/ui/main/settings/SettingsViewModel;", "Lbreon/telematics/loneworkersafetyapp/android/app/base/BaseViewModel;", "confirmDetailsUseCase", "Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/ConfirmDetailsUseCase;", "updateContactDetailsUseCase", "Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/UpdateContactDetailsUseCase;", "updateTemplateUseCase", "Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/UpdateTemplateUseCase;", "templateDetailsUseCase", "Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/TemplateDetailsUseCase;", "prefManager", "Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "(Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/ConfirmDetailsUseCase;Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/UpdateContactDetailsUseCase;Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/UpdateTemplateUseCase;Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/TemplateDetailsUseCase;Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;)V", "_confirmOrUpdateOrTemplate", "Landroidx/lifecycle/MutableLiveData;", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/ConfirmDetails;", "_templatesDetails", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/TemplateDetails;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lbreon/telematics/loneworkersafetyapp/android/utils/UiState;", "confirmOrUpdateOrTemplate", "Landroidx/lifecycle/LiveData;", "getConfirmOrUpdateOrTemplate", "()Landroidx/lifecycle/LiveData;", "templatesDetails", "getTemplatesDetails", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "confirmDetails", "", "confirmOrUpdateDetailsRequest", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/ConfirmOrUpdateDetailsRequest;", "updateTemplateRequest", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/UpdateTemplateRequest;", "getTemplateDetails", "getTemplateDetailsById", "templateId", "", "updateContactDetails", "updateTemplate", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SettingsViewModel extends breon.telematics.loneworkersafetyapp.android.app.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.usecases.ConfirmDetailsUseCase confirmDetailsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.usecases.UpdateContactDetailsUseCase updateContactDetailsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.usecases.UpdateTemplateUseCase updateTemplateUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.usecases.TemplateDetailsUseCase templateDetailsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.utils.PrefManager prefManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<breon.telematics.loneworkersafetyapp.android.utils.UiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<breon.telematics.loneworkersafetyapp.android.utils.UiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<breon.telematics.loneworkersafetyapp.android.domain.model.response.ConfirmDetails> _confirmOrUpdateOrTemplate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<breon.telematics.loneworkersafetyapp.android.domain.model.response.TemplateDetails> _templatesDetails = null;
    
    @javax.inject.Inject()
    public SettingsViewModel(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.usecases.ConfirmDetailsUseCase confirmDetailsUseCase, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.usecases.UpdateContactDetailsUseCase updateContactDetailsUseCase, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.usecases.UpdateTemplateUseCase updateTemplateUseCase, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.usecases.TemplateDetailsUseCase templateDetailsUseCase, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.utils.PrefManager prefManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<breon.telematics.loneworkersafetyapp.android.utils.UiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<breon.telematics.loneworkersafetyapp.android.domain.model.response.ConfirmDetails> getConfirmOrUpdateOrTemplate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<breon.telematics.loneworkersafetyapp.android.domain.model.response.TemplateDetails> getTemplatesDetails() {
        return null;
    }
    
    public final void confirmDetails(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.ConfirmOrUpdateDetailsRequest confirmOrUpdateDetailsRequest, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.UpdateTemplateRequest updateTemplateRequest) {
    }
    
    private final void updateContactDetails(breon.telematics.loneworkersafetyapp.android.domain.model.request.ConfirmOrUpdateDetailsRequest confirmOrUpdateDetailsRequest, breon.telematics.loneworkersafetyapp.android.domain.model.request.UpdateTemplateRequest updateTemplateRequest) {
    }
    
    private final void updateTemplate(breon.telematics.loneworkersafetyapp.android.domain.model.request.UpdateTemplateRequest updateTemplateRequest) {
    }
    
    private final void getTemplateDetails() {
    }
    
    public final void getTemplateDetailsById(@org.jetbrains.annotations.NotNull()
    java.lang.String templateId) {
    }
}