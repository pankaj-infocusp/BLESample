package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.sos;

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
public final class SosFragment_MembersInjector implements MembersInjector<SosFragment> {
  private final Provider<FusedLocationProviderClient> fusedLocationClientProvider;

  private final Provider<PrefManager> prefProvider;

  public SosFragment_MembersInjector(
      Provider<FusedLocationProviderClient> fusedLocationClientProvider,
      Provider<PrefManager> prefProvider) {
    this.fusedLocationClientProvider = fusedLocationClientProvider;
    this.prefProvider = prefProvider;
  }

  public static MembersInjector<SosFragment> create(
      Provider<FusedLocationProviderClient> fusedLocationClientProvider,
      Provider<PrefManager> prefProvider) {
    return new SosFragment_MembersInjector(fusedLocationClientProvider, prefProvider);
  }

  @Override
  public void injectMembers(SosFragment instance) {
    injectFusedLocationClient(instance, fusedLocationClientProvider.get());
    injectPref(instance, prefProvider.get());
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.sos.SosFragment.fusedLocationClient")
  public static void injectFusedLocationClient(SosFragment instance,
      FusedLocationProviderClient fusedLocationClient) {
    instance.fusedLocationClient = fusedLocationClient;
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.sos.SosFragment.pref")
  public static void injectPref(SosFragment instance, PrefManager pref) {
    instance.pref = pref;
  }
}
