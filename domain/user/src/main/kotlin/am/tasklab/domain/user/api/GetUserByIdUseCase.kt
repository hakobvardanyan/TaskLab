package am.tasklab.domain.user.api

import am.tasklab.entity.User
import kotlinx.coroutines.flow.Flow

interface GetUserByIdUseCase {

    operator fun invoke(userId: String): Flow<User>
}
