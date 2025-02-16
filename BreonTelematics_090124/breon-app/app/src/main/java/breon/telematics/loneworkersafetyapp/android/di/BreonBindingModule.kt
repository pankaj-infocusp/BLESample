package breon.telematics.loneworkersafetyapp.android.di

import breon.telematics.loneworkersafetyapp.android.data.error_handler.GeneralErrorHandlerImpl
import breon.telematics.loneworkersafetyapp.android.data.repository.BreonRepositoryImpl
import breon.telematics.loneworkersafetyapp.android.data.source.remote.BreonDataSource
import breon.telematics.loneworkersafetyapp.android.data.source.remote.BreonDataSourceImpl
import breon.telematics.loneworkersafetyapp.android.domain.error.ErrorHandler
import breon.telematics.loneworkersafetyapp.android.domain.repository.BreonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class BreonBindingModule {

    @Binds
    abstract fun bindBreonDataSource(
        breonDataSourceImpl: BreonDataSourceImpl
    ): BreonDataSource

    @Binds
    abstract fun bindBreonRepository(
        breonRepositoryImpl: BreonRepositoryImpl
    ): BreonRepository

    @Binds
    abstract fun bindGeneralErrorHandler(
        errorHandlerImpl: GeneralErrorHandlerImpl
    ): ErrorHandler
}