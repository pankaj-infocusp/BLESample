package breon.telematics.loneworkersafetyapp.android.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\'\u00a8\u0006\u000f"}, d2 = {"Lbreon/telematics/loneworkersafetyapp/android/di/BreonBindingModule;", "", "()V", "bindBreonDataSource", "Lbreon/telematics/loneworkersafetyapp/android/data/source/remote/BreonDataSource;", "breonDataSourceImpl", "Lbreon/telematics/loneworkersafetyapp/android/data/source/remote/BreonDataSourceImpl;", "bindBreonRepository", "Lbreon/telematics/loneworkersafetyapp/android/domain/repository/BreonRepository;", "breonRepositoryImpl", "Lbreon/telematics/loneworkersafetyapp/android/data/repository/BreonRepositoryImpl;", "bindGeneralErrorHandler", "Lbreon/telematics/loneworkersafetyapp/android/domain/error/ErrorHandler;", "errorHandlerImpl", "Lbreon/telematics/loneworkersafetyapp/android/data/error_handler/GeneralErrorHandlerImpl;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ViewModelComponent.class})
public abstract class BreonBindingModule {
    
    public BreonBindingModule() {
        super();
    }
    
    @dagger.Binds()
    @org.jetbrains.annotations.NotNull()
    public abstract breon.telematics.loneworkersafetyapp.android.data.source.remote.BreonDataSource bindBreonDataSource(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.data.source.remote.BreonDataSourceImpl breonDataSourceImpl);
    
    @dagger.Binds()
    @org.jetbrains.annotations.NotNull()
    public abstract breon.telematics.loneworkersafetyapp.android.domain.repository.BreonRepository bindBreonRepository(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.data.repository.BreonRepositoryImpl breonRepositoryImpl);
    
    @dagger.Binds()
    @org.jetbrains.annotations.NotNull()
    public abstract breon.telematics.loneworkersafetyapp.android.domain.error.ErrorHandler bindGeneralErrorHandler(@org.jetbrains.annotations.NotNull()
    breon.telematics.loneworkersafetyapp.android.data.error_handler.GeneralErrorHandlerImpl errorHandlerImpl);
}