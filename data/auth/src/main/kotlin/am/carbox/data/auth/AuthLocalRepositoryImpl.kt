package am.carbox.data.auth

import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.coroutines.flow.Flow

class AuthLocalRepositoryImpl : AuthLocalRepository {

    override val isSignedIn: Flow<Boolean>
        get() = TODO("Not yet implemented")

    override val firebaseUserId: Flow<String>
        get() = TODO("Not yet implemented")

    override val firebaseIdToken: Flow<String>
        get() = TODO("Not yet implemented")

    override val firebaseUserPhone: Flow<String>
        get() = TODO("Not yet implemented")

    override val isFirebaseTokenExists: Flow<Boolean>
        get() = TODO("Not yet implemented")

    override val firebaseVerificationId: Flow<String>
        get() = TODO("Not yet implemented")

    override val firebaseForceResendingToken: Flow<PhoneAuthProvider.ForceResendingToken?>
        get() = TODO("Not yet implemented")

    override fun removeUserSensitiveData(): Flow<Unit> {
        TODO("Not yet implemented")
    }

    override fun cacheUserSensitiveData(
        authToken: String?,
        regenerateToken: String?,
        firebaseUserId: String?,
        firebaseIdToken: String?,
        firebaseUserPhone: String?,
        firebaseVerificationId: String?,
        firebaseForceResendingToken: PhoneAuthProvider.ForceResendingToken?,
    ): Flow<Unit> {
        TODO("Not yet implemented")
    }
}
