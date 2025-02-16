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
public final class LocationTrackingUseCase_Factory implements Factory<LocationTrackingUseCase> {
  private final Provider<BreonRepository> breonRepositoryProvider;

  public LocationTrackingUseCase_Factory(Provider<BreonRepository> breonRepositoryProvider) {
    this.breonRepositoryProvider = breonRepositoryProvider;
  }

  @Override
  public LocationTrackingUseCase get() {
    return newInstance(breonRepositoryProvider.get());
  }

  public static LocationTrackingUseCase_Factory create(
      Provider<BreonRepository> breonRepositoryProvider) {
    return new LocationTrackingUseCase_Factory(breonRepositoryProvider);
  }

  public static LocationTrackingUseCase newInstance(BreonRepository breonRepository) {
    return new LocationTrackingUseCase(breonRepository);
  }
}
