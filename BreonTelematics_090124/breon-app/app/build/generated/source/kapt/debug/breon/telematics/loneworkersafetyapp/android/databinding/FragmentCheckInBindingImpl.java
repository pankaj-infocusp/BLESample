package breon.telematics.loneworkersafetyapp.android.databinding;
import breon.telematics.loneworkersafetyapp.android.R;
import breon.telematics.loneworkersafetyapp.android.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentCheckInBindingImpl extends FragmentCheckInBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(16);
        sIncludes.setIncludes(0, 
            new String[] {"unavailability_layout", "off_duty_layout"},
            new int[] {1, 2},
            new int[] {breon.telematics.loneworkersafetyapp.android.R.layout.unavailability_layout,
                breon.telematics.loneworkersafetyapp.android.R.layout.off_duty_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.checkinContent, 3);
        sViewsWithIds.put(R.id.clSignOn, 4);
        sViewsWithIds.put(R.id.ivNext, 5);
        sViewsWithIds.put(R.id.tvText, 6);
        sViewsWithIds.put(R.id.tvAssetName, 7);
        sViewsWithIds.put(R.id.etEditText, 8);
        sViewsWithIds.put(R.id.etMain, 9);
        sViewsWithIds.put(R.id.clTimerContainer, 10);
        sViewsWithIds.put(R.id.ivTimer, 11);
        sViewsWithIds.put(R.id.tvTimer, 12);
        sViewsWithIds.put(R.id.tvSecond, 13);
        sViewsWithIds.put(R.id.btnCheckIn, 14);
        sViewsWithIds.put(R.id.circularLoader, 15);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentCheckInBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private FragmentCheckInBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (androidx.appcompat.widget.AppCompatButton) bindings[14]
            , (breon.telematics.loneworkersafetyapp.android.databinding.UnavailabilityLayoutBinding) bindings[1]
            , (androidx.core.widget.NestedScrollView) bindings[3]
            , (com.google.android.material.progressindicator.CircularProgressIndicator) bindings[15]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[4]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[10]
            , (com.google.android.material.textfield.TextInputLayout) bindings[8]
            , (com.google.android.material.textfield.TextInputEditText) bindings[9]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[11]
            , (breon.telematics.loneworkersafetyapp.android.databinding.OffDutyLayoutBinding) bindings[2]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[12]
            );
        setContainedBinding(this.checkInDisableLayout);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setContainedBinding(this.offDutyLayout);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        checkInDisableLayout.invalidateAll();
        offDutyLayout.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (checkInDisableLayout.hasPendingBindings()) {
            return true;
        }
        if (offDutyLayout.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        checkInDisableLayout.setLifecycleOwner(lifecycleOwner);
        offDutyLayout.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeOffDutyLayout((breon.telematics.loneworkersafetyapp.android.databinding.OffDutyLayoutBinding) object, fieldId);
            case 1 :
                return onChangeCheckInDisableLayout((breon.telematics.loneworkersafetyapp.android.databinding.UnavailabilityLayoutBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeOffDutyLayout(breon.telematics.loneworkersafetyapp.android.databinding.OffDutyLayoutBinding OffDutyLayout, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeCheckInDisableLayout(breon.telematics.loneworkersafetyapp.android.databinding.UnavailabilityLayoutBinding CheckInDisableLayout, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
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
        executeBindingsOn(checkInDisableLayout);
        executeBindingsOn(offDutyLayout);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): offDutyLayout
        flag 1 (0x2L): checkInDisableLayout
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}