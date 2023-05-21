package am.tasklab.domain.user.api

import kotlinx.coroutines.flow.Flow

interface GetUserByIdUseCase {

    operator fun invoke(userId: String): Flow<Any?>
}
