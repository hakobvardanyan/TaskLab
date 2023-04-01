package am.carbox.core.io.preference

import kotlinx.coroutines.flow.Flow

interface SensitivePreferencesService {
    val authToken: Flow<String>
    val pushToken: Flow<String>
    val firebaseUserId: Flow<String>
    val regenerateToken: Flow<String>
    val firebaseIdToken: Flow<String>
    val firebaseVerificationId: Flow<String>
    val firebaseUserPhoneNumber: Flow<String>

    suspend fun updateAuthToken(token: String)
    suspend fun updatePushToken(token: String)
    suspend fun updateFirebaseUserId(id: String)
    suspend fun updateRegenerateToken(token: String)
    suspend fun updateFirebaseIdToken(token: String)
    suspend fun updateFirebaseVerificationId(id: String)
    suspend fun updateFirebaseUserPhoneNumber(number: String)
    suspend fun clear()
}
