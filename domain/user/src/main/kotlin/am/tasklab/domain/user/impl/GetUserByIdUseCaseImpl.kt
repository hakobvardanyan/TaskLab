package am.tasklab.domain.user.impl

import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import am.tasklab.domain.user.api.GetUserByIdUseCase
import com.tasklab.data.auth.api.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class GetUserByIdUseCaseImpl @Inject constructor(
    private val repo: AuthRepository,
    private val dispatchers: TaskLabDispatchers
) : GetUserByIdUseCase {

    override fun invoke(userId: String): Flow<Any?> = flow {
        emit(repo.isSignedIn)
    }.flowOn(dispatchers.io)
}
