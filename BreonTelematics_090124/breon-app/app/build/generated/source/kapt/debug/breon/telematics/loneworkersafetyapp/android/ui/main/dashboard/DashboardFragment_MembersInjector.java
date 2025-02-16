package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard;

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
public final class DashboardFragment_MembersInjector implements MembersInjector<DashboardFragment> {
  private final Provider<PrefManager> prefManagerProvider;

  public DashboardFragment_MembersInjector(Provider<PrefManager> prefManagerProvider) {
    this.prefManagerProvider = prefManagerProvider;
  }

  public static MembersInjector<DashboardFragment> create(
      Provider<PrefManager> prefManagerProvider) {
    return new DashboardFragment_MembersInjector(prefManagerProvider);
  }

  @Override
  public void injectMembers(DashboardFragment instance) {
    injectPrefManager(instance, prefManagerProvider.get());
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.DashboardFragment.prefManager")
  public static void injectPrefManager(DashboardFragment instance, PrefManager prefManager) {
    instance.prefManager = prefManager;
  }
}
