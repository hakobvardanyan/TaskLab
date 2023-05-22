package com.tasklab.data.auth.api

import com.tasklab.data.auth.model.SignInRequest
import com.tasklab.data.auth.model.SignInResponse
import kotlinx.coroutines.flow.Flow

internal interface AuthRemoteRepository {

    fun signIn(body: SignInRequest): Flow<SignInResponse>

    fun signOut(): Flow<Boolean>

    fun consumePushToken(): Flow<String>

}
