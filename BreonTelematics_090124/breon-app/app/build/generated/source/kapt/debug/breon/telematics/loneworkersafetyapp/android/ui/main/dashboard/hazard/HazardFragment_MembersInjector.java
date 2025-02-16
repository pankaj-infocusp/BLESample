package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.hazard;

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
public final class HazardFragment_MembersInjector implements MembersInjector<HazardFragment> {
  private final Provider<FusedLocationProviderClient> fusedLocationClientProvider;

  private final Provider<PrefManager> prefProvider;

  public HazardFragment_MembersInjector(
      Provider<FusedLocationProviderClient> fusedLocationClientProvider,
      Provider<PrefManager> prefProvider) {
    this.fusedLocationClientProvider = fusedLocationClientProvider;
    this.prefProvider = prefProvider;
  }

  public static MembersInjector<HazardFragment> create(
      Provider<FusedLocationProviderClient> fusedLocationClientProvider,
      Provider<PrefManager> prefProvider) {
    return new HazardFragment_MembersInjector(fusedLocationClientProvider, prefProvider);
  }

  @Override
  public void injectMembers(HazardFragment instance) {
    injectFusedLocationClient(instance, fusedLocationClientProvider.get());
    injectPref(instance, prefProvider.get());
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.hazard.HazardFragment.fusedLocationClient")
  public static void injectFusedLocationClient(HazardFragment instance,
      FusedLocationProviderClient fusedLocationClient) {
    instance.fusedLocationClient = fusedLocationClient;
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.hazard.HazardFragment.pref")
  public static void injectPref(HazardFragment instance, PrefManager pref) {
    instance.pref = pref;
  }
}
