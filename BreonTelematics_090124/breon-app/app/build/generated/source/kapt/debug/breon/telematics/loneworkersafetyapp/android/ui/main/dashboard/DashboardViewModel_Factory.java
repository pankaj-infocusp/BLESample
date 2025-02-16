package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard;

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
public final class DashboardViewModel_Factory implements Factory<DashboardViewModel> {
  private final Provider<DeviceWebServiceSmartphoneUseCase> deviceWebServiceSmartphoneUseCaseProvider;

  public DashboardViewModel_Factory(
      Provider<DeviceWebServiceSmartphoneUseCase> deviceWebServiceSmartphoneUseCaseProvider) {
    this.deviceWebServiceSmartphoneUseCaseProvider = deviceWebServiceSmartphoneUseCaseProvider;
  }

  @Override
  public DashboardViewModel get() {
    return newInstance(deviceWebServiceSmartphoneUseCaseProvider.get());
  }

  public static DashboardViewModel_Factory create(
      Provider<DeviceWebServiceSmartphoneUseCase> deviceWebServiceSmartphoneUseCaseProvider) {
    return new DashboardViewModel_Factory(deviceWebServiceSmartphoneUseCaseProvider);
  }

  public static DashboardViewModel newInstance(
      DeviceWebServiceSmartphoneUseCase deviceWebServiceSmartphoneUseCase) {
    return new DashboardViewModel(deviceWebServiceSmartphoneUseCase);
  }
}
