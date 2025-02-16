package breon.telematics.loneworkersafetyapp.android.ui.main.activity;

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
public final class MyDashboardActivity_MembersInjector implements MembersInjector<MyDashboardActivity> {
  private final Provider<PrefManager> prefManagerProvider;

  public MyDashboardActivity_MembersInjector(Provider<PrefManager> prefManagerProvider) {
    this.prefManagerProvider = prefManagerProvider;
  }

  public static MembersInjector<MyDashboardActivity> create(
      Provider<PrefManager> prefManagerProvider) {
    return new MyDashboardActivity_MembersInjector(prefManagerProvider);
  }

  @Override
  public void injectMembers(MyDashboardActivity instance) {
    injectPrefManager(instance, prefManagerProvider.get());
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.ui.main.activity.MyDashboardActivity.prefManager")
  public static void injectPrefManager(MyDashboardActivity instance, PrefManager prefManager) {
    instance.prefManager = prefManager;
  }
}
