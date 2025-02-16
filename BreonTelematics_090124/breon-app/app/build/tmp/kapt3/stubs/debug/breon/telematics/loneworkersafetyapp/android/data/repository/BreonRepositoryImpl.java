package breon.telematics.loneworkersafetyapp.android.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00062\u0006\u0010\u001c\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00062\u0006\u0010\u001f\u001a\u00020 H\u0096@\u00a2\u0006\u0002\u0010!J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00062\u0006\u0010$\u001a\u00020%H\u0096@\u00a2\u0006\u0002\u0010&J(\u0010\'\u001a\b\u0012\u0004\u0012\u00020(0\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020*0)H\u0096@\u00a2\u0006\u0002\u0010+J\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010.\u001a\u00020/H\u0096@\u00a2\u0006\u0002\u00100J\u001c\u00101\u001a\b\u0012\u0004\u0012\u0002020\u00062\u0006\u00103\u001a\u000204H\u0096@\u00a2\u0006\u0002\u00105R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/data/repository/BreonRepositoryImpl;", "Lbreon/telematics/loneworkersafetyapp/android/domain/repository/BreonRepository;", "breonDataSource", "Lbreon/telematics/loneworkersafetyapp/android/data/source/remote/BreonDataSource;", "(Lbreon/telematics/loneworkersafetyapp/android/data/source/remote/BreonDataSource;)V", "confirmDetails", "Lbreon/telematics/loneworkersafetyapp/android/domain/RequestResult;", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/ConfirmDetails;", "confirmOrUpdateDetailsRequest", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/ConfirmOrUpdateDetailsRequest;", "(Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/ConfirmOrUpdateDetailsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deviceWebServiceSmartphone", "", "deviceWebServiceSmartphoneRequest", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/DeviceWebServiceSmartphoneRequest;", "(Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/DeviceWebServiceSmartphoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAssetDetails", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/AssetDetails;", "assetId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIsTake2FormFilled", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/Take2FormFilledStatus;", "getTake2FormStatus", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/Take2FormStatus;", "getTemplateDetails", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/TemplateDetails;", "getTemplateDetailsById", "templateId", "getUserTemplates", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/UserTemplatesUpdated;", "templateReq", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/UserTemplateRequest;", "(Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/UserTemplateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendLocation", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/LocationTracking;", "locationRequest", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/LocationTrackingRequest;", "(Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/LocationTrackingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitTake2Form", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/SubmitTake2Form;", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateContactDetails", "updateTemplate", "updateTemplateRequest", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/UpdateTemplateRequest;", "(Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/UpdateTemplateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "userLogin", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/UserLogin;", "loginRequest", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/UserLoginRequest;", "(Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/UserLoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class BreonRepositoryImpl implements breon.telematics.loneworkersafetyapp.android.domain.repository.BreonRepository {
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.data.source.remote.BreonDataSource breonDataSource = null;
    
    @javax.inject.Inject()
    public BreonRepositoryImpl(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.data.source.remote.BreonDataSource breonDataSource) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object userLogin(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.UserLoginRequest loginRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super breon.telematics.loneworkersafetyapp.android.domain.RequestResult<breon.telematics.loneworkersafetyapp.android.domain.model.response.UserLogin>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getUserTemplates(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.UserTemplateRequest templateReq, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super breon.telematics.loneworkersafetyapp.android.domain.RequestResult<breon.telematics.loneworkersafetyapp.android.domain.model.response.UserTemplatesUpdated>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object confirmDetails(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.ConfirmOrUpdateDetailsRequest confirmOrUpdateDetailsRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super breon.telematics.loneworkersafetyapp.android.domain.RequestResult<breon.telematics.loneworkersafetyapp.android.domain.model.response.ConfirmDetails>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateContactDetails(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.ConfirmOrUpdateDetailsRequest confirmOrUpdateDetailsRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super breon.telematics.loneworkersafetyapp.android.domain.RequestResult<breon.telematics.loneworkersafetyapp.android.domain.model.response.ConfirmDetails>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateTemplate(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.UpdateTemplateRequest updateTemplateRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super breon.telematics.loneworkersafetyapp.android.domain.RequestResult<breon.telematics.loneworkersafetyapp.android.domain.model.response.ConfirmDetails>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deviceWebServiceSmartphone(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.DeviceWebServiceSmartphoneRequest deviceWebServiceSmartphoneRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super breon.telematics.loneworkersafetyapp.android.domain.RequestResult<java.lang.Boolean>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object sendLocation(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.LocationTrackingRequest locationRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super breon.telematics.loneworkersafetyapp.android.domain.RequestResult<breon.telematics.loneworkersafetyapp.android.domain.model.response.LocationTracking>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getAssetDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String assetId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super breon.telematics.loneworkersafetyapp.android.domain.RequestResult<breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getTemplateDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String assetId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super breon.telematics.loneworkersafetyapp.android.domain.RequestResult<breon.telematics.loneworkersafetyapp.android.domain.model.response.TemplateDetails>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getTemplateDetailsById(@org.jetbrains.annotations.NotNull()
    java.lang.String templateId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super breon.telematics.loneworkersafetyapp.android.domain.RequestResult<breon.telematics.loneworkersafetyapp.android.domain.model.response.TemplateDetails>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getTake2FormStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String assetId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super breon.telematics.loneworkersafetyapp.android.domain.RequestResult<breon.telematics.loneworkersafetyapp.android.domain.model.response.Take2FormStatus>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getIsTake2FormFilled(@org.jetbrains.annotations.NotNull()
    java.lang.String assetId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super breon.telematics.loneworkersafetyapp.android.domain.RequestResult<breon.telematics.loneworkersafetyapp.android.domain.model.response.Take2FormFilledStatus>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object submitTake2Form(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> assetId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super breon.telematics.loneworkersafetyapp.android.domain.RequestResult<breon.telematics.loneworkersafetyapp.android.domain.model.response.SubmitTake2Form>> $completion) {
        return null;
    }
}