package breon.telematics.loneworkersafetyapp.android.data.error_handler;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002\u00a8\u0006\f"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/data/error_handler/GeneralErrorHandlerImpl;", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorHandler;", "()V", "getError", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity;", "throwable", "", "getErrorObject", "Lbreon/telematics/loneworkersafetyapp/android/data/error_handler/GeneralErrorHandlerImpl$ErrorResponse;", "responseBody", "Lokhttp3/ResponseBody;", "ErrorResponse", "app_debug"})
public final class GeneralErrorHandlerImpl implements breon.telematics.loneworkersafetyapp.android.domain.error.ErrorHandler {
    
    @javax.inject.Inject()
    public GeneralErrorHandlerImpl() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity getError(@org.jetbrains.annotations.Nullable()
    java.lang.Throwable throwable) {
        return null;
    }
    
    private final breon.telematics.loneworkersafetyapp.android.data.error_handler.GeneralErrorHandlerImpl.ErrorResponse getErrorObject(okhttp3.ResponseBody responseBody) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/data/error_handler/GeneralErrorHandlerImpl$ErrorResponse;", "", "message", "", "errorCode", "", "(Ljava/lang/String;I)V", "getErrorCode", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    public static final class ErrorResponse {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String message = null;
        private final int errorCode = 0;
        
        public ErrorResponse(@org.jetbrains.annotations.NotNull()
        java.lang.String message, int errorCode) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMessage() {
            return null;
        }
        
        public final int getErrorCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final breon.telematics.loneworkersafetyapp.android.data.error_handler.GeneralErrorHandlerImpl.ErrorResponse copy(@org.jetbrains.annotations.NotNull()
        java.lang.String message, int errorCode) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}