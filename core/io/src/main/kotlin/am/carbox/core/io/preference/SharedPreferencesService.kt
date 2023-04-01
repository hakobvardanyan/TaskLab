package am.carbox.core.io.preference

import kotlinx.coroutines.flow.Flow

interface SharedPreferencesService {
    val hasUserInteractedWithOnBoarding: Flow<Boolean>
    val phoneNumber: Flow<String>
    val phoneFormatType: Flow<String>
    val phoneCountryCode: Flow<String>
    val firebaseForceResendingToken: Flow<String>
    val hasUserInteractedWithCarOnBoarding: Flow<Boolean>

    suspend fun updatePhoneFormatType(type: String)
    suspend fun updatePhoneCountryCode(code: String)
    suspend fun updatePhoneNumber(phoneNumber: String)
    suspend fun updateFirebaseForceResendingToken(token: String)
    suspend fun updateInteractionWithOnBoarding(interacted: Boolean)
    suspend fun updateInteractionWithCarOnBoarding(interacted: Boolean)
    suspend fun clear()
}
