package breon.telematics.loneworkersafetyapp.android.ui.main.take2form;

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
public final class Take2FormModelViewModel_Factory implements Factory<Take2FormModelViewModel> {
  private final Provider<Take2FormUseCase> take2FormUseCaseProvider;

  public Take2FormModelViewModel_Factory(Provider<Take2FormUseCase> take2FormUseCaseProvider) {
    this.take2FormUseCaseProvider = take2FormUseCaseProvider;
  }

  @Override
  public Take2FormModelViewModel get() {
    return newInstance(take2FormUseCaseProvider.get());
  }

  public static Take2FormModelViewModel_Factory create(
      Provider<Take2FormUseCase> take2FormUseCaseProvider) {
    return new Take2FormModelViewModel_Factory(take2FormUseCaseProvider);
  }

  public static Take2FormModelViewModel newInstance(Take2FormUseCase take2FormUseCase) {
    return new Take2FormModelViewModel(take2FormUseCase);
  }
}
