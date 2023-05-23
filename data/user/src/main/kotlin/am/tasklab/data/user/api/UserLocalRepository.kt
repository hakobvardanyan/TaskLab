package am.tasklab.data.user.api

import am.tasklab.data.user.model.UserResponse
import kotlinx.coroutines.flow.Flow

internal interface UserLocalRepository {

    fun getMyUserId(): Flow<String>

    fun getMyUser(): Flow<UserResponse>

    suspend fun saveMyUser(user: UserResponse)
}
