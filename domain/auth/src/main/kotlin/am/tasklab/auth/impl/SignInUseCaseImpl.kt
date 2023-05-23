package am.tasklab.auth.impl

import am.tasklab.auth.api.SignInUseCase
import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import am.tasklab.entity.SignInCredentials
import am.tasklab.mapper.api.SignInCredentialsToSignInRequestMapper
import com.tasklab.data.auth.api.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class SignInUseCaseImpl @Inject constructor(
    private val repository: AuthRepository,
    private val dispatchers: TaskLabDispatchers,
    private val mapper: SignInCredentialsToSignInRequestMapper
) : SignInUseCase {

    override fun invoke(credentials: SignInCredentials): Flow<Boolean> = repository
        .signIn(mapper.map(credentials))
        .flowOn(dispatchers.io)
}
