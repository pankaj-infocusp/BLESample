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
public final class LoginUseCase_Factory implements Factory<LoginUseCase> {
  private final Provider<BreonRepository> breonRepositoryProvider;

  public LoginUseCase_Factory(Provider<BreonRepository> breonRepositoryProvider) {
    this.breonRepositoryProvider = breonRepositoryProvider;
  }

  @Override
  public LoginUseCase get() {
    return newInstance(breonRepositoryProvider.get());
  }

  public static LoginUseCase_Factory create(Provider<BreonRepository> breonRepositoryProvider) {
    return new LoginUseCase_Factory(breonRepositoryProvider);
  }

  public static LoginUseCase newInstance(BreonRepository breonRepository) {
    return new LoginUseCase(breonRepository);
  }
}
