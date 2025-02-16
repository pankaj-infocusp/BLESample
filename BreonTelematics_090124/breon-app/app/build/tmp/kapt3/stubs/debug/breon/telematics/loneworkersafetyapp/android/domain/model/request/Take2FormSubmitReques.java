package breon.telematics.loneworkersafetyapp.android.domain.model.request;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u0003?@AB\u0095\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\r\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0016J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u000fH\u00c6\u0003J\t\u0010,\u001a\u00020\u0011H\u00c6\u0003J\t\u0010-\u001a\u00020\u0013H\u00c6\u0003J\u0019\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\rH\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\u0019\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\rH\u00c6\u0003J\u00b5\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\r2\b\b\u0002\u0010\u0015\u001a\u00020\u0003H\u00c6\u0001J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010<\u001a\u00020=H\u00d6\u0001J\t\u0010>\u001a\u00020\u0003H\u00d6\u0001R!\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\r\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018\u00a8\u0006B"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/Take2FormSubmitReques;", "", "asset_id", "", "deviceID", "apikey", "activity_summary", "completed_by", "participants", "site", "date", "swms_reviewed", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "step1_responses", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/Take2FormSubmitReques$StepOneRequest;", "step2_responses", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/Take2FormSubmitReques$StepTwoRequest;", "step3_decision", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/Take2FormSubmitReques$StepThreeRequest;", "action", "remarks", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/Take2FormSubmitReques$StepOneRequest;Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/Take2FormSubmitReques$StepTwoRequest;Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/Take2FormSubmitReques$StepThreeRequest;Ljava/util/ArrayList;Ljava/lang/String;)V", "getAction", "()Ljava/util/ArrayList;", "getActivity_summary", "()Ljava/lang/String;", "getApikey", "getAsset_id", "getCompleted_by", "getDate", "getDeviceID", "getParticipants", "getRemarks", "getSite", "getStep1_responses", "()Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/Take2FormSubmitReques$StepOneRequest;", "getStep2_responses", "()Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/Take2FormSubmitReques$StepTwoRequest;", "getStep3_decision", "()Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/Take2FormSubmitReques$StepThreeRequest;", "getSwms_reviewed", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "StepOneRequest", "StepThreeRequest", "StepTwoRequest", "app_debug"})
@androidx.annotation.Keep()
public final class Take2FormSubmitReques {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String asset_id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String deviceID = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String apikey = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String activity_summary = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String completed_by = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String participants = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String site = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String date = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<java.lang.String> swms_reviewed = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques.StepOneRequest step1_responses = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques.StepTwoRequest step2_responses = null;
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques.StepThreeRequest step3_decision = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<java.lang.String> action = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String remarks = null;
    
    public Take2FormSubmitReques(@org.jetbrains.annotations.NotNull()
    java.lang.String asset_id, @org.jetbrains.annotations.NotNull()
    java.lang.String deviceID, @org.jetbrains.annotations.NotNull()
    java.lang.String apikey, @org.jetbrains.annotations.NotNull()
    java.lang.String activity_summary, @org.jetbrains.annotations.NotNull()
    java.lang.String completed_by, @org.jetbrains.annotations.NotNull()
    java.lang.String participants, @org.jetbrains.annotations.NotNull()
    java.lang.String site, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> swms_reviewed, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques.StepOneRequest step1_responses, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques.StepTwoRequest step2_responses, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques.StepThreeRequest step3_decision, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> action, @org.jetbrains.annotations.NotNull()
    java.lang.String remarks) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAsset_id() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeviceID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getApikey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getActivity_summary() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompleted_by() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getParticipants() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSite() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getSwms_reviewed() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques.StepOneRequest getStep1_responses() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques.StepTwoRequest getStep2_responses() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques.StepThreeRequest getStep3_decision() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getAction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRemarks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques.StepOneRequest component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques.StepTwoRequest component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques.StepThreeRequest component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques copy(@org.jetbrains.annotations.NotNull()
    java.lang.String asset_id, @org.jetbrains.annotations.NotNull()
    java.lang.String deviceID, @org.jetbrains.annotations.NotNull()
    java.lang.String apikey, @org.jetbrains.annotations.NotNull()
    java.lang.String activity_summary, @org.jetbrains.annotations.NotNull()
    java.lang.String completed_by, @org.jetbrains.annotations.NotNull()
    java.lang.String participants, @org.jetbrains.annotations.NotNull()
    java.lang.String site, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> swms_reviewed, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques.StepOneRequest step1_responses, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques.StepTwoRequest step2_responses, @org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques.StepThreeRequest step3_decision, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> action, @org.jetbrains.annotations.NotNull()
    java.lang.String remarks) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/Take2FormSubmitReques$StepOneRequest;", "", "understand_risks", "", "know_injury", "access_knowledge_confidence", "mandatory_ppe", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccess_knowledge_confidence", "()Ljava/lang/String;", "getKnow_injury", "getMandatory_ppe", "getUnderstand_risks", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    @androidx.annotation.Keep()
    public static final class StepOneRequest {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String understand_risks = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String know_injury = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String access_knowledge_confidence = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String mandatory_ppe = null;
        
