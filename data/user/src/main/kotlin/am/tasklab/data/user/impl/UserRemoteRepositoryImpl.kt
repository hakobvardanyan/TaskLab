package am.tasklab.data.user.impl

import am.tasklab.core.network.parser.BaseResponseParser
import am.tasklab.data.user.api.UserRemoteRepository
import am.tasklab.data.user.service.UserApiService
import javax.inject.Inject

internal class UserRemoteRepositoryImpl @Inject constructor(
    private val userApiService: UserApiService,
    private val responseParser: BaseResponseParser
) : UserRemoteRepository