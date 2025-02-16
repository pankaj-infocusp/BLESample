package breon.telematics.loneworkersafetyapp.android.data.source.intercepter

import breon.telematics.loneworkersafetyapp.android.BuildConfig
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val deviceId: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        val newUrl = originalUrl.newBuilder()
            .addQueryParameter("deviceID", deviceId)
            .addQueryParameter("token", provideFirebaseToken())
            .addQueryParameter("apikey", BuildConfig.API_KEY)
            .build()

        val newRequest = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }

    companion object {
        private var token: String? = null
        private fun provideFirebaseToken(): String {
            return token ?: synchronized(this) {
                val firebaseToken = runBlocking {
                    FirebaseMessaging.getInstance().token.await().orEmpty()
                }
                token = firebaseToken
                firebaseToken
            }
        }
    }
}