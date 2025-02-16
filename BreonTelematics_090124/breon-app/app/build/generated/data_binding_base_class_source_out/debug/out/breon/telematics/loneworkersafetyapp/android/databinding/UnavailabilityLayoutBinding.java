// Generated by data binding compiler. Do not edit!
package breon.telematics.loneworkersafetyapp.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import breon.telematics.loneworkersafetyapp.android.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class UnavailabilityLayoutBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatImageView ivDisableIcon;

  @NonNull
  public final TextView tvDescription;

  @NonNull
  public final TextView tvUnAvailable;

  @NonNull
  public final ConstraintLayout unavailableContent;

  protected UnavailabilityLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatImageView ivDisableIcon, TextView tvDescription, TextView tvUnAvailable,
      ConstraintLayout unavailableContent) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivDisableIcon = ivDisableIcon;
    this.tvDescription = tvDescription;
    this.tvUnAvailable = tvUnAvailable;
    this.unavailableContent = unavailableContent;
  }

  @NonNull
  public static UnavailabilityLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.unavailability_layout, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static UnavailabilityLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<UnavailabilityLayoutBinding>inflateInternal(inflater, R.layout.unavailability_layout, root, attachToRoot, component);
  }

  @NonNull
  public static UnavailabilityLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.unavailability_layout, null, false, component)
   */
  @NonNull
  @Deprecated
  public static UnavailabilityLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<UnavailabilityLayoutBinding>inflateInternal(inflater, R.layout.unavailability_layout, null, false, component);
  }

  public static UnavailabilityLayoutBinding bind(@NonNull View view) {
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
  public static UnavailabilityLayoutBinding bind(@NonNull View view, @Nullable Object component) {
    return (UnavailabilityLayoutBinding)bind(component, view, R.layout.unavailability_layout);
  }
}
