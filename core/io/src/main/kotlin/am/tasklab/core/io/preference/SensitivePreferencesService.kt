package am.tasklab.core.io.preference

import kotlinx.coroutines.flow.Flow

interface SensitivePreferencesService {

    val authToken: Flow<String>

    val pushToken: Flow<String>

    val userId: Flow<String>

    val regenerateToken: Flow<String>

    suspend fun updateAuthToken(token: String)

    suspend fun updatePushToken(token: String)

    suspend fun updateUserId(id: String)

    suspend fun updateRegenerateToken(token: String)

    suspend fun clear()
}
