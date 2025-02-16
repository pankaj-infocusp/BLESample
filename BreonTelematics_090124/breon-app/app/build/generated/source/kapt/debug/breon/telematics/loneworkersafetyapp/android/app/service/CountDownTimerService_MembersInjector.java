package breon.telematics.loneworkersafetyapp.android.app.service;

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
public final class CountDownTimerService_MembersInjector implements MembersInjector<CountDownTimerService> {
  private final Provider<PrefManager> prefProvider;

  public CountDownTimerService_MembersInjector(Provider<PrefManager> prefProvider) {
    this.prefProvider = prefProvider;
  }

  public static MembersInjector<CountDownTimerService> create(Provider<PrefManager> prefProvider) {
    return new CountDownTimerService_MembersInjector(prefProvider);
  }

  @Override
  public void injectMembers(CountDownTimerService instance) {
    injectPref(instance, prefProvider.get());
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.app.service.CountDownTimerService.pref")
  public static void injectPref(CountDownTimerService instance, PrefManager pref) {
    instance.pref = pref;
  }
}
