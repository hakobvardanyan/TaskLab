package am.tasklab.data.user.api

import am.tasklab.entity.UserRequest
import kotlinx.coroutines.flow.Flow

internal interface UserRemoteRepository {

    fun getUserById(userId: String): Flow<am.tasklab.entity.UserResponse>

    fun updateUser(user: UserRequest): Flow<am.tasklab.entity.UserResponse>
}
