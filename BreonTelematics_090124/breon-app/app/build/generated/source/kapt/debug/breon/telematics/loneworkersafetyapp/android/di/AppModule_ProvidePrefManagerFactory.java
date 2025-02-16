package breon.telematics.loneworkersafetyapp.android.di;

import android.content.Context;
import breon.telematics.loneworkersafetyapp.android.utils.PrefManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AppModule_ProvidePrefManagerFactory implements Factory<PrefManager> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvidePrefManagerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public PrefManager get() {
    return providePrefManager(contextProvider.get());
  }

  public static AppModule_ProvidePrefManagerFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvidePrefManagerFactory(contextProvider);
  }

  public static PrefManager providePrefManager(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providePrefManager(context));
  }
}
