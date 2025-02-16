package breon.telematics.loneworkersafetyapp.android.ui.main.take2form;

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
public final class Take2FormActivity_MembersInjector implements MembersInjector<Take2FormActivity> {
  private final Provider<PrefManager> prefProvider;

  public Take2FormActivity_MembersInjector(Provider<PrefManager> prefProvider) {
    this.prefProvider = prefProvider;
  }

  public static MembersInjector<Take2FormActivity> create(Provider<PrefManager> prefProvider) {
    return new Take2FormActivity_MembersInjector(prefProvider);
  }

  @Override
  public void injectMembers(Take2FormActivity instance) {
    injectPref(instance, prefProvider.get());
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.ui.main.take2form.Take2FormActivity.pref")
  public static void injectPref(Take2FormActivity instance, PrefManager pref) {
    instance.pref = pref;
  }
}
