package am.tasklab.domain.user.impl

import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import am.tasklab.data.user.api.UserRepository
import am.tasklab.domain.user.api.UpdateUserUseCase
import am.tasklab.entity.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class UpdateUserUseCaseImpl @Inject constructor(
    private val repository: UserRepository,
    private val dispatchers: TaskLabDispatchers
) : UpdateUserUseCase {

    override fun invoke(user: User): Flow<User> = repository
        .updateUser(user)
        .map {
            User(
                id = it.id.orEmpty(),
                firstName = it.firstName.orEmpty(),
                lastName = it.lastName.orEmpty(),
                age = it.age ?: 0,
                avatar = it.avatar.orEmpty()
            )
        }
        .flowOn(dispatchers.io)
}