package am.carbox.core.network.di

import am.carbox.core.io.preference.SensitivePreferencesService
import am.carbox.core.network.interceptor.HeaderAuthTokenInterceptor
import am.carbox.core.network.interceptor.HeaderDeviceInterceptor
import am.carbox.core.network.interceptor.HeaderPlatformInterceptor
import am.carbox.core.network.interceptor.RefreshTokenInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    private const val BASE_URL = "https://carbox.am/"

    @Provides
    @Singleton
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        refreshTokenInterceptor: RefreshTokenInterceptor,
        deviceHeaderInterceptor: HeaderDeviceInterceptor,
        platformHeaderInterceptor: HeaderPlatformInterceptor,
        authTokenHeaderInterceptor: HeaderAuthTokenInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(refreshTokenInterceptor)
            .addInterceptor(deviceHeaderInterceptor)
            .addInterceptor(platformHeaderInterceptor)
            .addInterceptor(authTokenHeaderInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthTokenHeaderInterceptor(
        preferencesService: SensitivePreferencesService
    ): HeaderAuthTokenInterceptor {
        return HeaderAuthTokenInterceptor(preferencesService)
    }

    @Provides
    @Singleton
    fun providePlatformHeaderInterceptor(): HeaderPlatformInterceptor {
        return HeaderPlatformInterceptor()
    }

    @Provides
    @Singleton
    fun provideRefreshTokenInterceptor(): RefreshTokenInterceptor {
        return RefreshTokenInterceptor()
    }

    @Provides
    @Singleton
    fun provideDeviceHeaderInterceptor(): HeaderDeviceInterceptor {
        return HeaderDeviceInterceptor()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
    }
}
