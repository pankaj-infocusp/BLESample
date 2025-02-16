package breon.telematics.loneworkersafetyapp.android.domain.error

interface ErrorHandler {
    fun getError(throwable: Throwable?): ErrorEntity
}