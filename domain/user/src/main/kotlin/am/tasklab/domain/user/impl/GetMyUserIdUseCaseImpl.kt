package am.tasklab.domain.user.impl

import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import am.tasklab.domain.user.api.GetMyUserIdUseCase
import com.tasklab.data.auth.api.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class GetMyUserIdUseCaseImpl @Inject constructor(
    private val repository: AuthRepository,
    private val dispatchers: TaskLabDispatchers
) : GetMyUserIdUseCase {

    override fun invoke(): Flow<String> = repository
        .userId
        .flowOn(dispatchers.io)
}
