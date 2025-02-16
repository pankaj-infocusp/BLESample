package breon.telematics.loneworkersafetyapp.android.ui.main.settings;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u001fH\u0016J\u001a\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010/\u001a\u00020\u001fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b\u00a8\u00060"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/ui/main/settings/SettingsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lbreon/telematics/loneworkersafetyapp/android/databinding/FragmentSettingsBinding;", "arrayList", "Ljava/util/ArrayList;", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/UserTemplatesUpdated$UserTemplatesUpdatedItem;", "Lkotlin/collections/ArrayList;", "binding", "getBinding", "()Lbreon/telematics/loneworkersafetyapp/android/databinding/FragmentSettingsBinding;", "prefManager", "Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "getPrefManager", "()Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "setPrefManager", "(Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;)V", "templateId", "", "getTemplateId", "()Ljava/lang/String;", "setTemplateId", "(Ljava/lang/String;)V", "viewModel", "Lbreon/telematics/loneworkersafetyapp/android/ui/main/settings/SettingsViewModel;", "getViewModel", "()Lbreon/telematics/loneworkersafetyapp/android/ui/main/settings/SettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getSharePrefTemplates", "", "getStringArray", "handleUi", "initClickEvents", "observeState", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setSeekBarListener", "app_debug"})
public final class SettingsFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private breon.telematics.loneworkersafetyapp.android.databinding.FragmentSettingsBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @javax.inject.Inject()
    public breon.telematics.loneworkersafetyapp.android.utils.PrefManager prefManager;
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<breon.telematics.loneworkersafetyapp.android.domain.model.response.UserTemplatesUpdated.UserTemplatesUpdatedItem> arrayList;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String templateId = "";
    
    public SettingsFragment() {
        super();
    }
    
    private final breon.telematics.loneworkersafetyapp.android.ui.main.settings.SettingsViewModel getViewModel() {
        return null;
    }
    
    private final breon.telematics.loneworkersafetyapp.android.databinding.FragmentSettingsBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.utils.PrefManager getPrefManager() {
        return null;
    }
    
    public final void setPrefManager(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.utils.PrefManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTemplateId() {
        return null;
    }
    
    public final void setTemplateId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getSharePrefTemplates() {
    }
    
    private final void getStringArray() {
    }
    
    private final void handleUi() {
    }
    
    private final void observeState() {
    }
    
    private final void initClickEvents() {
    }
    
    private final void setSeekBarListener() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}