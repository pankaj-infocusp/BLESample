package breon.telematics.loneworkersafetyapp.android.domain.error;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorHandler;", "", "getError", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity;", "throwable", "", "app_debug"})
public abstract interface ErrorHandler {
    
    @org.jetbrains.annotations.NotNull()
    public abstract breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity getError(@org.jetbrains.annotations.Nullable()
    java.lang.Throwable throwable);
}