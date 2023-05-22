package com.tasklab.data.auth.service

import am.tasklab.core.network.model.BaseResponse
import com.tasklab.data.auth.model.AuthTokenRequest
import com.tasklab.data.auth.model.AuthTokenResponse
import com.tasklab.data.auth.model.SignInRequest
import com.tasklab.data.auth.model.SignInResponse
import com.tasklab.data.auth.model.SignUpRequest
import com.tasklab.data.auth.model.SignUpResponse
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
