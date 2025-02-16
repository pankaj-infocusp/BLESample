package breon.telematics.loneworkersafetyapp.android.ui.main.take2form;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\bH\u0016J\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/ui/main/take2form/Take2FormActionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lbreon/telematics/loneworkersafetyapp/android/ui/main/take2form/Take2FormActionsAdapter$ViewHolder;", "mList", "", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/Take2FormActionsModel;", "(Ljava/util/List;)V", "selectedPosition", "", "taskActions", "Ljava/util/ArrayList;", "", "getItemCount", "getSelectedActions", "Lkotlin/collections/ArrayList;", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class Take2FormActionsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<breon.telematics.loneworkersafetyapp.android.ui.main.take2form.Take2FormActionsAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormActionsModel> mList = null;
    private int selectedPosition = androidx.recyclerview.widget.RecyclerView.NO_POSITION;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<java.lang.String> taskActions = null;
    
    public Take2FormActionsAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormActionsModel> mList) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public breon.telematics.loneworkersafetyapp.android.ui.main.take2form.Take2FormActionsAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.ui.main.take2form.Take2FormActionsAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getSelectedActions() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/ui/main/take2form/Take2FormActionsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lbreon/telematics/loneworkersafetyapp/android/databinding/RowFormActionsBinding;", "(Lbreon/telematics/loneworkersafetyapp/android/databinding/RowFormActionsBinding;)V", "getBinding", "()Lbreon/telematics/loneworkersafetyapp/android/databinding/RowFormActionsBinding;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final breon.telematics.loneworkersafetyapp.android.databinding.RowFormActionsBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        breon.telematics.loneworkersafetyapp.android.databinding.RowFormActionsBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final breon.telematics.loneworkersafetyapp.android.databinding.RowFormActionsBinding getBinding() {
            return null;
        }
    }
}