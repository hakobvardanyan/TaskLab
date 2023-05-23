package am.tasklab.data.user.api

import am.tasklab.entity.UserRequest
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getMyUser(): Flow<am.tasklab.entity.UserResponse>

    fun getUserById(userId: String): Flow<am.tasklab.entity.UserResponse>

    fun updateUser(user: UserRequest): Flow<am.tasklab.entity.UserResponse>
}
