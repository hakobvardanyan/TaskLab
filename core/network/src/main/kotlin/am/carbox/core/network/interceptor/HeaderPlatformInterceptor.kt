package am.carbox.core.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class HeaderPlatformInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val authRequest = chain
            .request()
            .newBuilder()
            .header(HEADER_PLATFORM, PLATFORM_ANDROID)
            .build()
        return chain.proceed(authRequest)
    }

    private companion object {
        const val TAG = "HeaderPlatformInterceptor"
        const val HEADER_PLATFORM = "platform"
        const val PLATFORM_ANDROID = "Android"
    }
}
