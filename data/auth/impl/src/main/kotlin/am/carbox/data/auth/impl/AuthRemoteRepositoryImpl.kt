package am.carbox.data.auth.impl

import am.carbox.data.auth.model.AuthState
import am.carbox.data.auth.model.SignInApiDto
import am.carbox.data.auth.model.SignInRequestDto
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRemoteRepositoryImpl @Inject constructor(
//    private val activity: Activity?,
    private val firebaseAuth: FirebaseAuth,
//    private val authApiService: AuthApiService,
    private val firebaseMessaging: FirebaseMessaging
) : AuthRemoteRepository {

    override fun signIn(body: SignInRequestDto): Flow<SignInApiDto> {
        TODO("Not yet implemented")
    }

    override fun signOut(): Flow<Boolean> {
        TODO("Not yet implemented")
    }

    override fun getFirebaseIdToken(): Flow<String> {
        TODO("Not yet implemented")
    }

    override fun consumeFirebasePushToken(): Flow<String> {
        TODO("Not yet implemented")
    }

    override fun startVerification(phone: String): Flow<AuthState> {
        TODO("Not yet implemented")
    }

    override fun resendVerification(
        phone: String,
        resendToken: PhoneAuthProvider.ForceResendingToken?,
    ): Flow<AuthState> {
        TODO("Not yet implemented")
    }

    override fun verifyVerificationCode(verificationId: String, smsCode: String): Flow<AuthState> {
        TODO("Not yet implemented")
    }
}
