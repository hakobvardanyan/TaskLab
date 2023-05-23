package am.tasklab.mapper.api

import am.tasklab.core.common.mapper.Mapper
import am.tasklab.entity.User
import am.tasklab.entity.UserResponse

interface UserResponseToUserMapper : Mapper<UserResponse, User>
