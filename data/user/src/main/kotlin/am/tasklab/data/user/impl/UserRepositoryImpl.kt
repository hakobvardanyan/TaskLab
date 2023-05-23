package am.tasklab.data.user.impl

import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import am.tasklab.data.user.api.UserLocalRepository
import am.tasklab.data.user.api.UserRemoteRepository
import am.tasklab.data.user.api.UserRepository
import am.tasklab.entity.UserRequest
import am.tasklab.entity.UserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val dispatchers: TaskLabDispatchers,
    private val userLocalRepository: UserLocalRepository,
    private val userRemoteRepository: UserRemoteRepository
) : UserRepository {

    override fun getMyUser(): Flow<UserResponse> = userLocalRepository
        .getMyUser()
        .flowOn(dispatchers.io)

    override fun getUserById(userId: String): Flow<UserResponse> = userRemoteRepository
        .getUserById(userId)
        .onEach {
            if (userLocalRepository.getMyUserId().first() == userId) {
                userLocalRepository.saveMyUser(it)
            }
        }
        .flowOn(dispatchers.io)

    override fun hasUserInteractedWithOnBoarding(): Flow<Boolean> = userLocalRepository
        .hasUserInteractedWithOnBoarding()
        .flowOn(dispatchers.io)

    override fun updateUserInteractedWithOnBoarding(interacted: Boolean)= flow {
        userLocalRepository.updateUserInteractedWithOnBoarding(interacted)
        emit(Unit)
    }.flowOn(dispatchers.io)

    override fun updateUser(user: UserRequest): Flow<UserResponse> = userRemoteRepository
        .updateUser(user)
        .onEach {
            if (userLocalRepository.getMyUserId().first() == it.id) {
                userLocalRepository.saveMyUser(it)
            }
        }
        .flowOn(dispatchers.io)
}
