package com.tasklab.data.auth.di

import com.tasklab.data.auth.api.AuthLocalRepository
import com.tasklab.data.auth.api.AuthRemoteRepository
import com.tasklab.data.auth.api.AuthRepository
import com.tasklab.data.auth.impl.AuthLocalRepositoryImpl
import com.tasklab.data.auth.impl.AuthRemoteRepositoryImpl
import com.tasklab.data.auth.impl.AuthRepositoryImpl
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
