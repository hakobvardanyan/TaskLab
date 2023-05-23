package am.tasklab.mapper.impl

import am.tasklab.entity.User
import am.tasklab.entity.UserResponse
import am.tasklab.mapper.api.UserResponseToUserMapper
import javax.inject.Inject

internal class UserResponseToUserMapperImpl @Inject constructor() : UserResponseToUserMapper {

    override fun map(from: UserResponse): User = User(
        id = from.id.orEmpty(),
        firstName = from.firstName.orEmpty(),
        lastName = from.lastName.orEmpty(),
        age = from.age ?: 0,
        avatar = from.avatar.orEmpty()
    )
}
