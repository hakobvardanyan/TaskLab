package am.carbox.core.network.interceptor

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class RefreshTokenInterceptor @Inject constructor(
//    private val securePreferences: SecurePrefsWrapper
) : Interceptor {

    // need lazy injection to avoid circular dependency
//    private val authService: AuthApiService by inject()
//    private val signInUseCase: SignInUseCase by inject()
//    private val gson: Gson by lazy { Gson() }
//    private val requestBody: SignInRequestDto
//        get() = securePreferences.run {
//            SignInRequestDto(firebaseUserPhoneNumber, firebaseUserId, regenerateToken)
//        }

    override fun intercept(chain: Interceptor.Chain): Response {
//        Logger.debug("$TAG.intercept")
//        val originalRequest = chain.request()
//        val response = chain.proceed(originalRequest)
//        Logger.debug("$TAG.intercept response.isSuccessful=${response.isSuccessful}")
//
//        if (response.isSuccessful) {
//            val header = originalRequest.header(HEADER_AUTHORIZATION)
//            if (header.isNullOrEmpty()) return response
//
//            synchronized(this) {
//                if (securePreferences.authToken != header) {
//                    val newToken = updateToken()
//                    if (newToken.isNotEmpty()) {
//                        securePreferences.authToken = newToken
//                        return chain.proceed(getRefreshedRequest(originalRequest))
//                    }
//                }
//
//                val type = object : TypeToken<BaseApiDto<*>>() {}.type
//                val result: BaseApiDto<*> = gson.fromJson(response.peekBody(ONE_MIB).string(), type)
//                val newToken = updateTokenOrEmpty(result.errorCode)
//                if (newToken.isNotEmpty()) {
//                    securePreferences.authToken = newToken
//                    return chain.proceed(getRefreshedRequest(originalRequest))
//                }
//            }
//
//        } else if (response.code == HTTP_UNAUTHORIZED) {
//            Logger.debug("$TAG.intercept HTTP_UNAUTHORIZED(${HTTP_UNAUTHORIZED})")
//            synchronized(this) {
//                val newToken: String = updateToken()
//                if (newToken.isNotEmpty()) {
//                    securePreferences.authToken = newToken
//                    return chain.proceed(getRefreshedRequest(originalRequest))
//                }
//            }
//        }
//        return response

        return chain.proceed(chain.request())
    }

//    private fun updateTokenOrEmpty(errorCode: Int?): String = when (errorCode) {
//        ErrorCodes.CODE_EXPIRED_JWT_TOKEN.code -> updateToken()
//        else -> String.EMPTY
//    }
//
//    // blocking request
//    private fun updateToken(): String {
//        var updatedToken: String = String.EMPTY
//        runBlocking {
//            Logger.debug("$TAG.updateToken() request has begun")
//            val result = authService.updateToken(requestBody)
//            val isSuccessful = result.status
//            Logger.debug("$TAG.updateToken() request has done. isSuccessful=$isSuccessful")
//            when {
//                isSuccessful -> updatedToken = result.data?.token.orEmpty()
//                result.errorCode == ErrorCodes.CODE_EXPIRED_JWT_TOKEN.code -> {
//                    Logger.debug("$TAG.updateToken() regenerateToken expired, signing in...")
//                    signInUseCase.execute().collect()
//                    Logger.debug("$TAG.updateToken() sign in completed, updating token with new regenerate token")
//                    with(authService.updateToken(requestBody)) {
//                        if (status) updatedToken = data?.token.orEmpty()
//                    }
//                }
//            }
//            Logger.debug("$TAG.updateToken() newToken=$updatedToken")
//        }
//        return updatedToken
//    }
//
//    private fun getRefreshedRequest(request: Request) = request
//        .newBuilder()
//        .header(HEADER_AUTHORIZATION, securePreferences.authToken)
//        .build()

    private companion object {
        const val ONE_MIB = 1049000L
        const val TAG = "RefreshTokenInterceptor"
        const val HEADER_AUTHORIZATION = "x-access-token"
    }
}
