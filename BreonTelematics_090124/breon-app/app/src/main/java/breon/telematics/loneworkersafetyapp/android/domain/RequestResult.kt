package breon.telematics.loneworkersafetyapp.android.domain

import breon.telematics.loneworkersafetyapp.android.domain.error.ErrorEntity


sealed class RequestResult<out T> {
    data class Success<T>(val data: T): RequestResult<T>()
    data class ErrorResult(val entity: ErrorEntity): RequestResult<Nothing>()
    data class Error(val message: String): RequestResult<Nothing>()
}