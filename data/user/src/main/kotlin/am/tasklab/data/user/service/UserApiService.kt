package am.tasklab.data.user.service

import am.tasklab.core.network.model.BaseResponse
import am.tasklab.data.user.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

internal interface UserApiService {

    @GET("api/user/{userId}")
    suspend fun getUserById(@Path("userId") id: String): BaseResponse<UserResponse>
}
