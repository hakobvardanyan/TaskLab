package am.carbox.data.auth.service

import am.carbox.core.network.model.BaseResponse
import am.carbox.data.auth.model.SignInResponse
import am.carbox.data.auth.model.SignInRequest
import retrofit2.http.Body
import retrofit2.http.POST

internal interface AuthApiService {

    @POST("api/auth_new/signin")
    suspend fun signIn(@Body credentials: SignInRequest): BaseResponse<SignInResponse>

    @POST("api/auth_new/signout")
    suspend fun signOut(): BaseResponse<Any?>

    @POST("api/auth_new/token/regenerate")
    suspend fun updateToken(@Body credentials: SignInRequest): BaseResponse<SignInResponse>
}
