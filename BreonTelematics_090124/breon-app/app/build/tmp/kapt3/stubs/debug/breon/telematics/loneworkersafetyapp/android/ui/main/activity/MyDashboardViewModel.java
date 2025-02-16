package breon.telematics.loneworkersafetyapp.android.ui.main.activity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/ui/main/activity/MyDashboardViewModel;", "Lbreon/telematics/loneworkersafetyapp/android/app/base/BaseViewModel;", "assetDetailsUseCase", "Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/AssetDetailsUseCase;", "(Lbreon/telematics/loneworkersafetyapp/android/domain/usecases/AssetDetailsUseCase;)V", "_assetsDetails", "Landroidx/lifecycle/MutableLiveData;", "Lbreon/telematics/loneworkersafetyapp/android/domain/model/response/AssetDetails;", "assetDetails", "Landroidx/lifecycle/LiveData;", "getAssetDetails", "()Landroidx/lifecycle/LiveData;", "", "assetId", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MyDashboardViewModel extends breon.telematics.loneworkersafetyapp.android.app.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase assetDetailsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails> _assetsDetails = null;
    
    @javax.inject.Inject()
    public MyDashboardViewModel(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.domain.usecases.AssetDetailsUseCase assetDetailsUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<breon.telematics.loneworkersafetyapp.android.domain.model.response.AssetDetails> getAssetDetails() {
        return null;
    }
    
    public final void getAssetDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String assetId) {
    }
}