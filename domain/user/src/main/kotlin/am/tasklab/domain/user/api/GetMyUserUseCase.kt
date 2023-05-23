package am.tasklab.domain.user.api

import am.tasklab.entity.User
import kotlinx.coroutines.flow.Flow

interface GetMyUserUseCase {

    operator fun invoke(): Flow<User>
}
