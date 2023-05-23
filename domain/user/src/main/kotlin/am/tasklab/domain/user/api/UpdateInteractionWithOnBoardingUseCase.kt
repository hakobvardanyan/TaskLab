package am.tasklab.domain.user.api

import kotlinx.coroutines.flow.Flow

interface UpdateInteractionWithOnBoardingUseCase {

    operator fun invoke(interacted: Boolean): Flow<Unit>
}
