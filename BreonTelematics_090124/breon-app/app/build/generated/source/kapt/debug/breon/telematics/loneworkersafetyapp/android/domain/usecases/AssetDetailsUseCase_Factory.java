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
public final class AssetDetailsUseCase_Factory implements Factory<AssetDetailsUseCase> {
  private final Provider<BreonRepository> breonRepositoryProvider;

  public AssetDetailsUseCase_Factory(Provider<BreonRepository> breonRepositoryProvider) {
    this.breonRepositoryProvider = breonRepositoryProvider;
  }

  @Override
  public AssetDetailsUseCase get() {
    return newInstance(breonRepositoryProvider.get());
  }

  public static AssetDetailsUseCase_Factory create(
      Provider<BreonRepository> breonRepositoryProvider) {
    return new AssetDetailsUseCase_Factory(breonRepositoryProvider);
  }

  public static AssetDetailsUseCase newInstance(BreonRepository breonRepository) {
    return new AssetDetailsUseCase(breonRepository);
  }
}
