package breon.telematics.loneworkersafetyapp.android.di

import android.content.Context
import breon.telematics.loneworkersafetyapp.android.BuildConfig
import breon.telematics.loneworkersafetyapp.android.data.services.BreonService
import breon.telematics.loneworkersafetyapp.android.data.source.intercepter.AuthInterceptor
import breon.telematics.loneworkersafetyapp.android.domain.network.NetworkConnectivity
import com.google.firebase.installations.FirebaseInstallations
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
	@Singleton
	@Provides
	fun provideNetworkConnectivity(
		@ApplicationContext context: Context
	) = NetworkConnectivity(context)

	@Singleton
	@Provides
	@Named("FirebaseInstallationId")
	fun provideFirebaseInstallationId(): String =
		runBlocking {
			FirebaseInstallations.getInstance().id.await().orEmpty()
		}

	@Singleton
	@Provides
	fun provideAuthInterceptor(
		@Named("FirebaseInstallationId") deviceId: String
	): AuthInterceptor {
		return AuthInterceptor(deviceId)
	}

	@Singleton
	@Provides
	fun provideHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
		val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
		return OkHttpClient.Builder()
			.callTimeout(180, TimeUnit.SECONDS)
			.readTimeout(180, TimeUnit.SECONDS)
			.addInterceptor(authInterceptor)
			.addInterceptor(interceptor)
			.build()
	}

	@Singleton
	@Provides
	fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
		return Retrofit.Builder()
			.addConverterFactory(ScalarsConverterFactory.create())
			.addConverterFactory(GsonConverterFactory.create())
			.baseUrl(BuildConfig.BASE_URL)
			.client(okHttpClient)
			.build()
	}

	@Singleton
	@Provides
	fun provideBreonService(retrofit: Retrofit): BreonService {
		return retrofit.create(BreonService::class.java)
	}

	@Singleton
	@Provides
	@Named("dev_environment")
	fun provideDevRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
		return Retrofit.Builder()
			.addConverterFactory(ScalarsConverterFactory.create())
			.addConverterFactory(GsonConverterFactory.create())
			.baseUrl(BuildConfig.BASE_URL_DEV)
			.client(okHttpClient)
			.build()
	}

	@Singleton
	@Provides
	@Named("dev_environment")
	fun provideDevBreonService(@Named("dev_environment") retrofit: Retrofit): BreonService {
		return retrofit.create(BreonService::class.java)
	}

}