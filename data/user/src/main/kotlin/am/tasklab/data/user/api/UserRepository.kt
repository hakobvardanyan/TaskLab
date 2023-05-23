package am.tasklab.data.user.api

import am.tasklab.entity.UserRequest
import am.tasklab.entity.UserResponse
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getMyUser(): Flow<UserResponse>

    fun getUserById(userId: String): Flow<UserResponse>

    fun hasUserInteractedWithOnBoarding(): Flow<Boolean>

    fun updateUserInteractedWithOnBoarding(interacted: Boolean): Flow<Unit>

    fun updateUser(user: UserRequest): Flow<UserResponse>
}
