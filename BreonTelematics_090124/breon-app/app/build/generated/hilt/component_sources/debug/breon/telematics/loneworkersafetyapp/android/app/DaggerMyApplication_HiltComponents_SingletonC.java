package breon.telematics.loneworkersafetyapp.android.app;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import breon.telematics.loneworkersafetyapp.android.app.service.BackgroundLocationService;
import breon.telematics.loneworkersafetyapp.android.app.service.BackgroundLocationService_MembersInjector;
import breon.telematics.loneworkersafetyapp.android.app.service.CountDownTimerService;
import breon.telematics.loneworkersafetyapp.android.app.service.CountDownTimerService_MembersInjector;
import breon.telematics.loneworkersafetyapp.android.data.error_handler.GeneralErrorHandlerImpl;
import breon.telematics.loneworkersafetyapp.android.data.repository.BreonRepositoryImpl;
import breon.telematics.loneworkersafetyapp.android.data.services.BreonService;
import breon.telematics.loneworkersafetyapp.android.data.source.intercepter.AuthInterceptor;
import breon.telematics.loneworkersafetyapp.android.data.source.remote.BreonDataSourceImpl;
import breon.telematics.loneworkersafetyapp.android.di.AppModule;
import breon.telematics.loneworkersafetyapp.android.di.AppModule_ProvideFusedLocationClientFactory;
import breon.telematics.loneworkersafetyapp.android.di.AppModule_ProvidePrefManagerFactory;
import breon.telematics.loneworkersafetyapp.android.di.NetworkModule;
import breon.telematics.loneworkersafetyapp.android.di.NetworkModule_ProvideAuthInterceptorFactory;
import breon.telematics.loneworkersafetyapp.android.di.NetworkModule_ProvideBreonServiceFactory;
import breon.telematics.loneworkersafetyapp.android.di.NetworkModule_ProvideDevBreonServiceFactory;
import breon.telematics.loneworkersafetyapp.android.di.NetworkModule_ProvideDevRetrofitInstanceFactory;
import breon.telematics.loneworkersafetyapp.android.di.NetworkModule_ProvideFirebaseInstallationIdFactory;
import breon.telematics.loneworkersafetyapp.android.di.NetworkModule_ProvideHttpClientFactory;
import breon.telematics.loneworkersafetyapp.android.di.NetworkModule_ProvideNetworkConnectivityFactory;
import breon.telematics.loneworkersafetyapp.android.di.NetworkModule_ProvideRetrofitInstanceFactory;
import breon.telematics.loneworkersafetyapp.android.domain.network.NetworkConnectivity;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.ConfirmDetailsUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.DeviceWebServiceSmartphoneUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.LoginUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.Take2FormUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.TemplateDetailsUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.TemplatesUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.UpdateContactDetailsUseCase;
import breon.telematics.loneworkersafetyapp.android.domain.usecases.UpdateTemplateUseCase;
import breon.telematics.loneworkersafetyapp.android.ui.login.LoginActivity;
import breon.telematics.loneworkersafetyapp.android.ui.login.LoginActivity_MembersInjector;
import breon.telematics.loneworkersafetyapp.android.ui.login.LoginViewModel;
import breon.telematics.loneworkersafetyapp.android.ui.login.LoginViewModel_HiltModules_KeyModule_ProvideFactory;
import breon.telematics.loneworkersafetyapp.android.ui.main.activity.MyDashboardActivity;
import breon.telematics.loneworkersafetyapp.android.ui.main.activity.MyDashboardActivity_MembersInjector;
import breon.telematics.loneworkersafetyapp.android.ui.main.activity.MyDashboardViewModel;
import breon.telematics.loneworkersafetyapp.android.ui.main.activity.MyDashboardViewModel_HiltModules_KeyModule_ProvideFactory;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.DashboardFragment;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.DashboardFragment_MembersInjector;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.DashboardViewModel;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.DashboardViewModel_HiltModules_KeyModule_ProvideFactory;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.assist.AssistFragment;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.assist.AssistFragment_MembersInjector;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.assist.AssistsViewModel;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.assist.AssistsViewModel_HiltModules_KeyModule_ProvideFactory;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.checkin.CheckInFragment;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.checkin.CheckInFragment_MembersInjector;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.checkin.CheckInViewModel;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.checkin.CheckInViewModel_HiltModules_KeyModule_ProvideFactory;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.hazard.HazardFragment;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.hazard.HazardFragment_MembersInjector;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.hazard.HazardViewModel;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.hazard.HazardViewModel_HiltModules_KeyModule_ProvideFactory;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.sos.SosFragment;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.sos.SosFragment_MembersInjector;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.sos.SosViewModel;
import breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.sos.SosViewModel_HiltModules_KeyModule_ProvideFactory;
import breon.telematics.loneworkersafetyapp.android.ui.main.settings.SettingsFragment;
import breon.telematics.loneworkersafetyapp.android.ui.main.settings.SettingsFragment_MembersInjector;
import breon.telematics.loneworkersafetyapp.android.ui.main.settings.SettingsViewModel;
import breon.telematics.loneworkersafetyapp.android.ui.main.settings.SettingsViewModel_HiltModules_KeyModule_ProvideFactory;
import breon.telematics.loneworkersafetyapp.android.ui.main.sign_on_management.SignOnManagementFragment;
import breon.telematics.loneworkersafetyapp.android.ui.main.sign_on_management.SignOnManagementFragment_MembersInjector;
import breon.telematics.loneworkersafetyapp.android.ui.main.sign_on_management.SignOnManagementViewModel;
import breon.telematics.loneworkersafetyapp.android.ui.main.sign_on_management.SignOnManagementViewModel_HiltModules_KeyModule_ProvideFactory;
import breon.telematics.loneworkersafetyapp.android.ui.main.take2form.Take2FormActivity;
import breon.telematics.loneworkersafetyapp.android.ui.main.take2form.Take2FormActivity_MembersInjector;
import breon.telematics.loneworkersafetyapp.android.ui.main.take2form.Take2FormModelViewModel;
import breon.telematics.loneworkersafetyapp.android.ui.main.take2form.Take2FormModelViewModel_HiltModules_KeyModule_ProvideFactory;
import breon.telematics.loneworkersafetyapp.android.utils.PrefManager;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

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
public final class DaggerMyApplication_HiltComponents_SingletonC {
  private DaggerMyApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private NetworkModule networkModule;

    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder appModule(AppModule appModule) {
      Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule(
        HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule) {
      Preconditions.checkNotNull(hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule);
      return this;
    }

    public Builder networkModule(NetworkModule networkModule) {
      this.networkModule = Preconditions.checkNotNull(networkModule);
      return this;
    }

    public MyApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      if (networkModule == null) {
        this.networkModule = new NetworkModule();
      }
      return new SingletonCImpl(applicationContextModule, networkModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements MyApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public MyApplication_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl(singletonCImpl);
    }
  }

