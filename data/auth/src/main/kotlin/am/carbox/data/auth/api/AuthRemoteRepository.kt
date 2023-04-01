package am.carbox.data.auth.api

import am.carbox.data.auth.model.AuthState
import am.carbox.data.auth.model.SignInResponse
import am.carbox.data.auth.model.SignInRequest
import android.app.Activity
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import kotlinx.coroutines.flow.Flow

internal interface AuthRemoteRepository {
    fun signIn(body: SignInRequest): Flow<SignInResponse>

    fun signOut(): Flow<Boolean>

    fun getFirebaseIdToken(): Flow<String>

    fun consumeFirebasePushToken(): Flow<String>

    fun startVerification(
        activity: Activity,
        phone: String,
    ): Flow<AuthState>

    fun resendVerification(
        activity: Activity,
        phone: String,
        resendToken: ForceResendingToken?,
    ): Flow<AuthState>

    fun verifyVerificationCode(
        verificationId: String,
        smsCode: String,
    ): Flow<AuthState>
}
