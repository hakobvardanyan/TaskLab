package am.tasklab.mapper.api

import am.tasklab.core.common.mapper.Mapper
import am.tasklab.entity.SignInCredentials
import am.tasklab.entity.SignInRequest

interface SignInCredentialsToSignInRequestMapper : Mapper<SignInCredentials, SignInRequest>
