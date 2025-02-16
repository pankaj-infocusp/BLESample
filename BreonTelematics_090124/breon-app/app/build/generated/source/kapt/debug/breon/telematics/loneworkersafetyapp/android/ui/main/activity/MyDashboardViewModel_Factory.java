package breon.telematics.loneworkersafetyapp.android.ui.main.activity;

import breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase;
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
public final class MyDashboardViewModel_Factory implements Factory<MyDashboardViewModel> {
  private final Provider<AssetDetailsUseCase> assetDetailsUseCaseProvider;

  public MyDashboardViewModel_Factory(Provider<AssetDetailsUseCase> assetDetailsUseCaseProvider) {
    this.assetDetailsUseCaseProvider = assetDetailsUseCaseProvider;
  }

  @Override
  public MyDashboardViewModel get() {
    return newInstance(assetDetailsUseCaseProvider.get());
  }

  public static MyDashboardViewModel_Factory create(
      Provider<AssetDetailsUseCase> assetDetailsUseCaseProvider) {
    return new MyDashboardViewModel_Factory(assetDetailsUseCaseProvider);
  }

  public static MyDashboardViewModel newInstance(AssetDetailsUseCase assetDetailsUseCase) {
    return new MyDashboardViewModel(assetDetailsUseCase);
  }
}
