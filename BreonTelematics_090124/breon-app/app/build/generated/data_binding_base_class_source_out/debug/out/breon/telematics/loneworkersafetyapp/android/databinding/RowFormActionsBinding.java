// Generated by view binder compiler. Do not edit!
package breon.telematics.loneworkersafetyapp.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.viewbinding.ViewBinding;
import breon.telematics.loneworkersafetyapp.android.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class RowFormActionsBinding implements ViewBinding {
  @NonNull
  private final AppCompatCheckBox rootView;

  @NonNull
  public final AppCompatCheckBox cbAction;

  private RowFormActionsBinding(@NonNull AppCompatCheckBox rootView,
      @NonNull AppCompatCheckBox cbAction) {
    this.rootView = rootView;
    this.cbAction = cbAction;
  }

  @Override
  @NonNull
  public AppCompatCheckBox getRoot() {
    return rootView;
  }

  @NonNull
  public static RowFormActionsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RowFormActionsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.row_form_actions, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RowFormActionsBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    AppCompatCheckBox cbAction = (AppCompatCheckBox) rootView;

    return new RowFormActionsBinding((AppCompatCheckBox) rootView, cbAction);
  }
}
