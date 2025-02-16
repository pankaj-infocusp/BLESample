package breon.telematics.loneworkersafetyapp.android.domain.usecases;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/Take2FormUseCase;", "", "breonRepository", "Lbreon/telematics/loneworkersafetyapp/android/domain/repository/BreonRepository;", "(Lbreon/telematics/loneworkersafetyapp/android/domain/repository/BreonRepository;)V", "getTake2FormFilledStatus", "Lbreon/telematics/loneworkersafetyapp/android/domain/RequestResult;", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/Take2FormFilledStatus;", "request", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTake2FormStatus", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/Take2FormStatus;", "submitForm", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/SubmitTake2Form;", "formData", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class Take2FormUseCase {
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.repository.BreonRepository breonRepository = null;
    
    @javax.inject.Inject()
    public Take2FormUseCase(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.repository.BreonRepository breonRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTake2FormStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super breon.telematics.loneworkersafetyapp.android.domain.RequestResult<breon.telematics.loneworkersafetyapp.android.domain.model.response.Take2FormStatus>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTake2FormFilledStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super breon.telematics.loneworkersafetyapp.android.domain.RequestResult<breon.telematics.loneworkersafetyapp.android.domain.model.response.Take2FormFilledStatus>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object submitForm(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> formData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super breon.telematics.loneworkersafetyapp.android.domain.RequestResult<breon.telematics.loneworkersafetyapp.android.domain.model.response.SubmitTake2Form>> $completion) {
        return null;
    }
}