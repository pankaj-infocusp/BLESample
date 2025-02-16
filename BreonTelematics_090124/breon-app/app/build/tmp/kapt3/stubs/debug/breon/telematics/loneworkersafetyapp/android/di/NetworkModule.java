package breon.telematics.loneworkersafetyapp.android.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0006H\u0007J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u0012\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u00a8\u0006\u0017"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/di/NetworkModule;", "", "()V", "provideAuthInterceptor", "Lbreon/telematics/loneworkersafetyapp/android/data/source/intercepter/AuthInterceptor;", "deviceId", "", "provideBreonService", "Lbreon/telematics/loneworkersafetyapp/android/data/services/BreonService;", "retrofit", "Lretrofit2/Retrofit;", "provideDevBreonService", "provideDevRetrofitInstance", "okHttpClient", "Lokhttp3/OkHttpClient;", "provideFirebaseInstallationId", "provideHttpClient", "authInterceptor", "provideNetworkConnectivity", "Lbreon/telematics/loneworkersafetyapp/android/domain/network/NetworkConnectivity;", "context", "Landroid/content/Context;", "provideRetrofitInstance", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class NetworkModule {
    
    public NetworkModule() {
        super();
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.domain.network.NetworkConnectivity provideNetworkConnectivity(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @javax.inject.Named(value = "FirebaseInstallationId")
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String provideFirebaseInstallationId() {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.data.source.intercepter.AuthInterceptor provideAuthInterceptor(@javax.inject.Named(value = "FirebaseInstallationId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String deviceId) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideHttpClient(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.data.source.intercepter.AuthInterceptor authInterceptor) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideRetrofitInstance(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.data.services.BreonService provideBreonService(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @javax.inject.Named(value = "dev_environment")
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideDevRetrofitInstance(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @javax.inject.Named(value = "dev_environment")
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.data.services.BreonService provideDevBreonService(@javax.inject.Named(value = "dev_environment")
    @org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
}