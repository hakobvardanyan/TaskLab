package am.tasklab.mapper.impl

import am.tasklab.entity.SignInCredentials
import am.tasklab.entity.SignInRequest
import am.tasklab.mapper.api.SignInCredentialsToSignInRequestMapper
import javax.inject.Inject

internal class SignInCredentialsToSignInRequestMapperImpl @Inject constructor() : SignInCredentialsToSignInRequestMapper {

    override fun map(from: SignInCredentials): SignInRequest = SignInRequest(
        email = from.email,
        password = from.password
    )
}
