package breon.telematics.loneworkersafetyapp.android.ui.main.settings;

import breon.telematics.loneworkersafetyapp.android.domain.usecases.ConfirmDetailsUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.TemplateDetailsUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.UpdateContactDetailsUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.UpdateTemplateUseCase;
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
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<ConfirmDetailsUseCase> confirmDetailsUseCaseProvider;

  private final Provider<UpdateContactDetailsUseCase> updateContactDetailsUseCaseProvider;

  private final Provider<UpdateTemplateUseCase> updateTemplateUseCaseProvider;

  private final Provider<TemplateDetailsUseCase> templateDetailsUseCaseProvider;

  private final Provider<PrefManager> prefManagerProvider;

  public SettingsViewModel_Factory(Provider<ConfirmDetailsUseCase> confirmDetailsUseCaseProvider,
      Provider<UpdateContactDetailsUseCase> updateContactDetailsUseCaseProvider,
      Provider<UpdateTemplateUseCase> updateTemplateUseCaseProvider,
      Provider<TemplateDetailsUseCase> templateDetailsUseCaseProvider,
      Provider<PrefManager> prefManagerProvider) {
    this.confirmDetailsUseCaseProvider = confirmDetailsUseCaseProvider;
    this.updateContactDetailsUseCaseProvider = updateContactDetailsUseCaseProvider;
    this.updateTemplateUseCaseProvider = updateTemplateUseCaseProvider;
    this.templateDetailsUseCaseProvider = templateDetailsUseCaseProvider;
    this.prefManagerProvider = prefManagerProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(confirmDetailsUseCaseProvider.get(), updateContactDetailsUseCaseProvider.get(), updateTemplateUseCaseProvider.get(), templateDetailsUseCaseProvider.get(), prefManagerProvider.get());
  }

  public static SettingsViewModel_Factory create(
      Provider<ConfirmDetailsUseCase> confirmDetailsUseCaseProvider,
      Provider<UpdateContactDetailsUseCase> updateContactDetailsUseCaseProvider,
      Provider<UpdateTemplateUseCase> updateTemplateUseCaseProvider,
      Provider<TemplateDetailsUseCase> templateDetailsUseCaseProvider,
      Provider<PrefManager> prefManagerProvider) {
    return new SettingsViewModel_Factory(confirmDetailsUseCaseProvider, updateContactDetailsUseCaseProvider, updateTemplateUseCaseProvider, templateDetailsUseCaseProvider, prefManagerProvider);
  }

  public static SettingsViewModel newInstance(ConfirmDetailsUseCase confirmDetailsUseCase,
      UpdateContactDetailsUseCase updateContactDetailsUseCase,
      UpdateTemplateUseCase updateTemplateUseCase, TemplateDetailsUseCase templateDetailsUseCase,
      PrefManager prefManager) {
    return new SettingsViewModel(confirmDetailsUseCase, updateContactDetailsUseCase, updateTemplateUseCase, templateDetailsUseCase, prefManager);
  }
}
