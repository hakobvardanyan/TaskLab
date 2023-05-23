package am.tasklab.data.user.api

import am.tasklab.data.user.model.UserRequest
import am.tasklab.data.user.model.UserResponse
import kotlinx.coroutines.flow.Flow

internal interface UserRemoteRepository {

    fun getUserById(userId: String): Flow<UserResponse>

    fun updateUser(user: UserRequest): Flow<UserResponse>
}
