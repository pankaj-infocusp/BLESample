package breon.telematics.loneworkersafetyapp.android.di;

import android.content.Context;
import breon.telematics.loneworkersafetyapp.android.domain.network.NetworkConnectivity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class NetworkModule_ProvideNetworkConnectivityFactory implements Factory<NetworkConnectivity> {
  private final NetworkModule module;

  private final Provider<Context> contextProvider;

  public NetworkModule_ProvideNetworkConnectivityFactory(NetworkModule module,
      Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public NetworkConnectivity get() {
    return provideNetworkConnectivity(module, contextProvider.get());
  }

  public static NetworkModule_ProvideNetworkConnectivityFactory create(NetworkModule module,
      Provider<Context> contextProvider) {
    return new NetworkModule_ProvideNetworkConnectivityFactory(module, contextProvider);
  }

  public static NetworkConnectivity provideNetworkConnectivity(NetworkModule instance,
      Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideNetworkConnectivity(context));
  }
}
