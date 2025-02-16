package breon.telematics.loneworkersafetyapp.android.domain.error

import breon.telematics.loneworkersafetyapp.android.data.error_handler.GeneralErrorHandlerImpl


sealed class ErrorEntity {
    object Network : ErrorEntity()

    object NotFound : ErrorEntity()

    object AccessDenied : ErrorEntity()

    object ServiceUnavailable : ErrorEntity()

    object Authentication : ErrorEntity()

    object ServerError : ErrorEntity()

    data class BadRequest(val errorResponse: GeneralErrorHandlerImpl.ErrorResponse) : ErrorEntity()

    object Unknown : ErrorEntity()
}