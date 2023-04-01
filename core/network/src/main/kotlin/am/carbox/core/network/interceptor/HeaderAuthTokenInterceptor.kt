package am.carbox.core.network.interceptor

import am.carbox.core.io.preference.SensitivePreferencesService
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class HeaderAuthTokenInterceptor @Inject constructor(
    private val preferencesService: SensitivePreferencesService
) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val authToken = runBlocking { preferencesService.authToken.first() }
        if (authToken.isNotEmpty()) {
            val authRequest = chain
                .request()
                .newBuilder()
                .header(HEADER_AUTHORIZATION, authToken)
                .build()
            return chain.proceed(authRequest)
        }
        return chain.proceed(chain.request())
    }

    private companion object {
        const val TAG = "HeaderAuthTokenInterceptor"
        const val HEADER_AUTHORIZATION = "x-access-token"
    }
}
