package am.tasklab.domain.user.api

import kotlinx.coroutines.flow.Flow


interface GetMyUserIdUseCase {

    operator fun invoke(): Flow<String>
}
