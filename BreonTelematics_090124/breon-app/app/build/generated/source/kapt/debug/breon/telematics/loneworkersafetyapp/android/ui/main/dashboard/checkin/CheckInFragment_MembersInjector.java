package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.checkin;

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
public final class CheckInFragment_MembersInjector implements MembersInjector<CheckInFragment> {
  private final Provider<PrefManager> prefProvider;

  private final Provider<FusedLocationProviderClient> fusedLocationClientProvider;

  public CheckInFragment_MembersInjector(Provider<PrefManager> prefProvider,
      Provider<FusedLocationProviderClient> fusedLocationClientProvider) {
    this.prefProvider = prefProvider;
    this.fusedLocationClientProvider = fusedLocationClientProvider;
  }

  public static MembersInjector<CheckInFragment> create(Provider<PrefManager> prefProvider,
      Provider<FusedLocationProviderClient> fusedLocationClientProvider) {
    return new CheckInFragment_MembersInjector(prefProvider, fusedLocationClientProvider);
  }

  @Override
  public void injectMembers(CheckInFragment instance) {
    injectPref(instance, prefProvider.get());
    injectFusedLocationClient(instance, fusedLocationClientProvider.get());
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.checkin.CheckInFragment.pref")
  public static void injectPref(CheckInFragment instance, PrefManager pref) {
    instance.pref = pref;
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.checkin.CheckInFragment.fusedLocationClient")
  public static void injectFusedLocationClient(CheckInFragment instance,
      FusedLocationProviderClient fusedLocationClient) {
    instance.fusedLocationClient = fusedLocationClient;
  }
}
