package breon.telematics.loneworkersafetyapp.android.di;

import breon.telematics.loneworkersafetyapp.android.data.source.intercepter.AuthInterceptor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class NetworkModule_ProvideHttpClientFactory implements Factory<OkHttpClient> {
  private final NetworkModule module;

  private final Provider<AuthInterceptor> authInterceptorProvider;

  public NetworkModule_ProvideHttpClientFactory(NetworkModule module,
      Provider<AuthInterceptor> authInterceptorProvider) {
    this.module = module;
    this.authInterceptorProvider = authInterceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideHttpClient(module, authInterceptorProvider.get());
  }

  public static NetworkModule_ProvideHttpClientFactory create(NetworkModule module,
      Provider<AuthInterceptor> authInterceptorProvider) {
    return new NetworkModule_ProvideHttpClientFactory(module, authInterceptorProvider);
  }

  public static OkHttpClient provideHttpClient(NetworkModule instance,
      AuthInterceptor authInterceptor) {
    return Preconditions.checkNotNullFromProvides(instance.provideHttpClient(authInterceptor));
  }
}
