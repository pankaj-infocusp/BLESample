// Generated by data binding compiler. Do not edit!
package breon.telematics.loneworkersafetyapp.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import breon.telematics.loneworkersafetyapp.android.R;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSignOnManagementBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatButton btnSignOn;

  @NonNull
  public final CircularProgressIndicator circularLoader;

  @NonNull
  public final TextInputLayout etContactName;

  @NonNull
  public final TextInputLayout etContactPhone;

  @NonNull
  public final TextInputEditText etGetContactName;

  @NonNull
  public final TextInputEditText etGetContactPhone;

  @NonNull
  public final Guideline guideline;

  @NonNull
  public final AppCompatImageView ivLocationIcon;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final TextView tvApiError;

  @NonNull
  public final TextView tvAssetName;

  @NonNull
  public final TextView tvDescription;

  protected FragmentSignOnManagementBinding(Object _bindingComponent, View _root,
      int _localFieldCount, AppCompatButton btnSignOn, CircularProgressIndicator circularLoader,
      TextInputLayout etContactName, TextInputLayout etContactPhone,
      TextInputEditText etGetContactName, TextInputEditText etGetContactPhone, Guideline guideline,
      AppCompatImageView ivLocationIcon, ConstraintLayout main, TextView tvApiError,
      TextView tvAssetName, TextView tvDescription) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSignOn = btnSignOn;
    this.circularLoader = circularLoader;
    this.etContactName = etContactName;
    this.etContactPhone = etContactPhone;
    this.etGetContactName = etGetContactName;
    this.etGetContactPhone = etGetContactPhone;
    this.guideline = guideline;
    this.ivLocationIcon = ivLocationIcon;
    this.main = main;
    this.tvApiError = tvApiError;
    this.tvAssetName = tvAssetName;
    this.tvDescription = tvDescription;
  }

  @NonNull
  public static FragmentSignOnManagementBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_sign_on_management, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSignOnManagementBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSignOnManagementBinding>inflateInternal(inflater, R.layout.fragment_sign_on_management, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSignOnManagementBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_sign_on_management, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSignOnManagementBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSignOnManagementBinding>inflateInternal(inflater, R.layout.fragment_sign_on_management, null, false, component);
  }

  public static FragmentSignOnManagementBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentSignOnManagementBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentSignOnManagementBinding)bind(component, view, R.layout.fragment_sign_on_management);
  }
}
