package am.carbox.feature.splash.domain

import am.carbox.data.auth.model.SignInApiDto

class TestUseCase {

    fun exec(): SignInApiDto {
        return SignInApiDto()
    }
}