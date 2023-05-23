package am.tasklab.domain.user.api

import am.tasklab.entity.User
import kotlinx.coroutines.flow.Flow

interface UpdateUserUseCase {

    operator fun invoke(user: User): Flow<User>
}
