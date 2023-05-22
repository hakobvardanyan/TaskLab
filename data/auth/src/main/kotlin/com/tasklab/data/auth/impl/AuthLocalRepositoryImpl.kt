package com.tasklab.data.auth.impl

import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import am.tasklab.core.io.preference.SensitivePreferencesService
import com.tasklab.data.auth.api.AuthLocalRepository
import com.tasklab.data.auth.model.SignInResponse
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

    override suspend fun cachePushToken(token: String) {
        preferences.updatePushToken(token)
    }

    override suspend fun cacheUserSensitiveData(data: SignInResponse) {
        data.user?.id?.let { preferences.updateUserId(it) }
        data.token?.let { preferences.updateAuthToken(it) }
        data.regenerateToken?.let { preferences.updateRegenerateToken(it) }
    }

}
