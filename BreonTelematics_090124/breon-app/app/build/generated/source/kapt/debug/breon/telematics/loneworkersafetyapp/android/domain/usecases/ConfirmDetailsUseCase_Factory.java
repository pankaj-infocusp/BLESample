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
public final class ConfirmDetailsUseCase_Factory implements Factory<ConfirmDetailsUseCase> {
  private final Provider<BreonRepository> breonRepositoryProvider;

  public ConfirmDetailsUseCase_Factory(Provider<BreonRepository> breonRepositoryProvider) {
    this.breonRepositoryProvider = breonRepositoryProvider;
  }

  @Override
  public ConfirmDetailsUseCase get() {
    return newInstance(breonRepositoryProvider.get());
  }

  public static ConfirmDetailsUseCase_Factory create(
      Provider<BreonRepository> breonRepositoryProvider) {
    return new ConfirmDetailsUseCase_Factory(breonRepositoryProvider);
  }

  public static ConfirmDetailsUseCase newInstance(BreonRepository breonRepository) {
    return new ConfirmDetailsUseCase(breonRepository);
  }
}