  private static final class ActivityCBuilder implements MyApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements MyApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements MyApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements MyApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements MyApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements MyApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends MyApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends MyApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public void injectDashboardFragment(DashboardFragment arg0) {
      injectDashboardFragment2(arg0);
    }

    @Override
    public void injectAssistFragment(AssistFragment arg0) {
      injectAssistFragment2(arg0);
    }

    @Override
    public void injectCheckInFragment(CheckInFragment arg0) {
      injectCheckInFragment2(arg0);
    }

    @Override
    public void injectHazardFragment(HazardFragment arg0) {
      injectHazardFragment2(arg0);
    }

    @Override
    public void injectSosFragment(SosFragment arg0) {
      injectSosFragment2(arg0);
    }

    @Override
    public void injectSettingsFragment(SettingsFragment arg0) {
      injectSettingsFragment2(arg0);
    }

    @Override
    public void injectSignOnManagementFragment(SignOnManagementFragment arg0) {
      injectSignOnManagementFragment2(arg0);
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }

    @CanIgnoreReturnValue
    private DashboardFragment injectDashboardFragment2(DashboardFragment instance) {
      DashboardFragment_MembersInjector.injectPrefManager(instance, singletonCImpl.providePrefManagerProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private AssistFragment injectAssistFragment2(AssistFragment instance) {
      AssistFragment_MembersInjector.injectFusedLocationClient(instance, singletonCImpl.provideFusedLocationClientProvider.get());
      AssistFragment_MembersInjector.injectPref(instance, singletonCImpl.providePrefManagerProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private CheckInFragment injectCheckInFragment2(CheckInFragment instance) {
      CheckInFragment_MembersInjector.injectPref(instance, singletonCImpl.providePrefManagerProvider.get());
      CheckInFragment_MembersInjector.injectFusedLocationClient(instance, singletonCImpl.provideFusedLocationClientProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private HazardFragment injectHazardFragment2(HazardFragment instance) {
      HazardFragment_MembersInjector.injectFusedLocationClient(instance, singletonCImpl.provideFusedLocationClientProvider.get());
      HazardFragment_MembersInjector.injectPref(instance, singletonCImpl.providePrefManagerProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private SosFragment injectSosFragment2(SosFragment instance) {
      SosFragment_MembersInjector.injectFusedLocationClient(instance, singletonCImpl.provideFusedLocationClientProvider.get());
      SosFragment_MembersInjector.injectPref(instance, singletonCImpl.providePrefManagerProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private SettingsFragment injectSettingsFragment2(SettingsFragment instance) {
      SettingsFragment_MembersInjector.injectPrefManager(instance, singletonCImpl.providePrefManagerProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private SignOnManagementFragment injectSignOnManagementFragment2(
        SignOnManagementFragment instance) {
      SignOnManagementFragment_MembersInjector.injectPref(instance, singletonCImpl.providePrefManagerProvider.get());
      SignOnManagementFragment_MembersInjector.injectFusedLocationClient(instance, singletonCImpl.provideFusedLocationClientProvider.get());
      return instance;
    }
  }

  private static final class ViewCImpl extends MyApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends MyApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectLoginActivity(LoginActivity arg0) {
      injectLoginActivity2(arg0);
    }

    @Override
    public void injectMyDashboardActivity(MyDashboardActivity arg0) {
      injectMyDashboardActivity2(arg0);
    }

    @Override
    public void injectTake2FormActivity(Take2FormActivity arg0) {
      injectTake2FormActivity2(arg0);
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Set<String> getViewModelKeys() {
      return ImmutableSet.<String>of(AssistsViewModel_HiltModules_KeyModule_ProvideFactory.provide(), CheckInViewModel_HiltModules_KeyModule_ProvideFactory.provide(), DashboardViewModel_HiltModules_KeyModule_ProvideFactory.provide(), HazardViewModel_HiltModules_KeyModule_ProvideFactory.provide(), LoginViewModel_HiltModules_KeyModule_ProvideFactory.provide(), MyDashboardViewModel_HiltModules_KeyModule_ProvideFactory.provide(), SettingsViewModel_HiltModules_KeyModule_ProvideFactory.provide(), SignOnManagementViewModel_HiltModules_KeyModule_ProvideFactory.provide(), SosViewModel_HiltModules_KeyModule_ProvideFactory.provide(), Take2FormModelViewModel_HiltModules_KeyModule_ProvideFactory.provide());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @CanIgnoreReturnValue
    private LoginActivity injectLoginActivity2(LoginActivity instance) {
      LoginActivity_MembersInjector.injectPrefManager(instance, singletonCImpl.providePrefManagerProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private MyDashboardActivity injectMyDashboardActivity2(MyDashboardActivity instance) {
      MyDashboardActivity_MembersInjector.injectPrefManager(instance, singletonCImpl.providePrefManagerProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private Take2FormActivity injectTake2FormActivity2(Take2FormActivity instance) {
      Take2FormActivity_MembersInjector.injectPref(instance, singletonCImpl.providePrefManagerProvider.get());
      return instance;
    }
  }

  private static final class ViewModelCImpl extends MyApplication_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AssistsViewModel> assistsViewModelProvider;

    private Provider<CheckInViewModel> checkInViewModelProvider;

    private Provider<DashboardViewModel> dashboardViewModelProvider;

    private Provider<HazardViewModel> hazardViewModelProvider;

    private Provider<LoginViewModel> loginViewModelProvider;

    private Provider<MyDashboardViewModel> myDashboardViewModelProvider;

    private Provider<SettingsViewModel> settingsViewModelProvider;

    private Provider<SignOnManagementViewModel> signOnManagementViewModelProvider;

    private Provider<SosViewModel> sosViewModelProvider;

    private Provider<Take2FormModelViewModel> take2FormModelViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    private BreonDataSourceImpl breonDataSourceImpl() {
      return new BreonDataSourceImpl(singletonCImpl.provideBreonServiceProvider.get(), singletonCImpl.provideDevBreonServiceProvider.get(), new GeneralErrorHandlerImpl());
    }

    private BreonRepositoryImpl breonRepositoryImpl() {
      return new BreonRepositoryImpl(breonDataSourceImpl());
    }

    private DeviceWebServiceSmartphoneUseCase deviceWebServiceSmartphoneUseCase() {
      return new DeviceWebServiceSmartphoneUseCase(breonRepositoryImpl());
    }

    private AssetDetailsUseCase assetDetailsUseCase() {
      return new AssetDetailsUseCase(breonRepositoryImpl());
    }

    private LoginUseCase loginUseCase() {
      return new LoginUseCase(breonRepositoryImpl());
    }

    private TemplatesUseCase templatesUseCase() {
      return new TemplatesUseCase(breonRepositoryImpl());
    }

    private ConfirmDetailsUseCase confirmDetailsUseCase() {
      return new ConfirmDetailsUseCase(breonRepositoryImpl());
    }

    private UpdateContactDetailsUseCase updateContactDetailsUseCase() {
      return new UpdateContactDetailsUseCase(breonRepositoryImpl());
    }

    private UpdateTemplateUseCase updateTemplateUseCase() {
      return new UpdateTemplateUseCase(breonRepositoryImpl());
    }

    private TemplateDetailsUseCase templateDetailsUseCase() {
      return new TemplateDetailsUseCase(breonRepositoryImpl());
    }

    private Take2FormUseCase take2FormUseCase() {
      return new Take2FormUseCase(breonRepositoryImpl());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.assistsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.checkInViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.dashboardViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.hazardViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.loginViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.myDashboardViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.settingsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
      this.signOnManagementViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 7);
      this.sosViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 8);
      this.take2FormModelViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 9);
    }

    @Override
    public Map<String, Provider<ViewModel>> getHiltViewModelMap() {
      return ImmutableMap.<String, Provider<ViewModel>>builderWithExpectedSize(10).put("breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.assist.AssistsViewModel", ((Provider) assistsViewModelProvider)).put("breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.checkin.CheckInViewModel", ((Provider) checkInViewModelProvider)).put("breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.DashboardViewModel", ((Provider) dashboardViewModelProvider)).put("breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.hazard.HazardViewModel", ((Provider) hazardViewModelProvider)).put("breon.telematics.loneworkersafetyapp.android.ui.login.LoginViewModel", ((Provider) loginViewModelProvider)).put("breon.telematics.loneworkersafetyapp.android.ui.main.activity.MyDashboardViewModel", ((Provider) myDashboardViewModelProvider)).put("breon.telematics.loneworkersafetyapp.android.ui.main.settings.SettingsViewModel", ((Provider) settingsViewModelProvider)).put("breon.telematics.loneworkersafetyapp.android.ui.main.sign_on_management.SignOnManagementViewModel", ((Provider) signOnManagementViewModelProvider)).put("breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.sos.SosViewModel", ((Provider) sosViewModelProvider)).put("breon.telematics.loneworkersafetyapp.android.ui.main.take2form.Take2FormModelViewModel", ((Provider) take2FormModelViewModelProvider)).build();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.assist.AssistsViewModel 
          return (T) new AssistsViewModel(viewModelCImpl.deviceWebServiceSmartphoneUseCase(), viewModelCImpl.assetDetailsUseCase());

          case 1: // breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.checkin.CheckInViewModel 
          return (T) new CheckInViewModel(viewModelCImpl.deviceWebServiceSmartphoneUseCase(), viewModelCImpl.assetDetailsUseCase(), singletonCImpl.providePrefManagerProvider.get());

          case 2: // breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.DashboardViewModel 
          return (T) new DashboardViewModel(viewModelCImpl.deviceWebServiceSmartphoneUseCase());

          case 3: // breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.hazard.HazardViewModel 
          return (T) new HazardViewModel(viewModelCImpl.deviceWebServiceSmartphoneUseCase(), viewModelCImpl.assetDetailsUseCase(), singletonCImpl.providePrefManagerProvider.get());

          case 4: // breon.telematics.loneworkersafetyapp.android.ui.login.LoginViewModel 
          return (T) new LoginViewModel(viewModelCImpl.loginUseCase(), viewModelCImpl.templatesUseCase(), viewModelCImpl.assetDetailsUseCase());

          case 5: // breon.telematics.loneworkersafetyapp.android.ui.main.activity.MyDashboardViewModel 
          return (T) new MyDashboardViewModel(viewModelCImpl.assetDetailsUseCase());

          case 6: // breon.telematics.loneworkersafetyapp.android.ui.main.settings.SettingsViewModel 
          return (T) new SettingsViewModel(viewModelCImpl.confirmDetailsUseCase(), viewModelCImpl.updateContactDetailsUseCase(), viewModelCImpl.updateTemplateUseCase(), viewModelCImpl.templateDetailsUseCase(), singletonCImpl.providePrefManagerProvider.get());

          case 7: // breon.telematics.loneworkersafetyapp.android.ui.main.sign_on_management.SignOnManagementViewModel 
          return (T) new SignOnManagementViewModel(viewModelCImpl.loginUseCase(), viewModelCImpl.deviceWebServiceSmartphoneUseCase(), viewModelCImpl.confirmDetailsUseCase(), viewModelCImpl.assetDetailsUseCase(), viewModelCImpl.take2FormUseCase());

          case 8: // breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.sos.SosViewModel 
          return (T) new SosViewModel(viewModelCImpl.deviceWebServiceSmartphoneUseCase(), viewModelCImpl.assetDetailsUseCase());

          case 9: // breon.telematics.loneworkersafetyapp.android.ui.main.take2form.Take2FormModelViewModel 
          return (T) new Take2FormModelViewModel(viewModelCImpl.take2FormUseCase());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends MyApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends MyApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }

    @Override
    public void injectBackgroundLocationService(BackgroundLocationService arg0) {
      injectBackgroundLocationService2(arg0);
    }

    @Override
    public void injectCountDownTimerService(CountDownTimerService arg0) {
      injectCountDownTimerService2(arg0);
    }

    @CanIgnoreReturnValue
    private BackgroundLocationService injectBackgroundLocationService2(
        BackgroundLocationService instance) {
      BackgroundLocationService_MembersInjector.injectNetworkConnectivity(instance, singletonCImpl.provideNetworkConnectivityProvider.get());
      BackgroundLocationService_MembersInjector.injectBreonService(instance, singletonCImpl.provideBreonServiceProvider.get());
      BackgroundLocationService_MembersInjector.injectPref(instance, singletonCImpl.providePrefManagerProvider.get());
      BackgroundLocationService_MembersInjector.injectFusedLocationClient(instance, singletonCImpl.provideFusedLocationClientProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private CountDownTimerService injectCountDownTimerService2(CountDownTimerService instance) {
      CountDownTimerService_MembersInjector.injectPref(instance, singletonCImpl.providePrefManagerProvider.get());
      return instance;
    }
  }

  private static final class SingletonCImpl extends MyApplication_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final NetworkModule networkModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<PrefManager> providePrefManagerProvider;

    private Provider<FusedLocationProviderClient> provideFusedLocationClientProvider;

    private Provider<String> provideFirebaseInstallationIdProvider;

    private Provider<AuthInterceptor> provideAuthInterceptorProvider;

    private Provider<OkHttpClient> provideHttpClientProvider;

    private Provider<Retrofit> provideRetrofitInstanceProvider;

    private Provider<BreonService> provideBreonServiceProvider;

    private Provider<Retrofit> provideDevRetrofitInstanceProvider;

    private Provider<BreonService> provideDevBreonServiceProvider;

    private Provider<NetworkConnectivity> provideNetworkConnectivityProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam,
        NetworkModule networkModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      this.networkModule = networkModuleParam;
      initialize(applicationContextModuleParam, networkModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam,
        final NetworkModule networkModuleParam) {
      this.providePrefManagerProvider = DoubleCheck.provider(new SwitchingProvider<PrefManager>(singletonCImpl, 0));
      this.provideFusedLocationClientProvider = DoubleCheck.provider(new SwitchingProvider<FusedLocationProviderClient>(singletonCImpl, 1));
      this.provideFirebaseInstallationIdProvider = DoubleCheck.provider(new SwitchingProvider<String>(singletonCImpl, 6));
      this.provideAuthInterceptorProvider = DoubleCheck.provider(new SwitchingProvider<AuthInterceptor>(singletonCImpl, 5));
      this.provideHttpClientProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 4));
      this.provideRetrofitInstanceProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 3));
      this.provideBreonServiceProvider = DoubleCheck.provider(new SwitchingProvider<BreonService>(singletonCImpl, 2));
      this.provideDevRetrofitInstanceProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 8));
      this.provideDevBreonServiceProvider = DoubleCheck.provider(new SwitchingProvider<BreonService>(singletonCImpl, 7));
      this.provideNetworkConnectivityProvider = DoubleCheck.provider(new SwitchingProvider<NetworkConnectivity>(singletonCImpl, 9));
    }

    @Override
    public void injectMyApplication(MyApplication myApplication) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return ImmutableSet.<Boolean>of();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // breon.telematics.loneworkersafetyapp.android.utils.PrefManager 
          return (T) AppModule_ProvidePrefManagerFactory.providePrefManager(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 1: // com.google.android.gms.location.FusedLocationProviderClient 
          return (T) AppModule_ProvideFusedLocationClientFactory.provideFusedLocationClient(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 2: // breon.telematics.loneworkersafetyapp.android.data.services.BreonService 
          return (T) NetworkModule_ProvideBreonServiceFactory.provideBreonService(singletonCImpl.networkModule, singletonCImpl.provideRetrofitInstanceProvider.get());

          case 3: // retrofit2.Retrofit 
          return (T) NetworkModule_ProvideRetrofitInstanceFactory.provideRetrofitInstance(singletonCImpl.networkModule, singletonCImpl.provideHttpClientProvider.get());

          case 4: // okhttp3.OkHttpClient 
          return (T) NetworkModule_ProvideHttpClientFactory.provideHttpClient(singletonCImpl.networkModule, singletonCImpl.provideAuthInterceptorProvider.get());

          case 5: // breon.telematics.loneworkersafetyapp.android.data.source.intercepter.AuthInterceptor 
          return (T) NetworkModule_ProvideAuthInterceptorFactory.provideAuthInterceptor(singletonCImpl.networkModule, singletonCImpl.provideFirebaseInstallationIdProvider.get());

          case 6: // @javax.inject.Named("FirebaseInstallationId") java.lang.String 
          return (T) NetworkModule_ProvideFirebaseInstallationIdFactory.provideFirebaseInstallationId(singletonCImpl.networkModule);

          case 7: // @javax.inject.Named("dev_environment") breon.telematics.loneworkersafetyapp.android.data.services.BreonService 
          return (T) NetworkModule_ProvideDevBreonServiceFactory.provideDevBreonService(singletonCImpl.networkModule, singletonCImpl.provideDevRetrofitInstanceProvider.get());

          case 8: // @javax.inject.Named("dev_environment") retrofit2.Retrofit 
          return (T) NetworkModule_ProvideDevRetrofitInstanceFactory.provideDevRetrofitInstance(singletonCImpl.networkModule, singletonCImpl.provideHttpClientProvider.get());

          case 9: // breon.telematics.loneworkersafetyapp.android.domain.network.NetworkConnectivity 
          return (T) NetworkModule_ProvideNetworkConnectivityFactory.provideNetworkConnectivity(singletonCImpl.networkModule, ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
