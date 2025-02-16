package breon.telematics.loneworkersafetyapp.android.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

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
public final class NetworkModule_ProvideDevRetrofitInstanceFactory implements Factory<Retrofit> {
  private final NetworkModule module;

  private final Provider<OkHttpClient> okHttpClientProvider;

  public NetworkModule_ProvideDevRetrofitInstanceFactory(NetworkModule module,
      Provider<OkHttpClient> okHttpClientProvider) {
    this.module = module;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public Retrofit get() {
    return provideDevRetrofitInstance(module, okHttpClientProvider.get());
  }

  public static NetworkModule_ProvideDevRetrofitInstanceFactory create(NetworkModule module,
      Provider<OkHttpClient> okHttpClientProvider) {
    return new NetworkModule_ProvideDevRetrofitInstanceFactory(module, okHttpClientProvider);
  }

  public static Retrofit provideDevRetrofitInstance(NetworkModule instance,
      OkHttpClient okHttpClient) {
    return Preconditions.checkNotNullFromProvides(instance.provideDevRetrofitInstance(okHttpClient));
  }
}
