package com.tasklab.data.auth.impl

import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import am.tasklab.core.io.preference.SensitivePreferencesService
import com.tasklab.data.auth.api.AuthLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class AuthLocalRepositoryImpl @Inject constructor(
    private val dispatchers: TaskLabDispatchers,
    private val preferences: SensitivePreferencesService
) : AuthLocalRepository {

    override val isSignedIn: Flow<Boolean>
        get() = preferences.userId
            .map { it.isNotBlank() }
            .flowOn(dispatchers.io)

    override val userId: Flow<String>
        get() = preferences.userId

    override suspend fun removeUserSensitiveData() {
        preferences.clear()
    }

    override suspend fun cacheUserSensitiveData(
        userId: String?,
        authToken: String?,
        pushToken: String?,
        regenerateToken: String?
    ) {
        userId?.let { preferences.updateUserId(it) }
        authToken?.let { preferences.updateAuthToken(it) }
        regenerateToken?.let { preferences.updateRegenerateToken(it) }
    }
}
