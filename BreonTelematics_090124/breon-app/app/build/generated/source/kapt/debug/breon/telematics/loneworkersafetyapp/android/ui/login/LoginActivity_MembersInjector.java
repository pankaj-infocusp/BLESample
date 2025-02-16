package breon.telematics.loneworkersafetyapp.android.ui.login;

import breon.telematics.loneworkersafetyapp.android.utils.PrefManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class LoginActivity_MembersInjector implements MembersInjector<LoginActivity> {
  private final Provider<PrefManager> prefManagerProvider;

  public LoginActivity_MembersInjector(Provider<PrefManager> prefManagerProvider) {
    this.prefManagerProvider = prefManagerProvider;
  }

  public static MembersInjector<LoginActivity> create(Provider<PrefManager> prefManagerProvider) {
    return new LoginActivity_MembersInjector(prefManagerProvider);
  }

  @Override
  public void injectMembers(LoginActivity instance) {
    injectPrefManager(instance, prefManagerProvider.get());
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.ui.login.LoginActivity.prefManager")
  public static void injectPrefManager(LoginActivity instance, PrefManager prefManager) {
    instance.prefManager = prefManager;
  }
}
