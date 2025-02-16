package breon.telematics.loneworkersafetyapp.android.domain.error;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u00a8\u0006\u0013"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity;", "", "()V", "AccessDenied", "Authentication", "BadRequest", "Network", "NotFound", "ServerError", "ServiceUnavailable", "Unknown", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity$AccessDenied;", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity$Authentication;", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity$BadRequest;", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity$Network;", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity$NotFound;", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity$ServerError;", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity$ServiceUnavailable;", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity$Unknown;", "app_debug"})
public abstract class ErrorEntity {
    
    private ErrorEntity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity$AccessDenied;", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity;", "()V", "app_debug"})
    public static final class AccessDenied extends breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity {
        @org.jetbrains.annotations.NotNull()
        public static final breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity.AccessDenied INSTANCE = null;
        
        private AccessDenied() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity$Authentication;", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity;", "()V", "app_debug"})
    public static final class Authentication extends breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity {
        @org.jetbrains.annotations.NotNull()
        public static final breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity.Authentication INSTANCE = null;
        
        private Authentication() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity$BadRequest;", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity;", "errorResponse", "Lbreon/telematics/loneworkersafetyapp/android/data/error_handler/GeneralErrorHandlerImpl$ErrorResponse;", "(Lbreon/telematics/loneworkersafetyapp/android/data/error_handler/GeneralErrorHandlerImpl$ErrorResponse;)V", "getErrorResponse", "()Lbreon/telematics/loneworkersafetyapp/android/data/error_handler/GeneralErrorHandlerImpl$ErrorResponse;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class BadRequest extends breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity {
        @org.jetbrains.annotations.NotNull()
        private final breon.telematics.loneworkersafetyapp.android.data.error_handler.GeneralErrorHandlerImpl.ErrorResponse errorResponse = null;
        
        public BadRequest(@org.jetbrains.annotations.NotNull()
        breon.telematics.loneworkersafetyapp.android.data.error_handler.GeneralErrorHandlerImpl.ErrorResponse errorResponse) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final breon.telematics.loneworkersafetyapp.android.data.error_handler.GeneralErrorHandlerImpl.ErrorResponse getErrorResponse() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final breon.telematics.loneworkersafetyapp.android.data.error_handler.GeneralErrorHandlerImpl.ErrorResponse component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity.BadRequest copy(@org.jetbrains.annotations.NotNull()
        breon.telematics.loneworkersafetyapp.android.data.error_handler.GeneralErrorHandlerImpl.ErrorResponse errorResponse) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity$Network;", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity;", "()V", "app_debug"})
    public static final class Network extends breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity {
        @org.jetbrains.annotations.NotNull()
        public static final breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity.Network INSTANCE = null;
        
        private Network() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity$NotFound;", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity;", "()V", "app_debug"})
    public static final class NotFound extends breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity {
        @org.jetbrains.annotations.NotNull()
        public static final breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity.NotFound INSTANCE = null;
        
        private NotFound() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity$ServerError;", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity;", "()V", "app_debug"})
    public static final class ServerError extends breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity {
        @org.jetbrains.annotations.NotNull()
        public static final breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity.ServerError INSTANCE = null;
        
        private ServerError() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity$ServiceUnavailable;", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity;", "()V", "app_debug"})
    public static final class ServiceUnavailable extends breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity {
        @org.jetbrains.annotations.NotNull()
        public static final breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity.ServiceUnavailable INSTANCE = null;
        
        private ServiceUnavailable() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity$Unknown;", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity;", "()V", "app_debug"})
    public static final class Unknown extends breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity {
        @org.jetbrains.annotations.NotNull()
        public static final breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity.Unknown INSTANCE = null;
        
        private Unknown() {
        }
    }
}