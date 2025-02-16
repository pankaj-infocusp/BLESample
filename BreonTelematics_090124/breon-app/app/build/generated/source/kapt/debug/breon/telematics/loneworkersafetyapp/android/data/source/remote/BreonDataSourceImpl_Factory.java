package breon.telematics.loneworkersafetyapp.android.data.source.remote;

import breon.telematics.loneworkersafetyapp.android.data.services.BreonService;
import breon.telematics.loneworkersafetyapp.android.domain.error.ErrorHandler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("javax.inject.Named")
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
public final class BreonDataSourceImpl_Factory implements Factory<BreonDataSourceImpl> {
  private final Provider<BreonService> breonServiceProvider;

  private final Provider<BreonService> breonServiceNewProvider;

  private final Provider<ErrorHandler> errorHandlerProvider;

  public BreonDataSourceImpl_Factory(Provider<BreonService> breonServiceProvider,
      Provider<BreonService> breonServiceNewProvider, Provider<ErrorHandler> errorHandlerProvider) {
    this.breonServiceProvider = breonServiceProvider;
    this.breonServiceNewProvider = breonServiceNewProvider;
    this.errorHandlerProvider = errorHandlerProvider;
  }

  @Override
  public BreonDataSourceImpl get() {
    return newInstance(breonServiceProvider.get(), breonServiceNewProvider.get(), errorHandlerProvider.get());
  }

  public static BreonDataSourceImpl_Factory create(Provider<BreonService> breonServiceProvider,
      Provider<BreonService> breonServiceNewProvider, Provider<ErrorHandler> errorHandlerProvider) {
    return new BreonDataSourceImpl_Factory(breonServiceProvider, breonServiceNewProvider, errorHandlerProvider);
  }

  public static BreonDataSourceImpl newInstance(BreonService breonService,
      BreonService breonServiceNew, ErrorHandler errorHandler) {
    return new BreonDataSourceImpl(breonService, breonServiceNew, errorHandler);
  }
}
