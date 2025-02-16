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
public final class UpdateTemplateUseCase_Factory implements Factory<UpdateTemplateUseCase> {
  private final Provider<BreonRepository> breonRepositoryProvider;

  public UpdateTemplateUseCase_Factory(Provider<BreonRepository> breonRepositoryProvider) {
    this.breonRepositoryProvider = breonRepositoryProvider;
  }

  @Override
  public UpdateTemplateUseCase get() {
    return newInstance(breonRepositoryProvider.get());
  }

  public static UpdateTemplateUseCase_Factory create(
      Provider<BreonRepository> breonRepositoryProvider) {
    return new UpdateTemplateUseCase_Factory(breonRepositoryProvider);
  }

  public static UpdateTemplateUseCase newInstance(BreonRepository breonRepository) {
    return new UpdateTemplateUseCase(breonRepository);
  }
}
