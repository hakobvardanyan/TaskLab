package am.tasklab.domain.user.impl

import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import am.tasklab.data.user.api.UserRepository
import am.tasklab.domain.user.api.CheckInteractedWithOnBoardingUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class CheckInteractedWithOnBoardingUseCaseImpl @Inject constructor(
    private val repository: UserRepository,
    private val dispatchers: TaskLabDispatchers
) : CheckInteractedWithOnBoardingUseCase {

    override fun invoke(): Flow<Boolean> = repository
        .hasUserInteractedWithOnBoarding()
        .flowOn(dispatchers.io)
}
