package breon.telematics.loneworkersafetyapp.android.data.source.intercepter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/data/source/intercepter/AuthInterceptor;", "Lokhttp3/Interceptor;", "deviceId", "", "(Ljava/lang/String;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "app_debug"})
public final class AuthInterceptor implements okhttp3.Interceptor {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String deviceId = null;
    @org.jetbrains.annotations.Nullable()
    private static java.lang.String token;
    @org.jetbrains.annotations.NotNull()
    public static final breon.telematics.loneworkersafetyapp.android.data.source.intercepter.AuthInterceptor.Companion Companion = null;
    
    public AuthInterceptor(@org.jetbrains.annotations.NotNull()
    java.lang.String deviceId) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull()
    okhttp3.Interceptor.Chain chain) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/data/source/intercepter/AuthInterceptor$Companion;", "", "()V", "token", "", "provideFirebaseToken", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        private final java.lang.String provideFirebaseToken() {
            return null;
        }
    }
}