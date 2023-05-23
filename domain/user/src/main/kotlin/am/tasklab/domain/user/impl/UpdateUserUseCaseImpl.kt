package am.tasklab.domain.user.impl

import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import am.tasklab.data.user.api.UserRepository
import am.tasklab.domain.user.api.UpdateUserUseCase
import am.tasklab.entity.User
import am.tasklab.mapper.api.UserResponseToUserMapper
import am.tasklab.mapper.api.UserToUserRequestMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class UpdateUserUseCaseImpl @Inject constructor(
    private val repository: UserRepository,
    private val dispatchers: TaskLabDispatchers,
    private val userToUserRequestMapper: UserToUserRequestMapper,
    private val userResponseToUserMapper: UserResponseToUserMapper,
) : UpdateUserUseCase {

    override fun invoke(user: User): Flow<User> = repository
        .updateUser(userToUserRequestMapper.map(user))
        .map(userResponseToUserMapper::map)
        .flowOn(dispatchers.io)
}