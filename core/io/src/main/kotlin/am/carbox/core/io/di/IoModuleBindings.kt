package am.carbox.core.io.di

import am.carbox.core.io.dispatchers.CarBoxDispatchers
import am.carbox.core.io.dispatchers.CarBoxDispatchersImpl
import am.carbox.core.io.preference.SensitivePreferencesService
import am.carbox.core.io.preference.SensitivePreferencesServiceImpl
import am.carbox.core.io.preference.SharedPreferencesService
import am.carbox.core.io.preference.SharedPreferencesServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface IoModuleBindings {

    @Binds
    @Singleton
    fun bindSensitivePreferences(
        implementation: SensitivePreferencesServiceImpl
    ): SensitivePreferencesService

    @Binds
    @Singleton
    fun bindSharedPreferences(
        implementation: SharedPreferencesServiceImpl
    ): SharedPreferencesService

    @Binds
    @Singleton
    fun bindDispatchers(
        implementation: CarBoxDispatchersImpl
    ): CarBoxDispatchers
}
