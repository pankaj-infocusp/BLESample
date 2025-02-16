package breon.telematics.loneworkersafetyapp.android.ui.main.settings;

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
public final class SettingsFragment_MembersInjector implements MembersInjector<SettingsFragment> {
  private final Provider<PrefManager> prefManagerProvider;

  public SettingsFragment_MembersInjector(Provider<PrefManager> prefManagerProvider) {
    this.prefManagerProvider = prefManagerProvider;
  }

  public static MembersInjector<SettingsFragment> create(
      Provider<PrefManager> prefManagerProvider) {
    return new SettingsFragment_MembersInjector(prefManagerProvider);
  }

  @Override
  public void injectMembers(SettingsFragment instance) {
    injectPrefManager(instance, prefManagerProvider.get());
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.ui.main.settings.SettingsFragment.prefManager")
  public static void injectPrefManager(SettingsFragment instance, PrefManager prefManager) {
    instance.prefManager = prefManager;
  }
}
