package am.tasklab.data.user.impl

import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import am.tasklab.data.user.api.UserLocalRepository
import am.tasklab.data.user.api.UserRemoteRepository
import am.tasklab.data.user.api.UserRepository
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val dispatchers: TaskLabDispatchers,
    private val userLocalRepository: UserLocalRepository,
    private val userRemoteRepository: UserRemoteRepository
) : UserRepository
