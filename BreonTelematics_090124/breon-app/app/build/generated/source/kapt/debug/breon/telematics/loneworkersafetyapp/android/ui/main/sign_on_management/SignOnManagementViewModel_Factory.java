package breon.telematics.loneworkersafetyapp.android.ui.main.sign_on_management;

import breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.ConfirmDetailsUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.DeviceWebServiceSmartphoneUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.LoginUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.Take2FormUseCase;
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
public final class SignOnManagementViewModel_Factory implements Factory<SignOnManagementViewModel> {
  private final Provider<LoginUseCase> loginUseCaseProvider;

  private final Provider<DeviceWebServiceSmartphoneUseCase> deviceWebServiceSmartphoneUseCaseProvider;

  private final Provider<ConfirmDetailsUseCase> confirmDetailsUseCaseProvider;

  private final Provider<AssetDetailsUseCase> assetDetailsUseCaseProvider;

  private final Provider<Take2FormUseCase> take2FormUseCaseProvider;

  public SignOnManagementViewModel_Factory(Provider<LoginUseCase> loginUseCaseProvider,
      Provider<DeviceWebServiceSmartphoneUseCase> deviceWebServiceSmartphoneUseCaseProvider,
      Provider<ConfirmDetailsUseCase> confirmDetailsUseCaseProvider,
      Provider<AssetDetailsUseCase> assetDetailsUseCaseProvider,
      Provider<Take2FormUseCase> take2FormUseCaseProvider) {
    this.loginUseCaseProvider = loginUseCaseProvider;
    this.deviceWebServiceSmartphoneUseCaseProvider = deviceWebServiceSmartphoneUseCaseProvider;
    this.confirmDetailsUseCaseProvider = confirmDetailsUseCaseProvider;
    this.assetDetailsUseCaseProvider = assetDetailsUseCaseProvider;
    this.take2FormUseCaseProvider = take2FormUseCaseProvider;
  }

  @Override
  public SignOnManagementViewModel get() {
    return newInstance(loginUseCaseProvider.get(), deviceWebServiceSmartphoneUseCaseProvider.get(), confirmDetailsUseCaseProvider.get(), assetDetailsUseCaseProvider.get(), take2FormUseCaseProvider.get());
  }

  public static SignOnManagementViewModel_Factory create(
      Provider<LoginUseCase> loginUseCaseProvider,
      Provider<DeviceWebServiceSmartphoneUseCase> deviceWebServiceSmartphoneUseCaseProvider,
      Provider<ConfirmDetailsUseCase> confirmDetailsUseCaseProvider,
      Provider<AssetDetailsUseCase> assetDetailsUseCaseProvider,
      Provider<Take2FormUseCase> take2FormUseCaseProvider) {
    return new SignOnManagementViewModel_Factory(loginUseCaseProvider, deviceWebServiceSmartphoneUseCaseProvider, confirmDetailsUseCaseProvider, assetDetailsUseCaseProvider, take2FormUseCaseProvider);
  }

  public static SignOnManagementViewModel newInstance(LoginUseCase loginUseCase,
      DeviceWebServiceSmartphoneUseCase deviceWebServiceSmartphoneUseCase,
      ConfirmDetailsUseCase confirmDetailsUseCase, AssetDetailsUseCase assetDetailsUseCase,
      Take2FormUseCase take2FormUseCase) {
    return new SignOnManagementViewModel(loginUseCase, deviceWebServiceSmartphoneUseCase, confirmDetailsUseCase, assetDetailsUseCase, take2FormUseCase);
  }
}
