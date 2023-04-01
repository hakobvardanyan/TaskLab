package am.carbox.core.io.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object IoModule {

    @Provides
    @Singleton
    @SensitivePreferences
    fun provideSensitivePreferencesDataStore(
        @ApplicationContext
        context: Context,
    ): DataStore<Preferences> {
        return createSataStore(context, NAME_SENSITIVE_PREFERENCES)
    }

    @Provides
    @Singleton
    @StandardPreferences
    fun provideStandardPreferencesDataStore(
        @ApplicationContext
        context: Context,
    ): DataStore<Preferences> {
        return createSataStore(context, NAME_SHARED_PREFERENCES)
    }

    private fun createSataStore(
        context: Context,
        name: String,
    ): DataStore<Preferences> = PreferenceDataStoreFactory.create {
        context.preferencesDataStoreFile(name)
    }

    private const val NAME_SHARED_PREFERENCES = "sshared_preferences_store"
    private const val NAME_SENSITIVE_PREFERENCES = "sensitive_preferences_store"
}
