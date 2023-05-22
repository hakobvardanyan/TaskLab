package am.tasklab.data.user.di

import am.tasklab.data.user.api.UserLocalRepository
import am.tasklab.data.user.api.UserRemoteRepository
import am.tasklab.data.user.api.UserRepository
import am.tasklab.data.user.impl.UserLocalRepositoryImpl
import am.tasklab.data.user.impl.UserRemoteRepositoryImpl
import am.tasklab.data.user.impl.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataUserBindings {

    @Binds
    fun bindUserLocalRepository(
        implementation: UserLocalRepositoryImpl
    ): UserLocalRepository

    @Binds
    fun bindUserRemoteRepository(
        implementation: UserRemoteRepositoryImpl
    ): UserRemoteRepository

    @Binds
    fun bindUserRepository(
        implementation: UserRepositoryImpl
    ): UserRepository
}
