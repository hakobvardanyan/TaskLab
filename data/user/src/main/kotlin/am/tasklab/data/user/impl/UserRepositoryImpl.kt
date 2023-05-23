package am.tasklab.data.user.impl

import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import am.tasklab.data.user.api.UserLocalRepository
import am.tasklab.data.user.api.UserRemoteRepository
import am.tasklab.data.user.api.UserRepository
import am.tasklab.entity.UserRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val dispatchers: TaskLabDispatchers,
    private val userLocalRepository: UserLocalRepository,
    private val userRemoteRepository: UserRemoteRepository
) : UserRepository {

    override fun getMyUser(): Flow<am.tasklab.entity.UserResponse> = userLocalRepository.getMyUser()

    override fun getUserById(userId: String): Flow<am.tasklab.entity.UserResponse> = userRemoteRepository
        .getUserById(userId)
        .onEach {
            if (userLocalRepository.getMyUserId().first() == userId) {
                userLocalRepository.saveMyUser(it)
            }
        }
        .flowOn(dispatchers.io)

    override fun updateUser(user: UserRequest): Flow<am.tasklab.entity.UserResponse> = userRemoteRepository
        .updateUser(user)
        .onEach {
            if (userLocalRepository.getMyUserId().first() == it.id) {
                userLocalRepository.saveMyUser(it)
            }
        }
        .flowOn(dispatchers.io)
}
