package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.hazard;

import breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.DeviceWebServiceSmartphoneUseCase;
import breon.telematics.loneworkersafetyapp.android.utils.PrefManager;
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
public final class HazardViewModel_Factory implements Factory<HazardViewModel> {
  private final Provider<DeviceWebServiceSmartphoneUseCase> deviceWebServiceUseCaseProvider;

  private final Provider<AssetDetailsUseCase> assetDetailsUseCaseProvider;

  private final Provider<PrefManager> prefsProvider;

  public HazardViewModel_Factory(
      Provider<DeviceWebServiceSmartphoneUseCase> deviceWebServiceUseCaseProvider,
      Provider<AssetDetailsUseCase> assetDetailsUseCaseProvider,
      Provider<PrefManager> prefsProvider) {
    this.deviceWebServiceUseCaseProvider = deviceWebServiceUseCaseProvider;
    this.assetDetailsUseCaseProvider = assetDetailsUseCaseProvider;
    this.prefsProvider = prefsProvider;
  }

  @Override
  public HazardViewModel get() {
    return newInstance(deviceWebServiceUseCaseProvider.get(), assetDetailsUseCaseProvider.get(), prefsProvider.get());
  }

  public static HazardViewModel_Factory create(
      Provider<DeviceWebServiceSmartphoneUseCase> deviceWebServiceUseCaseProvider,
      Provider<AssetDetailsUseCase> assetDetailsUseCaseProvider,
      Provider<PrefManager> prefsProvider) {
    return new HazardViewModel_Factory(deviceWebServiceUseCaseProvider, assetDetailsUseCaseProvider, prefsProvider);
  }

  public static HazardViewModel newInstance(
      DeviceWebServiceSmartphoneUseCase deviceWebServiceUseCase,
      AssetDetailsUseCase assetDetailsUseCase, PrefManager prefs) {
    return new HazardViewModel(deviceWebServiceUseCase, assetDetailsUseCase, prefs);
  }
}
