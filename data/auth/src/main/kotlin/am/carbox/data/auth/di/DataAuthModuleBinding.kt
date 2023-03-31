package am.carbox.data.auth.di

import am.carbox.data.auth.*
import am.carbox.data.auth.api.AuthLocalRepository
import am.carbox.data.auth.api.AuthRemoteRepository
import am.carbox.data.auth.api.AuthRepository
import am.carbox.data.auth.impl.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataAuthModuleBinding {

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
