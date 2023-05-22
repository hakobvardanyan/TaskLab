package com.tasklab.data.auth.impl

import am.tasklab.core.common.logger.Logger
import am.tasklab.core.network.model.BaseResponse
import am.tasklab.core.network.parser.BaseResponseParser
import com.tasklab.data.auth.api.AuthRemoteRepository
import com.tasklab.data.auth.model.SignInRequest
import com.tasklab.data.auth.model.SignInResponse
import com.tasklab.data.auth.model.SignUpRequest
import com.tasklab.data.auth.model.SignUpResponse
import com.tasklab.data.auth.model.AccountResponse
import com.tasklab.data.auth.service.AuthApiService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
internal class AuthRemoteRepositoryImpl @Inject constructor(
    private val authApiService: AuthApiService,
    private val responseParser: BaseResponseParser
) : AuthRemoteRepository {

    override fun signUp(body: SignUpRequest): Flow<SignUpResponse> = flow {
        Logger.debug("$TAG.signUp() body = $body")
        delay(Random.nextLong(1000))
        emit(mockedSignUpResponse())
//        emit(authApiService.signUp(body))
    }.map(responseParser::parse)

    override fun signIn(body: SignInRequest): Flow<SignInResponse> = flow {
        Logger.debug("$TAG.signIn() body = $body")
        delay(Random.nextLong(1000))
        emit(mockedSignInResponse())
//        emit(authApiService.signIn(body))
    }.map(responseParser::parse)

    override fun signOut(): Flow<Boolean> = flow {
        Logger.debug("$TAG.signOut()")
        delay(Random.nextLong(1000))
        emit(Random.nextBoolean())
//        emit(authApiService.signOut().status)
    }.catch {
        emit(false)
    }

    override fun consumePushToken(): Flow<String> = flow {
        Logger.debug("$TAG.consumePushToken()")
        delay(Random.nextLong(1000))
        emit(UUID.randomUUID().toString())
    }

    private fun mockedSignInResponse(): BaseResponse<SignInResponse> = BaseResponse(
        status = true,
        timestamp = System.currentTimeMillis(),
        data = SignInResponse(
            account = AccountResponse(
                id = UUID.randomUUID().toString(),
                firstName = "John",
                lastName = "Smith",
                age = 35
            ),
            token = UUID.randomUUID().toString(),
            regenerateToken = UUID.randomUUID().toString()
        )
    )

    private fun mockedSignUpResponse(): BaseResponse<SignUpResponse> = BaseResponse(
        status = true,
        timestamp = System.currentTimeMillis(),
        data = SignUpResponse(
            account = AccountResponse(
                id = UUID.randomUUID().toString(),
                firstName = "John",
                lastName = "Smith",
                age = 35
            ),
            token = UUID.randomUUID().toString(),
            regenerateToken = UUID.randomUUID().toString()
        )
    )

    private companion object {
        const val TAG = "AuthRemoteRepositoryImpl"
    }
}
