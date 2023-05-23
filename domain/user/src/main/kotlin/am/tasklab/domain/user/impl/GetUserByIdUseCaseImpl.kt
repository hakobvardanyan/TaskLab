package am.tasklab.domain.user.impl

import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import am.tasklab.data.user.api.UserRepository
import am.tasklab.domain.user.api.GetUserByIdUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class GetUserByIdUseCaseImpl @Inject constructor(
    private val repository: UserRepository,
    private val dispatchers: TaskLabDispatchers
) : GetUserByIdUseCase {

    override fun invoke(userId: String): Flow<Any?> = repository
        .getUserById(userId)
        .flowOn(dispatchers.io)
}
