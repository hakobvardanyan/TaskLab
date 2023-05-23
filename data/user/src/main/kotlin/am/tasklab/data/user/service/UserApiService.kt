package am.tasklab.data.user.service

import am.tasklab.core.network.model.BaseResponse
import am.tasklab.entity.UserRequest
import am.tasklab.entity.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

internal interface UserApiService {

    @GET("api/user/{userId}")
    suspend fun getUserById(@Path("userId") id: String): BaseResponse<UserResponse>

    @POST("api/user/update")
    suspend fun updateUser(@Body body: UserRequest): BaseResponse<UserResponse>
}
