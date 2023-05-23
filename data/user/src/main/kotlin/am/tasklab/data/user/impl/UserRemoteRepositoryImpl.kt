package am.tasklab.data.user.impl

import am.tasklab.core.common.logger.Logger
import am.tasklab.core.network.model.BaseResponse
import am.tasklab.core.network.parser.BaseResponseParser
import am.tasklab.data.user.api.UserRemoteRepository
import am.tasklab.entity.UserRequest
import am.tasklab.data.user.service.UserApiService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.util.UUID
import javax.inject.Inject
import kotlin.random.Random

internal class UserRemoteRepositoryImpl @Inject constructor(
    private val userApiService: UserApiService,
    private val responseParser: BaseResponseParser
) : UserRemoteRepository {

    override fun getUserById(userId: String): Flow<am.tasklab.entity.UserResponse> = flow {
        Logger.debug("$TAG.getUserById() userId = $userId")
        delay(Random.nextLong(800))
        emit(mockedUserResponse())
//        emit(userApiService.getUserById(userId))
    }.map(responseParser::parse)

    override fun updateUser(user: UserRequest): Flow<am.tasklab.entity.UserResponse> = flow {
        Logger.debug("$TAG.updateUser() user = $user")
        delay(Random.nextLong(800))
        emit(mockedUserResponse())
//        emit(userApiService.updateUser(user))
    }.map(responseParser::parse)

    private fun mockedUserResponse() = BaseResponse(
        status = true,
        timestamp = System.currentTimeMillis(),
        data = am.tasklab.entity.UserResponse(
            id = UUID.randomUUID().toString(),
            firstName = "John",
            lastName = "Smith",
            age = 35,
            avatar = "link to avatar"
        )
    )

    private companion object {
        const val TAG = "UserRemoteRepositoryImpl"
    }
}
