package breon.telematics.loneworkersafetyapp.android.data.error_handler;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class GeneralErrorHandlerImpl_Factory implements Factory<GeneralErrorHandlerImpl> {
  @Override
  public GeneralErrorHandlerImpl get() {
    return newInstance();
  }

  public static GeneralErrorHandlerImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static GeneralErrorHandlerImpl newInstance() {
    return new GeneralErrorHandlerImpl();
  }

  private static final class InstanceHolder {
    private static final GeneralErrorHandlerImpl_Factory INSTANCE = new GeneralErrorHandlerImpl_Factory();
  }
}
