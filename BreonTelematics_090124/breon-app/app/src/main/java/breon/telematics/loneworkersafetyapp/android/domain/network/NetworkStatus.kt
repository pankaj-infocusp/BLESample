package breon.telematics.loneworkersafetyapp.android.domain.network

import kotlinx.coroutines.flow.Flow

interface NetworkStatus {
    fun observe(): Flow<Status>

    enum class Status {
        Available, Lost, Losing, Unavailable
    }
}