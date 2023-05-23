package am.tasklab.auth.api

import am.tasklab.entity.SignInCredentials
import kotlinx.coroutines.flow.Flow

interface SignInUseCase {

    operator fun invoke(credentials: SignInCredentials): Flow<Boolean>
}
