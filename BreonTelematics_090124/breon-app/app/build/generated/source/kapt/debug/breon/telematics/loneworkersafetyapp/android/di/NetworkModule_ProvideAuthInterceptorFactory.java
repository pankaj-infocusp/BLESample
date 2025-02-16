package breon.telematics.loneworkersafetyapp.android.di;

import breon.telematics.loneworkersafetyapp.android.data.source.intercepter.AuthInterceptor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
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
public final class NetworkModule_ProvideAuthInterceptorFactory implements Factory<AuthInterceptor> {
  private final NetworkModule module;

  private final Provider<String> deviceIdProvider;

  public NetworkModule_ProvideAuthInterceptorFactory(NetworkModule module,
      Provider<String> deviceIdProvider) {
    this.module = module;
    this.deviceIdProvider = deviceIdProvider;
  }

  @Override
  public AuthInterceptor get() {
    return provideAuthInterceptor(module, deviceIdProvider.get());
  }

  public static NetworkModule_ProvideAuthInterceptorFactory create(NetworkModule module,
      Provider<String> deviceIdProvider) {
    return new NetworkModule_ProvideAuthInterceptorFactory(module, deviceIdProvider);
  }

  public static AuthInterceptor provideAuthInterceptor(NetworkModule instance, String deviceId) {
    return Preconditions.checkNotNullFromProvides(instance.provideAuthInterceptor(deviceId));
  }
}
