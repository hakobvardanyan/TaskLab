package am.tasklab.data.user.api

import am.tasklab.data.user.model.UserRequest
import am.tasklab.data.user.model.UserResponse
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getMyUser(): Flow<UserResponse>

    fun getUserById(userId: String): Flow<UserResponse>

    fun updateUser(user: UserRequest): Flow<UserResponse>
}
