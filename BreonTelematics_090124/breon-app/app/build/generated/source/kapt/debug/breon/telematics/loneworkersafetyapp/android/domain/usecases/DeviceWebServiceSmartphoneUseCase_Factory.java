package breon.telematics.loneworkersafetyapp.android.domain.usecases;

import breon.telematics.loneworkersafetyapp.android.domain.repository.BreonRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class DeviceWebServiceSmartphoneUseCase_Factory implements Factory<DeviceWebServiceSmartphoneUseCase> {
  private final Provider<BreonRepository> breonRepositoryProvider;

  public DeviceWebServiceSmartphoneUseCase_Factory(
      Provider<BreonRepository> breonRepositoryProvider) {
    this.breonRepositoryProvider = breonRepositoryProvider;
  }

  @Override
  public DeviceWebServiceSmartphoneUseCase get() {
    return newInstance(breonRepositoryProvider.get());
  }

  public static DeviceWebServiceSmartphoneUseCase_Factory create(
      Provider<BreonRepository> breonRepositoryProvider) {
    return new DeviceWebServiceSmartphoneUseCase_Factory(breonRepositoryProvider);
  }

  public static DeviceWebServiceSmartphoneUseCase newInstance(BreonRepository breonRepository) {
    return new DeviceWebServiceSmartphoneUseCase(breonRepository);
  }
}
