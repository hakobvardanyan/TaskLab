package am.tasklab.auth.impl

import am.tasklab.auth.api.ConsumePushTokenUseCase
import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import com.tasklab.data.auth.api.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class ConsumePushTokenUseCaseImpl @Inject constructor(
    private val repository: AuthRepository,
    private val dispatchers: TaskLabDispatchers
) : ConsumePushTokenUseCase {

    override fun invoke(): Flow<String> = repository
        .consumePushToken()
        .flowOn(dispatchers.io)
}
