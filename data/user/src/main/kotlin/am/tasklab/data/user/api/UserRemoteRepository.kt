package am.tasklab.data.user.api

import am.tasklab.entity.UserRequest
import am.tasklab.entity.UserResponse
import kotlinx.coroutines.flow.Flow

internal interface UserRemoteRepository {

    fun getUserById(userId: String): Flow<UserResponse>

    fun updateUser(user: UserRequest): Flow<UserResponse>
}
