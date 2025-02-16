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
public final class UpdateContactDetailsUseCase_Factory implements Factory<UpdateContactDetailsUseCase> {
  private final Provider<BreonRepository> breonRepositoryProvider;

  public UpdateContactDetailsUseCase_Factory(Provider<BreonRepository> breonRepositoryProvider) {
    this.breonRepositoryProvider = breonRepositoryProvider;
  }

  @Override
  public UpdateContactDetailsUseCase get() {
    return newInstance(breonRepositoryProvider.get());
  }

  public static UpdateContactDetailsUseCase_Factory create(
      Provider<BreonRepository> breonRepositoryProvider) {
    return new UpdateContactDetailsUseCase_Factory(breonRepositoryProvider);
  }

  public static UpdateContactDetailsUseCase newInstance(BreonRepository breonRepository) {
    return new UpdateContactDetailsUseCase(breonRepository);
  }
}
