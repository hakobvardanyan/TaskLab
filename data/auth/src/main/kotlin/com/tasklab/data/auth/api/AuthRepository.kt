package com.tasklab.data.auth.api

import com.tasklab.data.auth.model.SignInRequest
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    val isSignedIn: Flow<Boolean>

    val userId: Flow<String>

    fun signOut(): Flow<Boolean>

    fun signIn(body: SignInRequest): Flow<Boolean>

    fun consumePushToken(): Flow<String>
}
