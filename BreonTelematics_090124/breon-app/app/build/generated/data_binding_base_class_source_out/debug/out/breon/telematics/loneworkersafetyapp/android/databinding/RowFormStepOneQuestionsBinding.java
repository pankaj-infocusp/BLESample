// Generated by view binder compiler. Do not edit!
package breon.telematics.loneworkersafetyapp.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import breon.telematics.loneworkersafetyapp.android.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class RowFormStepOneQuestionsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AppCompatCheckBox checkBoxNo;

  @NonNull
  public final AppCompatCheckBox checkBoxYes;

  @NonNull
  public final TextView tvQuestion;

  private RowFormStepOneQuestionsBinding(@NonNull LinearLayout rootView,
      @NonNull AppCompatCheckBox checkBoxNo, @NonNull AppCompatCheckBox checkBoxYes,
      @NonNull TextView tvQuestion) {
    this.rootView = rootView;
    this.checkBoxNo = checkBoxNo;
    this.checkBoxYes = checkBoxYes;
    this.tvQuestion = tvQuestion;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RowFormStepOneQuestionsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RowFormStepOneQuestionsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.row_form_step_one_questions, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RowFormStepOneQuestionsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.checkBoxNo;
      AppCompatCheckBox checkBoxNo = ViewBindings.findChildViewById(rootView, id);
      if (checkBoxNo == null) {
        break missingId;
      }

      id = R.id.checkBoxYes;
      AppCompatCheckBox checkBoxYes = ViewBindings.findChildViewById(rootView, id);
      if (checkBoxYes == null) {
        break missingId;
      }

      id = R.id.tvQuestion;
      TextView tvQuestion = ViewBindings.findChildViewById(rootView, id);
      if (tvQuestion == null) {
        break missingId;
      }

      return new RowFormStepOneQuestionsBinding((LinearLayout) rootView, checkBoxNo, checkBoxYes,
          tvQuestion);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
