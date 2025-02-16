package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.assist;

import breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.DeviceWebServiceSmartphoneUseCase;
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
public final class AssistsViewModel_Factory implements Factory<AssistsViewModel> {
  private final Provider<DeviceWebServiceSmartphoneUseCase> deviceWebServiceUseCaseProvider;

  private final Provider<AssetDetailsUseCase> assetDetailsUseCaseProvider;

  public AssistsViewModel_Factory(
      Provider<DeviceWebServiceSmartphoneUseCase> deviceWebServiceUseCaseProvider,
      Provider<AssetDetailsUseCase> assetDetailsUseCaseProvider) {
    this.deviceWebServiceUseCaseProvider = deviceWebServiceUseCaseProvider;
    this.assetDetailsUseCaseProvider = assetDetailsUseCaseProvider;
  }

  @Override
  public AssistsViewModel get() {
    return newInstance(deviceWebServiceUseCaseProvider.get(), assetDetailsUseCaseProvider.get());
  }

  public static AssistsViewModel_Factory create(
      Provider<DeviceWebServiceSmartphoneUseCase> deviceWebServiceUseCaseProvider,
      Provider<AssetDetailsUseCase> assetDetailsUseCaseProvider) {
    return new AssistsViewModel_Factory(deviceWebServiceUseCaseProvider, assetDetailsUseCaseProvider);
  }

  public static AssistsViewModel newInstance(
      DeviceWebServiceSmartphoneUseCase deviceWebServiceUseCase,
      AssetDetailsUseCase assetDetailsUseCase) {
    return new AssistsViewModel(deviceWebServiceUseCase, assetDetailsUseCase);
  }
}
