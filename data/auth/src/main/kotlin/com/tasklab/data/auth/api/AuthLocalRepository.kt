package com.tasklab.data.auth.api

import com.tasklab.data.auth.model.SignInResponse
import kotlinx.coroutines.flow.Flow

internal interface AuthLocalRepository {

    val isSignedIn: Flow<Boolean>

    val userId: Flow<String>

    suspend fun removeUserSensitiveData()

    suspend fun cachePushToken(token: String)

    suspend fun cacheUserSensitiveData(data: SignInResponse)

}
