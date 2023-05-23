package am.tasklab.auth.api

import kotlinx.coroutines.flow.Flow

interface SignOutUseCase {

    operator fun invoke(): Flow<Boolean>
}
