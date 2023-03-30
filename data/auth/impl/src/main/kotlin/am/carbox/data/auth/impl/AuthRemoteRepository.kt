package am.carbox.data.auth.impl

import am.carbox.data.auth.model.AuthState
import am.carbox.data.auth.model.SignInApiDto
import am.carbox.data.auth.model.SignInRequestDto
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import kotlinx.coroutines.flow.Flow

interface AuthRemoteRepository {
    fun signIn(body: SignInRequestDto): Flow<SignInApiDto>
    fun signOut(): Flow<Boolean>
    fun getFirebaseIdToken(): Flow<String>
    fun consumeFirebasePushToken(): Flow<String>
    fun startVerification(phone: String): Flow<AuthState>
    fun resendVerification(
        phone: String,
        resendToken: ForceResendingToken?,
    ): Flow<AuthState>

    fun verifyVerificationCode(verificationId: String, smsCode: String): Flow<AuthState>
}