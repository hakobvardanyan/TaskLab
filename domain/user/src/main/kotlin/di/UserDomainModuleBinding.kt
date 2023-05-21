package di

import api.GetUserByIdUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import impl.GetUserByIdUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
internal interface UserDomainModuleBinding {

    @Binds
    fun bindGetUserByIdUseCase(
        implementation: GetUserByIdUseCaseImpl
    ): GetUserByIdUseCase
}
