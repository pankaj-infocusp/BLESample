package breon.telematics.loneworkersafetyapp.android.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u001a\u0006\u0010\b\u001a\u00020\u0002\u001a\u0006\u0010\t\u001a\u00020\u0002\u001a\u0016\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f\u001a\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014\u001a\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u0016*\u00020\u0018\u001a\u001c\u0010\u001a\u001a\u00020\u001b*\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u001e\"\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u001f"}, d2 = {"permissions", "", "", "getPermissions", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getCurrentDateTimeInUTCFormat", "format", "getCurrentUtcDate", "getCurrentUtcTime", "getDueTimeInUTCFormat", "minutes", "", "getErrorMessage", "entity", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorEntity;", "getZonedDateTimeFromDate", "Ljava/time/ZonedDateTime;", "date", "dateFormatter", "Ljava/time/format/DateTimeFormatter;", "isNetworkAvailable", "", "context", "Landroid/content/Context;", "isLocationPermissionGranted", "showToast", "", "message", "length", "", "app_debug"})
public final class AppExtenstionsKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String[] permissions = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String[] getPermissions() {
        return null;
    }
    
    public static final void showToast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$showToast, @org.jetbrains.annotations.NotNull()
    java.lang.String message, int length) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getCurrentDateTimeInUTCFormat(@org.jetbrains.annotations.NotNull()
    java.lang.String format) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getCurrentUtcDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getCurrentUtcTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getDueTimeInUTCFormat(@org.jetbrains.annotations.NotNull()
    java.lang.String format, long minutes) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.time.ZonedDateTime getZonedDateTimeFromDate(@org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.time.format.DateTimeFormatter dateFormatter) {
        return null;
    }
    
    public static final boolean isLocationPermissionGranted(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$isLocationPermissionGranted) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getErrorMessage(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity entity) {
        return null;
    }
    
    public static final boolean isNetworkAvailable(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
}