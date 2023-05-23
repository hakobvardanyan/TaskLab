package com.tasklab.data.auth.api

import am.tasklab.entity.SignInRequest
import am.tasklab.entity.SignInResponse
import am.tasklab.entity.SignUpRequest
import am.tasklab.entity.SignUpResponse
import kotlinx.coroutines.flow.Flow

internal interface AuthRemoteRepository {

    fun signUp(body: SignUpRequest): Flow<SignUpResponse>

    fun signIn(body: SignInRequest): Flow<SignInResponse>

    fun signOut(): Flow<Boolean>

    fun consumePushToken(): Flow<String>

}
