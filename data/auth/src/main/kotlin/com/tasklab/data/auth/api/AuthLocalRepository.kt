package com.tasklab.data.auth.api

import kotlinx.coroutines.flow.Flow

internal interface AuthLocalRepository {

    val isSignedIn: Flow<Boolean>

    val userId: Flow<String>

    suspend fun removeUserSensitiveData()

    suspend fun cacheUserSensitiveData(
        userId: String? = null,
        authToken: String? = null,
        pushToken: String? = null,
        regenerateToken: String? = null,
    )
}
