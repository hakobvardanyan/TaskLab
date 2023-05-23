package am.tasklab.auth.di

import am.tasklab.auth.api.CheckSignedInUseCase
import am.tasklab.auth.api.ConsumePushTokenUseCase
import am.tasklab.auth.api.SignInUseCase
import am.tasklab.auth.api.SignOutUseCase
import am.tasklab.auth.impl.CheckSignedInUseCaseImpl
import am.tasklab.auth.impl.ConsumePushTokenUseCaseImpl
import am.tasklab.auth.impl.SignInUseCaseImpl
import am.tasklab.auth.impl.SignOutUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal interface AuthDomainModuleBindings {

    @Binds
    fun bindCheckSignedInUseCase(
        implementation: CheckSignedInUseCaseImpl
    ): CheckSignedInUseCase

    @Binds
    fun bindConsumePushTokenUseCase(
        implementation: ConsumePushTokenUseCaseImpl
    ): ConsumePushTokenUseCase

    @Binds
    fun bindSignInUseCase(
        implementation: SignInUseCaseImpl
    ): SignInUseCase

    @Binds
    fun bindSignOutUseCase(
        implementation: SignOutUseCaseImpl
    ): SignOutUseCase
}
