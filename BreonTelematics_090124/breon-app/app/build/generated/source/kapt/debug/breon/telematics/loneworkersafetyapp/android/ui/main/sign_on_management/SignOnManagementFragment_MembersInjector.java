package breon.telematics.loneworkersafetyapp.android.ui.main.sign_on_management;

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
public final class SignOnManagementFragment_MembersInjector implements MembersInjector<SignOnManagementFragment> {
  private final Provider<PrefManager> prefProvider;

  private final Provider<FusedLocationProviderClient> fusedLocationClientProvider;

  public SignOnManagementFragment_MembersInjector(Provider<PrefManager> prefProvider,
      Provider<FusedLocationProviderClient> fusedLocationClientProvider) {
    this.prefProvider = prefProvider;
    this.fusedLocationClientProvider = fusedLocationClientProvider;
  }

  public static MembersInjector<SignOnManagementFragment> create(Provider<PrefManager> prefProvider,
      Provider<FusedLocationProviderClient> fusedLocationClientProvider) {
    return new SignOnManagementFragment_MembersInjector(prefProvider, fusedLocationClientProvider);
  }

  @Override
  public void injectMembers(SignOnManagementFragment instance) {
    injectPref(instance, prefProvider.get());
    injectFusedLocationClient(instance, fusedLocationClientProvider.get());
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.ui.main.sign_on_management.SignOnManagementFragment.pref")
  public static void injectPref(SignOnManagementFragment instance, PrefManager pref) {
    instance.pref = pref;
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.ui.main.sign_on_management.SignOnManagementFragment.fusedLocationClient")
  public static void injectFusedLocationClient(SignOnManagementFragment instance,
      FusedLocationProviderClient fusedLocationClient) {
    instance.fusedLocationClient = fusedLocationClient;
  }
}
