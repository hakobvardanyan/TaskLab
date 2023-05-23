package am.tasklab.auth.api

import kotlinx.coroutines.flow.Flow

interface CheckSignedInUseCase {

    operator fun invoke(): Flow<Boolean>
}
