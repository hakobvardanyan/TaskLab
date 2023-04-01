package am.carbox.core.common.logger

import android.util.Log

object Logger {

    private const val APP_TAG = "CarBoxAndroid"

    fun debug(message: String) {
        Log.d(APP_TAG, message)
    }

    fun log(message: String) {
        Log.d(APP_TAG, message)
        // Send to Crashlytics
    }

    fun exception(throwable: Throwable, message: String = "") {
        Log.e(APP_TAG, message, throwable)
        // Send to crashlytics
    }

    fun info(message: String) {
        Log.i(APP_TAG, message)
    }

    fun verbose(message: String) {
        Log.v(APP_TAG, message)
    }

    fun warning(message: String) {
        Log.w(APP_TAG, message)
        // Send to Crashlytics
    }
}
