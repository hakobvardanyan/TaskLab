package am.tasklab.mapper.impl

import am.tasklab.entity.User
import am.tasklab.entity.UserRequest
import am.tasklab.mapper.api.UserToUserRequestMapper
import javax.inject.Inject

internal class UserToUserRequestMapperImpl @Inject constructor() : UserToUserRequestMapper {
    override fun map(from: User): UserRequest = UserRequest(
        id = from.id,
        firstName = from.firstName,
        lastName = from.lastName,
        age = from.age
    )
}
