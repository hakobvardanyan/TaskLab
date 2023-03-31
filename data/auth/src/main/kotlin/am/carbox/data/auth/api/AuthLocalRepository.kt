package am.carbox.data.auth.api

import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.coroutines.flow.Flow

internal interface AuthLocalRepository {
    val isSignedIn: Flow<Boolean>
    val firebaseUserId: Flow<String>
    val firebaseIdToken: Flow<String>
    val firebaseUserPhone: Flow<String>
    val isFirebaseTokenExists: Flow<Boolean>
    val firebaseVerificationId: Flow<String>
    val firebaseForceResendingToken: Flow<PhoneAuthProvider.ForceResendingToken?>

    fun removeUserSensitiveData(): Flow<Unit>
    fun cacheUserSensitiveData(
        authToken: String? = null,
        regenerateToken: String? = null,
        firebaseUserId: String? = null,
        firebaseIdToken: String? = null,
        firebaseUserPhone: String? = null,
        firebaseVerificationId: String? = null,
        firebaseForceResendingToken: PhoneAuthProvider.ForceResendingToken? = null
    ): Flow<Unit>
}