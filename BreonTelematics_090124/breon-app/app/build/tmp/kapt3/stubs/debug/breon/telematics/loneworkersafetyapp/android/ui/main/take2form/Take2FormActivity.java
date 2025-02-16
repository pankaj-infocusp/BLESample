package breon.telematics.loneworkersafetyapp.android.ui.main.take2form;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020 H\u0002J \u0010$\u001a\u00020%2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`&H\u0002J\b\u0010\'\u001a\u00020 H\u0002J\b\u0010(\u001a\u00020 H\u0002J\b\u0010)\u001a\u00020 H\u0002J\b\u0010*\u001a\u00020 H\u0002J\u0012\u0010+\u001a\u00020 2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020 H\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u00100\u001a\u000201H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\u00a8\u00062"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/ui/main/take2form/Take2FormActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lbreon/telematics/loneworkersafetyapp/android/databinding/ActivityTake2FormBinding;", "pref", "Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "getPref", "()Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;", "setPref", "(Lbreon/telematics/loneworkersafetyapp/android/utils/PrefManager;)V", "questionsModels", "Ljava/util/ArrayList;", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/Take2FormStep1QuestionsModel;", "step3Decision", "", "stepTwoQuestionsModels", "swmsFormValues", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/SWMSFormValues;", "swmsValuesAdapter", "Lbreon/telematics/loneworkersafetyapp/android/ui/main/take2form/Take2FormSwmsOptionsAdapter;", "take2FormActionsModels", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/Take2FormActionsModel;", "taskActionsAdapter", "Lbreon/telematics/loneworkersafetyapp/android/ui/main/take2form/Take2FormActionsAdapter;", "viewModel", "Lbreon/telematics/loneworkersafetyapp/android/ui/main/take2form/Take2FormModelViewModel;", "getViewModel", "()Lbreon/telematics/loneworkersafetyapp/android/ui/main/take2form/Take2FormModelViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addActions", "", "addStepOneQuestions", "addStepTwoQuestions", "addSwms", "getStepsAnswer", "Lorg/json/JSONObject;", "Lkotlin/collections/ArrayList;", "initFormData", "listeners", "observeLiveData", "observeState", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "openDatePickerDialog", "setTaskCompletedDate", "calendar", "Ljava/util/Calendar;", "app_debug"})
public final class Take2FormActivity extends androidx.appcompat.app.AppCompatActivity {
    private breon.telematics.loneworkersafetyapp.android.databinding.ActivityTake2FormBinding binding;
    private breon.telematics.loneworkersafetyapp.android.ui.main.take2form.Take2FormSwmsOptionsAdapter swmsValuesAdapter;
    private breon.telematics.loneworkersafetyapp.android.ui.main.take2form.Take2FormActionsAdapter taskActionsAdapter;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String step3Decision = "NO";
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormStep1QuestionsModel> questionsModels = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormStep1QuestionsModel> stepTwoQuestionsModels = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormActionsModel> take2FormActionsModels = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<breon.telematics.loneworkersafetyapp.android.domain.model.request.SWMSFormValues> swmsFormValues = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @javax.inject.Inject()
    public breon.telematics.loneworkersafetyapp.android.utils.PrefManager pref;
    
    public Take2FormActivity() {
        super();
    }
    
    private final breon.telematics.loneworkersafetyapp.android.ui.main.take2form.Take2FormModelViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.utils.PrefManager getPref() {
        return null;
    }
    
    public final void setPref(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.utils.PrefManager p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void observeLiveData() {
    }
    
    private final void observeState() {
    }
    
    private final void initFormData() {
    }
    
    private final void addSwms() {
    }
    
    private final void setTaskCompletedDate(java.util.Calendar calendar) {
    }
    
    private final void addStepOneQuestions() {
    }
    
    private final void addStepTwoQuestions() {
    }
    
    private final void addActions() {
    }
    
    private final org.json.JSONObject getStepsAnswer(java.util.ArrayList<breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormStep1QuestionsModel> questionsModels) {
        return null;
    }
    
    private final void listeners() {
    }
    
    private final void openDatePickerDialog() {
    }
}