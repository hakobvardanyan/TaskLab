package am.tasklab.domain.user.impl

import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import am.tasklab.data.user.api.UserRepository
import am.tasklab.domain.user.api.UpdateInteractionWithOnBoardingUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class UpdateInteractionWithOnBoardingUseCaseImpl @Inject constructor(
    private val repository: UserRepository,
    private val dispatchers: TaskLabDispatchers
) : UpdateInteractionWithOnBoardingUseCase {

    override fun invoke(interacted: Boolean): Flow<Unit> = repository
        .updateUserInteractedWithOnBoarding(interacted)
        .flowOn(dispatchers.io)
}
