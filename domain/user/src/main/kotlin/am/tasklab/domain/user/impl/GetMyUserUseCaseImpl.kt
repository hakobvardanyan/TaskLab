package am.tasklab.domain.user.impl

import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import am.tasklab.data.user.api.UserRepository
import am.tasklab.domain.user.api.GetMyUserUseCase
import am.tasklab.entity.User
import am.tasklab.mapper.api.UserResponseToUserMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class GetMyUserUseCaseImpl @Inject constructor(
    private val repository: UserRepository,
    private val dispatchers: TaskLabDispatchers,
    private val mapper: UserResponseToUserMapper
) : GetMyUserUseCase {

    override fun invoke(): Flow<User> = repository
        .getMyUser()
        .map(mapper::map)
        .flowOn(dispatchers.io)
}
