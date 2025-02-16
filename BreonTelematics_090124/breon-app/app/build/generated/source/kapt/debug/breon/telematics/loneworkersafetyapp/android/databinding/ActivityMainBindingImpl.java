package breon.telematics.loneworkersafetyapp.android.databinding;
import breon.telematics.loneworkersafetyapp.android.R;
import breon.telematics.loneworkersafetyapp.android.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appToolbar, 1);
        sViewsWithIds.put(R.id.mainContent, 2);
        sViewsWithIds.put(R.id.guideline, 3);
        sViewsWithIds.put(R.id.ivAppLogo, 4);
        sViewsWithIds.put(R.id.ivLocationIcon, 5);
        sViewsWithIds.put(R.id.tvDescription, 6);
        sViewsWithIds.put(R.id.tvContactUs, 7);
        sViewsWithIds.put(R.id.etUserName, 8);
        sViewsWithIds.put(R.id.etPassword, 9);
        sViewsWithIds.put(R.id.btnLogin, 10);
        sViewsWithIds.put(R.id.circularLoader, 11);
        sViewsWithIds.put(R.id.tvApiError, 12);
        sViewsWithIds.put(R.id.clLoadUserData, 13);
        sViewsWithIds.put(R.id.loader, 14);
        sViewsWithIds.put(R.id.tvProgress, 15);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (bindings[1] != null) ? breon.telematics.loneworkersafetyapp.android.databinding.AppToolbarBinding.bind((android.view.View) bindings[1]) : null
            , (androidx.appcompat.widget.AppCompatButton) bindings[10]
            , (com.google.android.material.progressindicator.CircularProgressIndicator) bindings[11]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[13]
            , (com.google.android.material.textfield.TextInputLayout) bindings[9]
            , (com.google.android.material.textfield.TextInputLayout) bindings[8]
            , (androidx.constraintlayout.widget.Guideline) bindings[3]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[4]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[5]
            , (com.google.android.material.progressindicator.CircularProgressIndicator) bindings[14]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (androidx.core.widget.NestedScrollView) bindings[2]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[15]
            );
        this.main.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}