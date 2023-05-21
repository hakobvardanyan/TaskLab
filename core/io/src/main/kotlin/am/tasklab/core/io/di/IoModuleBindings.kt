package am.tasklab.core.io.di

import am.tasklab.core.io.dispatchers.TaskLabDispatchers
import am.tasklab.core.io.dispatchers.TaskLabDispatchersImpl
import am.tasklab.core.io.preference.SensitivePreferencesService
import am.tasklab.core.io.preference.SensitivePreferencesServiceImpl
import am.tasklab.core.io.preference.SharedPreferencesService
import am.tasklab.core.io.preference.SharedPreferencesServiceImpl
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
        implementation: TaskLabDispatchersImpl
    ): TaskLabDispatchers
}