        public StepOneRequest(@org.jetbrains.annotations.NotNull()
        java.lang.String understand_risks, @org.jetbrains.annotations.NotNull()
        java.lang.String know_injury, @org.jetbrains.annotations.NotNull()
        java.lang.String access_knowledge_confidence, @org.jetbrains.annotations.NotNull()
        java.lang.String mandatory_ppe) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUnderstand_risks() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKnow_injury() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAccess_knowledge_confidence() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMandatory_ppe() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques.StepOneRequest copy(@org.jetbrains.annotations.NotNull()
        java.lang.String understand_risks, @org.jetbrains.annotations.NotNull()
        java.lang.String know_injury, @org.jetbrains.annotations.NotNull()
        java.lang.String access_knowledge_confidence, @org.jetbrains.annotations.NotNull()
        java.lang.String mandatory_ppe) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/Take2FormSubmitReques$StepThreeRequest;", "", "new_hazards_identified", "", "hazards_details", "safety_controls", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHazards_details", "()Ljava/lang/String;", "getNew_hazards_identified", "getSafety_controls", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    @androidx.annotation.Keep()
    public static final class StepThreeRequest {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String new_hazards_identified = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String hazards_details = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String safety_controls = null;
        
        public StepThreeRequest(@org.jetbrains.annotations.NotNull()
        java.lang.String new_hazards_identified, @org.jetbrains.annotations.NotNull()
        java.lang.String hazards_details, @org.jetbrains.annotations.NotNull()
        java.lang.String safety_controls) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getNew_hazards_identified() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getHazards_details() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSafety_controls() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques.StepThreeRequest copy(@org.jetbrains.annotations.NotNull()
        java.lang.String new_hazards_identified, @org.jetbrains.annotations.NotNull()
        java.lang.String hazards_details, @org.jetbrains.annotations.NotNull()
        java.lang.String safety_controls) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/domain/model/request/Take2FormSubmitReques$StepTwoRequest;", "", "unsure_circumstances", "", "checked_resources", "hazard_significance", "additional_controls", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdditional_controls", "()Ljava/lang/String;", "getChecked_resources", "getHazard_significance", "getUnsure_circumstances", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    @androidx.annotation.Keep()
    public static final class StepTwoRequest {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String unsure_circumstances = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String checked_resources = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String hazard_significance = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String additional_controls = null;
        
        public StepTwoRequest(@org.jetbrains.annotations.NotNull()
        java.lang.String unsure_circumstances, @org.jetbrains.annotations.NotNull()
        java.lang.String checked_resources, @org.jetbrains.annotations.NotNull()
        java.lang.String hazard_significance, @org.jetbrains.annotations.NotNull()
        java.lang.String additional_controls) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUnsure_circumstances() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getChecked_resources() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getHazard_significance() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAdditional_controls() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormSubmitReques.StepTwoRequest copy(@org.jetbrains.annotations.NotNull()
        java.lang.String unsure_circumstances, @org.jetbrains.annotations.NotNull()
        java.lang.String checked_resources, @org.jetbrains.annotations.NotNull()
        java.lang.String hazard_significance, @org.jetbrains.annotations.NotNull()
        java.lang.String additional_controls) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}