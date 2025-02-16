package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.assist;

import breon.telematics.loneworkersafetyapp.android.utils.PrefManager;
import com.google.android.gms.location.FusedLocationProviderClient;
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
public final class AssistFragment_MembersInjector implements MembersInjector<AssistFragment> {
  private final Provider<FusedLocationProviderClient> fusedLocationClientProvider;

  private final Provider<PrefManager> prefProvider;

  public AssistFragment_MembersInjector(
      Provider<FusedLocationProviderClient> fusedLocationClientProvider,
      Provider<PrefManager> prefProvider) {
    this.fusedLocationClientProvider = fusedLocationClientProvider;
    this.prefProvider = prefProvider;
  }

  public static MembersInjector<AssistFragment> create(
      Provider<FusedLocationProviderClient> fusedLocationClientProvider,
      Provider<PrefManager> prefProvider) {
    return new AssistFragment_MembersInjector(fusedLocationClientProvider, prefProvider);
  }

  @Override
  public void injectMembers(AssistFragment instance) {
    injectFusedLocationClient(instance, fusedLocationClientProvider.get());
    injectPref(instance, prefProvider.get());
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.assist.AssistFragment.fusedLocationClient")
  public static void injectFusedLocationClient(AssistFragment instance,
      FusedLocationProviderClient fusedLocationClient) {
    instance.fusedLocationClient = fusedLocationClient;
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.assist.AssistFragment.pref")
  public static void injectPref(AssistFragment instance, PrefManager pref) {
    instance.pref = pref;
  }
}
