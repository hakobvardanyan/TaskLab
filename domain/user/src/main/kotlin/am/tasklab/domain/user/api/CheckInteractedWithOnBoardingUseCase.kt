package am.tasklab.domain.user.api

import kotlinx.coroutines.flow.Flow

interface CheckInteractedWithOnBoardingUseCase {

    operator fun invoke(): Flow<Boolean>
}
