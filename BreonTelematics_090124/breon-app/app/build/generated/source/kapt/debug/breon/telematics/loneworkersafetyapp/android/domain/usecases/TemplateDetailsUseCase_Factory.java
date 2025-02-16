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
public final class TemplateDetailsUseCase_Factory implements Factory<TemplateDetailsUseCase> {
  private final Provider<BreonRepository> breonRepositoryProvider;

  public TemplateDetailsUseCase_Factory(Provider<BreonRepository> breonRepositoryProvider) {
    this.breonRepositoryProvider = breonRepositoryProvider;
  }

  @Override
  public TemplateDetailsUseCase get() {
    return newInstance(breonRepositoryProvider.get());
  }

  public static TemplateDetailsUseCase_Factory create(
      Provider<BreonRepository> breonRepositoryProvider) {
    return new TemplateDetailsUseCase_Factory(breonRepositoryProvider);
  }

  public static TemplateDetailsUseCase newInstance(BreonRepository breonRepository) {
    return new TemplateDetailsUseCase(breonRepository);
  }
}
