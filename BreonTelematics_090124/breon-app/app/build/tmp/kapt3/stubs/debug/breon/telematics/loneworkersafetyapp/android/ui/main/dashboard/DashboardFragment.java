package breon.telematics.loneworkersafetyapp.android.ui.main.dashboard;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0007J\b\u00102\u001a\u00020/H\u0002J\b\u00103\u001a\u00020/H\u0002J$\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020/H\u0016J\b\u0010=\u001a\u00020/H\u0016J\b\u0010>\u001a\u00020/H\u0016J\u0010\u0010?\u001a\u00020/2\u0006\u00100\u001a\u00020@H\u0007J\b\u0010A\u001a\u00020/H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\n\u001a\u0004\b\"\u0010#R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\'0&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b+\u0010,\u00a8\u0006B"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/DashboardFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lbreon/telematics/loneworkersafetyapp/android/databinding/FragmentDashboardBinding;", "assistFragment", "Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/assist/AssistFragment;", "getAssistFragment", "()Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/assist/AssistFragment;", "assistFragment$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lbreon/telematics/loneworkersafetyapp/android/databinding/FragmentDashboardBinding;", "checkInFragment", "Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/checkin/CheckInFragment;", "getCheckInFragment", "()Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/checkin/CheckInFragment;", "checkInFragment$delegate", "hazardFragment", "Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/hazard/HazardFragment;", "getHazardFragment", "()Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/hazard/HazardFragment;", "hazardFragment$delegate", "onPageChangeCallback", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "prefManager", "Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "getPrefManager", "()Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "setPrefManager", "(Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;)V", "sosFragment", "Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/sos/SosFragment;", "getSosFragment", "()Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/sos/SosFragment;", "sosFragment$delegate", "titles", "", "", "username", "viewModel", "Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/DashboardViewModel;", "getViewModel", "()Lbreon/telematics/loneworkersafetyapp/android/ui/main/dashboard/DashboardViewModel;", "viewModel$delegate", "changeUi", "", "status", "Lbreon/telematics/loneworkersafetyapp/android/utils/CurrentStatus;", "handleUiLogic", "observeData", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onStart", "openSignOnManagementPage", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/OffDutyStatus;", "setUpViewPager", "app_debug"})
public final class DashboardFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private breon.telematics.loneworkersafetyapp.android.databinding.FragmentDashboardBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> titles = null;
    @javax.inject.Inject()
    public breon.telematics.loneworkersafetyapp.android.utils.PrefManager prefManager;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String username = "";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy checkInFragment$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy assistFragment$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy hazardFragment$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy sosFragment$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback onPageChangeCallback = null;
    
    public DashboardFragment() {
        super();
    }
    
    private final breon.telematics.loneworkersafetyapp.android.databinding.FragmentDashboardBinding getBinding() {
        return null;
    }
    
    private final breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.DashboardViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.utils.PrefManager getPrefManager() {
        return null;
    }
    
    public final void setPrefManager(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.utils.PrefManager p0) {
    }
    
    private final breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.checkin.CheckInFragment getCheckInFragment() {
        return null;
    }
    
    private final breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.assist.AssistFragment getAssistFragment() {
        return null;
    }
    
    private final breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.hazard.HazardFragment getHazardFragment() {
        return null;
    }
    
    private final breon.telematics.loneworkersafetyapp.android.ui.main.dashboard.sos.SosFragment getSosFragment() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setUpViewPager() {
    }
    
    private final void handleUiLogic() {
    }
    
    private final void observeData() {
    }
    
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN_ORDERED)
    public final void changeUi(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.utils.CurrentStatus status) {
    }
    
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN_ORDERED)
    public final void openSignOnManagementPage(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.OffDutyStatus status) {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}