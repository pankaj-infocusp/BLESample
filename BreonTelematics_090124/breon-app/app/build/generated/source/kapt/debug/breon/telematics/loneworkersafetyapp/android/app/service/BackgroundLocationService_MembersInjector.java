package breon.telematics.loneworkersafetyapp.android.app.service;

import breon.telematics.loneworkersafetyapp.android.data.services.BreonService;
import breon.telematics.loneworkersafetyapp.android.domain.network.NetworkConnectivity;
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
public final class BackgroundLocationService_MembersInjector implements MembersInjector<BackgroundLocationService> {
  private final Provider<NetworkConnectivity> networkConnectivityProvider;

  private final Provider<BreonService> breonServiceProvider;

  private final Provider<PrefManager> prefProvider;

  private final Provider<FusedLocationProviderClient> fusedLocationClientProvider;

  public BackgroundLocationService_MembersInjector(
      Provider<NetworkConnectivity> networkConnectivityProvider,
      Provider<BreonService> breonServiceProvider, Provider<PrefManager> prefProvider,
      Provider<FusedLocationProviderClient> fusedLocationClientProvider) {
    this.networkConnectivityProvider = networkConnectivityProvider;
    this.breonServiceProvider = breonServiceProvider;
    this.prefProvider = prefProvider;
    this.fusedLocationClientProvider = fusedLocationClientProvider;
  }

  public static MembersInjector<BackgroundLocationService> create(
      Provider<NetworkConnectivity> networkConnectivityProvider,
      Provider<BreonService> breonServiceProvider, Provider<PrefManager> prefProvider,
      Provider<FusedLocationProviderClient> fusedLocationClientProvider) {
    return new BackgroundLocationService_MembersInjector(networkConnectivityProvider, breonServiceProvider, prefProvider, fusedLocationClientProvider);
  }

  @Override
  public void injectMembers(BackgroundLocationService instance) {
    injectNetworkConnectivity(instance, networkConnectivityProvider.get());
    injectBreonService(instance, breonServiceProvider.get());
    injectPref(instance, prefProvider.get());
    injectFusedLocationClient(instance, fusedLocationClientProvider.get());
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.app.service.BackgroundLocationService.networkConnectivity")
  public static void injectNetworkConnectivity(BackgroundLocationService instance,
      NetworkConnectivity networkConnectivity) {
    instance.networkConnectivity = networkConnectivity;
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.app.service.BackgroundLocationService.breonService")
  public static void injectBreonService(BackgroundLocationService instance,
      BreonService breonService) {
    instance.breonService = breonService;
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.app.service.BackgroundLocationService.pref")
  public static void injectPref(BackgroundLocationService instance, PrefManager pref) {
    instance.pref = pref;
  }

  @InjectedFieldSignature("breon.telematics.loneworkersafetyapp.android.app.service.BackgroundLocationService.fusedLocationClient")
  public static void injectFusedLocationClient(BackgroundLocationService instance,
      FusedLocationProviderClient fusedLocationClient) {
    instance.fusedLocationClient = fusedLocationClient;
  }
}
