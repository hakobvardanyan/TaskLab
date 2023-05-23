package am.tasklab.domain.user.di

import am.tasklab.domain.user.api.CheckInteractedWithOnBoardingUseCase
import am.tasklab.domain.user.api.GetMyUserIdUseCase
import am.tasklab.domain.user.api.GetMyUserUseCase
import am.tasklab.domain.user.api.GetUserByIdUseCase
import am.tasklab.domain.user.api.UpdateUserUseCase
import am.tasklab.domain.user.impl.CheckInteractedWithOnBoardingUseCaseImpl
import am.tasklab.domain.user.impl.GetMyUserIdUseCaseImpl
import am.tasklab.domain.user.impl.GetMyUserUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import am.tasklab.domain.user.impl.GetUserByIdUseCaseImpl
import am.tasklab.domain.user.impl.UpdateUserUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
internal interface UserDomainModuleBinding {

    @Binds
    fun bindGetUserByIdUseCase(
        implementation: GetUserByIdUseCaseImpl
    ): GetUserByIdUseCase

    @Binds
    fun bindGetMyUserUseCase(
        implementation: GetMyUserUseCaseImpl
    ): GetMyUserUseCase

    @Binds
    fun bindUpdateUserUseCase(
        implementation: UpdateUserUseCaseImpl
    ): UpdateUserUseCase

    @Binds
    fun bindGetMyUserIdUseCase(
        implementation: GetMyUserIdUseCaseImpl
    ): GetMyUserIdUseCase

    @Binds
    fun bindCheckInteractedWithOnBoardingUseCase(
        implementation: CheckInteractedWithOnBoardingUseCaseImpl
    ): CheckInteractedWithOnBoardingUseCase
}
