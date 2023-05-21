package am.tasklab.domain.user.di

import am.tasklab.domain.user.api.GetUserByIdUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import am.tasklab.domain.user.impl.GetUserByIdUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
internal interface UserDomainModuleBinding {

    @Binds
    fun bindGetUserByIdUseCase(
        implementation: GetUserByIdUseCaseImpl
    ): GetUserByIdUseCase
}
