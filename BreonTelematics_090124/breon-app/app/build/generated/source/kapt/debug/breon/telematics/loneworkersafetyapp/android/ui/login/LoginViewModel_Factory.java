package breon.telematics.loneworkersafetyapp.android.ui.login;

import breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.LoginUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.TemplatesUseCase;
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
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
  private final Provider<LoginUseCase> loginUseCaseProvider;

  private final Provider<TemplatesUseCase> templatesUseCaseProvider;

  private final Provider<AssetDetailsUseCase> assetDetailsUseCaseProvider;

  public LoginViewModel_Factory(Provider<LoginUseCase> loginUseCaseProvider,
      Provider<TemplatesUseCase> templatesUseCaseProvider,
      Provider<AssetDetailsUseCase> assetDetailsUseCaseProvider) {
    this.loginUseCaseProvider = loginUseCaseProvider;
    this.templatesUseCaseProvider = templatesUseCaseProvider;
    this.assetDetailsUseCaseProvider = assetDetailsUseCaseProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(loginUseCaseProvider.get(), templatesUseCaseProvider.get(), assetDetailsUseCaseProvider.get());
  }

  public static LoginViewModel_Factory create(Provider<LoginUseCase> loginUseCaseProvider,
      Provider<TemplatesUseCase> templatesUseCaseProvider,
      Provider<AssetDetailsUseCase> assetDetailsUseCaseProvider) {
    return new LoginViewModel_Factory(loginUseCaseProvider, templatesUseCaseProvider, assetDetailsUseCaseProvider);
  }

  public static LoginViewModel newInstance(LoginUseCase loginUseCase,
      TemplatesUseCase templatesUseCase, AssetDetailsUseCase assetDetailsUseCase) {
    return new LoginViewModel(loginUseCase, templatesUseCase, assetDetailsUseCase);
  }
}
