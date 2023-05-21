package am.tasklab.core.network.interceptor

import android.os.Build
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class HeaderDeviceInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val authRequest = chain
            .request()
            .newBuilder()
            .header(HEADER_DEVICE, DEVICE)
            .build()
        return chain.proceed(authRequest)
    }

    private companion object {
        const val TAG = "HeaderDeviceInterceptor"
        const val HEADER_DEVICE = "device"
        val DEVICE = "${Build.MANUFACTURER} - ${Build.MODEL}"
    }
}
