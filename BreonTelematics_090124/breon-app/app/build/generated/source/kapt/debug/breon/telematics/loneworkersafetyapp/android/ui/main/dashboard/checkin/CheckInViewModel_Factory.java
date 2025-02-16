package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.checkin;

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
public final class CheckInViewModel_Factory implements Factory<CheckInViewModel> {
  private final Provider<DeviceWebServiceSmartphoneUseCase> deviceWebServiceSmartphoneUseCaseProvider;

  private final Provider<AssetDetailsUseCase> assetDetailsUseCaseProvider;

  private final Provider<PrefManager> prefsProvider;

  public CheckInViewModel_Factory(
      Provider<DeviceWebServiceSmartphoneUseCase> deviceWebServiceSmartphoneUseCaseProvider,
      Provider<AssetDetailsUseCase> assetDetailsUseCaseProvider,
      Provider<PrefManager> prefsProvider) {
    this.deviceWebServiceSmartphoneUseCaseProvider = deviceWebServiceSmartphoneUseCaseProvider;
    this.assetDetailsUseCaseProvider = assetDetailsUseCaseProvider;
    this.prefsProvider = prefsProvider;
  }

  @Override
  public CheckInViewModel get() {
    return newInstance(deviceWebServiceSmartphoneUseCaseProvider.get(), assetDetailsUseCaseProvider.get(), prefsProvider.get());
  }

  public static CheckInViewModel_Factory create(
      Provider<DeviceWebServiceSmartphoneUseCase> deviceWebServiceSmartphoneUseCaseProvider,
      Provider<AssetDetailsUseCase> assetDetailsUseCaseProvider,
      Provider<PrefManager> prefsProvider) {
    return new CheckInViewModel_Factory(deviceWebServiceSmartphoneUseCaseProvider, assetDetailsUseCaseProvider, prefsProvider);
  }

  public static CheckInViewModel newInstance(
      DeviceWebServiceSmartphoneUseCase deviceWebServiceSmartphoneUseCase,
      AssetDetailsUseCase assetDetailsUseCase, PrefManager prefs) {
    return new CheckInViewModel(deviceWebServiceSmartphoneUseCase, assetDetailsUseCase, prefs);
  }
}
