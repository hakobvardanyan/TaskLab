package am.tasklab.domain.user.impl

import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import am.tasklab.data.user.api.UserRepository
import am.tasklab.domain.user.api.GetUserByIdUseCase
import am.tasklab.entity.User
import am.tasklab.mapper.api.UserResponseToUserMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class GetUserByIdUseCaseImpl @Inject constructor(
    private val repository: UserRepository,
    private val dispatchers: TaskLabDispatchers,
    private val mapper: UserResponseToUserMapper
) : GetUserByIdUseCase {

    override fun invoke(userId: String): Flow<User> = repository
        .getUserById(userId)
        .map(mapper::map)
        .flowOn(dispatchers.io)
}
