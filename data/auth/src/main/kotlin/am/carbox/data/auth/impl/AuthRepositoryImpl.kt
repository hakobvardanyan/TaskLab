package am.carbox.data.auth.impl

import am.carbox.data.auth.api.AuthLocalRepository
import am.carbox.data.auth.api.AuthRemoteRepository
import am.carbox.data.auth.api.AuthRepository
import am.carbox.data.auth.model.AuthState
import android.app.Activity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class AuthRepositoryImpl @Inject constructor(
    private val authLocalRepository: AuthLocalRepository,
    private val authRemoteRepository: AuthRemoteRepository,
) : AuthRepository {

    override val isSignedIn: Flow<Boolean>
        get() = authLocalRepository.isSignedIn

    override val verificationId: Flow<String>
        get() = TODO("Not yet implemented")

    override val firebaseUserId: Flow<String>
        get() = TODO("Not yet implemented")

    override val isFirebaseTokenExists: Flow<Boolean>
        get() = TODO("Not yet implemented")

    override fun signIn(): Flow<Boolean> {
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

    override fun startVerification(activity: Activity, phoneNumber: String): Flow<AuthState> {
        return authRemoteRepository.startVerification(activity, phoneNumber)
    }

    override fun resendVerification(phoneNumber: String): Flow<AuthState> {
        TODO("Not yet implemented")
    }

    override fun verifyVerificationCode(verificationId: String, smsCode: String): Flow<AuthState> {
        TODO("Not yet implemented")
    }
}
