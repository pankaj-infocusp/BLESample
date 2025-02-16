package breon.telematics.loneworkersafetyapp.android.ui.main.callback;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0007"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/ui/main/callback/OnAssetDetailFetchListener;", "", "onAssetDetailsFetched", "", "assetDetails", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/AssetDetails;", "updateTimer", "app_debug"})
public abstract interface OnAssetDetailFetchListener {
    
    public abstract void onAssetDetailsFetched(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails assetDetails);
    
    public abstract void updateTimer(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails assetDetails);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        public static void updateTimer(@org.jetbrains.annotations.NotNull()
        breon.telematics.loneworkersafetyapp.android.ui.main.callback.OnAssetDetailFetchListener $this, @org.jetbrains.annotations.NotNull()
        breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails assetDetails) {
        }
    }
}