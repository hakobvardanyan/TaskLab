package com.tasklab.data.auth.api

import com.tasklab.data.auth.model.SignInRequest
import com.tasklab.data.auth.model.SignInResponse
import com.tasklab.data.auth.model.SignUpRequest
import com.tasklab.data.auth.model.SignUpResponse
import kotlinx.coroutines.flow.Flow

internal interface AuthRemoteRepository {

    fun signUp(body: SignUpRequest): Flow<SignUpResponse>

    fun signIn(body: SignInRequest): Flow<SignInResponse>

    fun signOut(): Flow<Boolean>

    fun consumePushToken(): Flow<String>

}
