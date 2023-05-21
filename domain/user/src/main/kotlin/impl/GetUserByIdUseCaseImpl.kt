package impl

import am.carbox.core.io.dispatchers.CarBoxDispatchers
import api.GetUserByIdUseCase
import com.tasklab.data.auth.api.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class GetUserByIdUseCaseImpl @Inject constructor(
    private val repo: AuthRepository,
    private val dispatchers: CarBoxDispatchers
) : GetUserByIdUseCase {

    override fun invoke(userId: String): Flow<Any?> = flow {
        emit(Unit)
    }.flowOn(dispatchers.io)
}
