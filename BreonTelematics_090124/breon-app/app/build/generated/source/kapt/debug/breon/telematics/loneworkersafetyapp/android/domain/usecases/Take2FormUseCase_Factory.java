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
public final class Take2FormUseCase_Factory implements Factory<Take2FormUseCase> {
  private final Provider<BreonRepository> breonRepositoryProvider;

  public Take2FormUseCase_Factory(Provider<BreonRepository> breonRepositoryProvider) {
    this.breonRepositoryProvider = breonRepositoryProvider;
  }

  @Override
  public Take2FormUseCase get() {
    return newInstance(breonRepositoryProvider.get());
  }

  public static Take2FormUseCase_Factory create(Provider<BreonRepository> breonRepositoryProvider) {
    return new Take2FormUseCase_Factory(breonRepositoryProvider);
  }

  public static Take2FormUseCase newInstance(BreonRepository breonRepository) {
    return new Take2FormUseCase(breonRepository);
  }
}
