package am.carbox.data.auth.di

import am.carbox.data.auth.*
import am.carbox.data.auth.impl.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataAuthModuleBinding {

    @Binds
    fun bindAuthRepository(
        repository: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    fun bindAuthLocalRepository(
        repository: AuthLocalRepositoryImpl
    ): AuthLocalRepository

    @Binds
    fun bindAuthRemoteRepository(
        repository: AuthRemoteRepositoryImpl
    ): AuthRemoteRepository
}
