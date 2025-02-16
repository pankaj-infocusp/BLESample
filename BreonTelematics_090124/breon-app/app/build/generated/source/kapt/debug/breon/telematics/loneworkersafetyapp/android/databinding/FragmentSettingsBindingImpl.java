package breon.telematics.loneworkersafetyapp.android.databinding;
import breon.telematics.loneworkersafetyapp.android.R;
import breon.telematics.loneworkersafetyapp.android.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSettingsBindingImpl extends FragmentSettingsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(38);
        sIncludes.setIncludes(0, 
            new String[] {"unavailability_layout"},
            new int[] {1},
            new int[] {breon.telematics.loneworkersafetyapp.android.R.layout.unavailability_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.settingsContent, 2);
        sViewsWithIds.put(R.id.etContactName, 3);
        sViewsWithIds.put(R.id.etGetContactName, 4);
        sViewsWithIds.put(R.id.etContactPhone, 5);
        sViewsWithIds.put(R.id.etGetContactPhone, 6);
        sViewsWithIds.put(R.id.etSelectSafetyTemplate, 7);
        sViewsWithIds.put(R.id.etGetSelectSafetyTemplate, 8);
        sViewsWithIds.put(R.id.tvLocationTracking, 9);
        sViewsWithIds.put(R.id.seekbar, 10);
        sViewsWithIds.put(R.id.btnMinus, 11);
        sViewsWithIds.put(R.id.btnPlus, 12);
        sViewsWithIds.put(R.id.etSafetyTimer, 13);
        sViewsWithIds.put(R.id.etGetSafetyTimer, 14);
        sViewsWithIds.put(R.id.etSignOffTime, 15);
        sViewsWithIds.put(R.id.etGetSignOffTime, 16);
        sViewsWithIds.put(R.id.btnSave, 17);
        sViewsWithIds.put(R.id.btnLogOff, 18);
        sViewsWithIds.put(R.id.circularLoader, 19);
        sViewsWithIds.put(R.id.tv_template_name, 20);
        sViewsWithIds.put(R.id.tv_template_name_value, 21);
        sViewsWithIds.put(R.id.tv_group_name, 22);
        sViewsWithIds.put(R.id.tv_group_name_value, 23);
        sViewsWithIds.put(R.id.tv_org_name, 24);
        sViewsWithIds.put(R.id.tv_org_name_value, 25);
        sViewsWithIds.put(R.id.tv_l2_name_contact, 26);
        sViewsWithIds.put(R.id.tv_l2_name_contact_value, 27);
        sViewsWithIds.put(R.id.tv_l3_name_contact, 28);
        sViewsWithIds.put(R.id.tv_l3_name_contact_value, 29);
        sViewsWithIds.put(R.id.tv_l4_name_contact, 30);
        sViewsWithIds.put(R.id.tv_l4_name_contact_value, 31);
        sViewsWithIds.put(R.id.tv_note, 32);
        sViewsWithIds.put(R.id.tv_note_value, 33);
        sViewsWithIds.put(R.id.tv_checkin_duration, 34);
        sViewsWithIds.put(R.id.tv_checkin_duration_value, 35);
        sViewsWithIds.put(R.id.tv_shift_duration, 36);
        sViewsWithIds.put(R.id.tv_shift_duration_value, 37);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSettingsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 38, sIncludes, sViewsWithIds));
    }
    private FragmentSettingsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.appcompat.widget.AppCompatButton) bindings[18]
            , (com.google.android.material.button.MaterialButton) bindings[11]
            , (com.google.android.material.button.MaterialButton) bindings[12]
            , (androidx.appcompat.widget.AppCompatButton) bindings[17]
            , (com.google.android.material.progressindicator.CircularProgressIndicator) bindings[19]
            , (breon.telematics.loneworkersafetyapp.android.databinding.UnavailabilityLayoutBinding) bindings[1]
            , (com.google.android.material.textfield.TextInputLayout) bindings[3]
            , (com.google.android.material.textfield.TextInputLayout) bindings[5]
            , (com.google.android.material.textfield.TextInputEditText) bindings[4]
            , (com.google.android.material.textfield.TextInputEditText) bindings[6]
            , (com.google.android.material.textfield.TextInputEditText) bindings[14]
            , (android.widget.Spinner) bindings[8]
            , (com.google.android.material.textfield.TextInputEditText) bindings[16]
            , (com.google.android.material.textfield.TextInputLayout) bindings[13]
            , (com.google.android.material.textfield.TextInputLayout) bindings[7]
            , (com.google.android.material.textfield.TextInputLayout) bindings[15]
            , (android.widget.SeekBar) bindings[10]
            , (androidx.core.widget.NestedScrollView) bindings[2]
            , (android.widget.TextView) bindings[34]
            , (android.widget.TextView) bindings[35]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[27]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[30]
            , (android.widget.TextView) bindings[31]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[32]
            , (android.widget.TextView) bindings[33]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[36]
            , (android.widget.TextView) bindings[37]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[21]
            );
        setContainedBinding(this.disableLayout);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        disableLayout.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (disableLayout.hasPendingBindings()) {
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
        disableLayout.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeDisableLayout((breon.telematics.loneworkersafetyapp.android.databinding.UnavailabilityLayoutBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeDisableLayout(breon.telematics.loneworkersafetyapp.android.databinding.UnavailabilityLayoutBinding DisableLayout, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
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
        executeBindingsOn(disableLayout);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): disableLayout
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}