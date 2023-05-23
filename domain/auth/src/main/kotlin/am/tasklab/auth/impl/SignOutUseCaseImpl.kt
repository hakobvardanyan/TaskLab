package am.tasklab.auth.impl

import am.tasklab.auth.api.SignOutUseCase
import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import com.tasklab.data.auth.api.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class SignOutUseCaseImpl @Inject constructor(
    private val repository: AuthRepository,
    private val dispatchers: TaskLabDispatchers
) : SignOutUseCase {

    override fun invoke(): Flow<Boolean> = repository
        .signOut()
        .flowOn(dispatchers.io)
}
