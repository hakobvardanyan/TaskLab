package am.carbox.data.auth.di

import am.carbox.data.auth.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataAuthModuleBinding {

    @Binds
    abstract fun bindAuthRepository(
        repository: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    abstract fun bindAuthLocalRepository(
        repository: AuthLocalRepositoryImpl
    ): AuthLocalRepository

    @Binds
    abstract fun bindAuthRemoteRepository(
        repository: AuthRemoteRepositoryImpl
    ): AuthRemoteRepository
}
