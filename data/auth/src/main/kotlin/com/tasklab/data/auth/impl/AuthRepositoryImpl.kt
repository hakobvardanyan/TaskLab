package com.tasklab.data.auth.impl

import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import com.tasklab.data.auth.api.AuthLocalRepository
import com.tasklab.data.auth.api.AuthRemoteRepository
import com.tasklab.data.auth.api.AuthRepository
import am.tasklab.entity.SignInRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class AuthRepositoryImpl @Inject constructor(
    private val dispatchers: TaskLabDispatchers,
    private val authLocalRepository: AuthLocalRepository,
    private val authRemoteRepository: AuthRemoteRepository
) : AuthRepository {

    override val isSignedIn: Flow<Boolean>
        get() = authLocalRepository.isSignedIn

    override val userId: Flow<String>
        get() = authLocalRepository.userId

    override fun signIn(body: SignInRequest): Flow<Boolean> = authRemoteRepository.signIn(body)
        .onEach(authLocalRepository::cacheUserSensitiveData)
        .map { it.user?.id != null }
        .flowOn(dispatchers.io)

    override fun signOut(): Flow<Boolean> = authRemoteRepository.signOut()
        .onEach { signedOut ->
            if (signedOut) {
                authLocalRepository.removeUserSensitiveData()
            }
        }
        .flowOn(dispatchers.io)

    override fun consumePushToken(): Flow<String> = authRemoteRepository.consumePushToken()
        .onEach(authLocalRepository::cachePushToken)
        .flowOn(dispatchers.io)
}
