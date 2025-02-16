package breon.telematics.loneworkersafetyapp.android;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import breon.telematics.loneworkersafetyapp.android.databinding.ActivityMainBindingImpl;
import breon.telematics.loneworkersafetyapp.android.databinding.ActivityMyDashboardBindingImpl;
import breon.telematics.loneworkersafetyapp.android.databinding.ActivityUserPermissionBindingImpl;
import breon.telematics.loneworkersafetyapp.android.databinding.FragmentCheckInBindingImpl;
import breon.telematics.loneworkersafetyapp.android.databinding.FragmentSettingsBindingImpl;
import breon.telematics.loneworkersafetyapp.android.databinding.FragmentSignOnManagementBindingImpl;
import breon.telematics.loneworkersafetyapp.android.databinding.OffDutyLayoutBindingImpl;
import breon.telematics.loneworkersafetyapp.android.databinding.UnavailabilityLayoutBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_ACTIVITYMYDASHBOARD = 2;

  private static final int LAYOUT_ACTIVITYUSERPERMISSION = 3;

  private static final int LAYOUT_FRAGMENTCHECKIN = 4;

  private static final int LAYOUT_FRAGMENTSETTINGS = 5;

  private static final int LAYOUT_FRAGMENTSIGNONMANAGEMENT = 6;

  private static final int LAYOUT_OFFDUTYLAYOUT = 7;

  private static final int LAYOUT_UNAVAILABILITYLAYOUT = 8;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(8);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(breon.telematics.loneworkersafetyapp.android.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(breon.telematics.loneworkersafetyapp.android.R.layout.activity_my_dashboard, LAYOUT_ACTIVITYMYDASHBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(breon.telematics.loneworkersafetyapp.android.R.layout.activity_user_permission, LAYOUT_ACTIVITYUSERPERMISSION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(breon.telematics.loneworkersafetyapp.android.R.layout.fragment_check_in, LAYOUT_FRAGMENTCHECKIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(breon.telematics.loneworkersafetyapp.android.R.layout.fragment_settings, LAYOUT_FRAGMENTSETTINGS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(breon.telematics.loneworkersafetyapp.android.R.layout.fragment_sign_on_management, LAYOUT_FRAGMENTSIGNONMANAGEMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(breon.telematics.loneworkersafetyapp.android.R.layout.off_duty_layout, LAYOUT_OFFDUTYLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(breon.telematics.loneworkersafetyapp.android.R.layout.unavailability_layout, LAYOUT_UNAVAILABILITYLAYOUT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMYDASHBOARD: {
          if ("layout/activity_my_dashboard_0".equals(tag)) {
            return new ActivityMyDashboardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_my_dashboard is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYUSERPERMISSION: {
          if ("layout/activity_user_permission_0".equals(tag)) {
            return new ActivityUserPermissionBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_user_permission is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCHECKIN: {
          if ("layout/fragment_check_in_0".equals(tag)) {
            return new FragmentCheckInBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_check_in is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSETTINGS: {
          if ("layout/fragment_settings_0".equals(tag)) {
            return new FragmentSettingsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_settings is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSIGNONMANAGEMENT: {
          if ("layout/fragment_sign_on_management_0".equals(tag)) {
            return new FragmentSignOnManagementBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_sign_on_management is invalid. Received: " + tag);
        }
        case  LAYOUT_OFFDUTYLAYOUT: {
          if ("layout/off_duty_layout_0".equals(tag)) {
            return new OffDutyLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for off_duty_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_UNAVAILABILITYLAYOUT: {
          if ("layout/unavailability_layout_0".equals(tag)) {
            return new UnavailabilityLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for unavailability_layout is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(8);

    static {
      sKeys.put("layout/activity_main_0", breon.telematics.loneworkersafetyapp.android.R.layout.activity_main);
      sKeys.put("layout/activity_my_dashboard_0", breon.telematics.loneworkersafetyapp.android.R.layout.activity_my_dashboard);
      sKeys.put("layout/activity_user_permission_0", breon.telematics.loneworkersafetyapp.android.R.layout.activity_user_permission);
      sKeys.put("layout/fragment_check_in_0", breon.telematics.loneworkersafetyapp.android.R.layout.fragment_check_in);
      sKeys.put("layout/fragment_settings_0", breon.telematics.loneworkersafetyapp.android.R.layout.fragment_settings);
      sKeys.put("layout/fragment_sign_on_management_0", breon.telematics.loneworkersafetyapp.android.R.layout.fragment_sign_on_management);
      sKeys.put("layout/off_duty_layout_0", breon.telematics.loneworkersafetyapp.android.R.layout.off_duty_layout);
      sKeys.put("layout/unavailability_layout_0", breon.telematics.loneworkersafetyapp.android.R.layout.unavailability_layout);
    }
  }
}
