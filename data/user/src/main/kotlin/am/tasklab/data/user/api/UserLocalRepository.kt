package am.tasklab.data.user.api

import am.tasklab.entity.UserResponse
import kotlinx.coroutines.flow.Flow

internal interface UserLocalRepository {

    fun getMyUserId(): Flow<String>

    fun getMyUser(): Flow<am.tasklab.entity.UserResponse>

    suspend fun saveMyUser(user: am.tasklab.entity.UserResponse)
}
