package breon.telematics.loneworkersafetyapp.android.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class NetworkModule_ProvideFirebaseInstallationIdFactory implements Factory<String> {
  private final NetworkModule module;

  public NetworkModule_ProvideFirebaseInstallationIdFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public String get() {
    return provideFirebaseInstallationId(module);
  }

  public static NetworkModule_ProvideFirebaseInstallationIdFactory create(NetworkModule module) {
    return new NetworkModule_ProvideFirebaseInstallationIdFactory(module);
  }

  public static String provideFirebaseInstallationId(NetworkModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideFirebaseInstallationId());
  }
}
