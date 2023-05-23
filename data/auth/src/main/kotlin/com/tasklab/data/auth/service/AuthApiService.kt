package com.tasklab.data.auth.service

import am.tasklab.core.network.model.BaseResponse
import am.tasklab.entity.AuthTokenRequest
import am.tasklab.entity.AuthTokenResponse
import am.tasklab.entity.SignInRequest
import am.tasklab.entity.SignInResponse
import am.tasklab.entity.SignUpRequest
import am.tasklab.entity.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.POST

internal interface AuthApiService {

    @POST("api/auth_new/signout")
    suspend fun signOut(): BaseResponse<Boolean>

    @POST("api/auth/signin")
    suspend fun signIn(@Body credentials: SignInRequest): BaseResponse<SignInResponse>

    @POST("api/auth/signup")
    suspend fun signUp(@Body credentials: SignUpRequest): BaseResponse<SignUpResponse>

    @POST("api/auth/token/regenerate")
    suspend fun updateToken(@Body credentials: AuthTokenRequest): BaseResponse<AuthTokenResponse>
}
