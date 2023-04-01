package am.carbox.core.network.interceptor

import am.carbox.core.io.preference.SensitivePreferencesService
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class HeaderAuthTokenInterceptor @Inject constructor(
//    private val securePreferences: SecurePrefsWrapper
    private val preferencesService: SensitivePreferencesService
) : Interceptor {

    private val authToken: String
        get() = ""
//    try {
//            securePreferences.authToken
//        } catch (throwable: Throwable) {
//            Logger.exception(throwable, "$TAG.authToken - ${throwable.message}")
//            String.EMPTY
//        }

    override fun intercept(chain: Interceptor.Chain): Response {
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
