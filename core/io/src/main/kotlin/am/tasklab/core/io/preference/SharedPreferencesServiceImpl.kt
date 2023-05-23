package am.tasklab.core.io.preference

import am.tasklab.core.io.di.SharedPreferences
import am.tasklab.extensions.orFalse
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class SharedPreferencesServiceImpl @Inject constructor(
    @SharedPreferences
    private val dataStore: DataStore<Preferences>
) : SharedPreferencesService {

    override suspend fun getAge(): Int = dataStore.data.map { preferences ->
        preferences[KEY_AGE] ?: 0
    }.first()

    override suspend fun getLastName(): String = dataStore.data.map { preferences ->
        preferences[KEY_LAST_NAME].orEmpty()
    }.first()

    override suspend fun getFirstName(): String = dataStore.data.map { preferences ->
        preferences[KEY_FIRST_NAME].orEmpty()
    }.first()

    override suspend fun hasUserInteractedWithOnBoarding(): Boolean = dataStore.data.map { preferences ->
        preferences[KEY_ON_BOARDING_INTERACTION].orFalse()
    }.first()

    override suspend fun updateUserDetails(firstName: String, lastName: String, age: Int) {
        dataStore.edit { preferences ->
            preferences[KEY_AGE] = age
            preferences[KEY_LAST_NAME] = lastName
            preferences[KEY_FIRST_NAME] = firstName
        }
    }

    override suspend fun clear() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    private companion object {
        val KEY_AGE = intPreferencesKey("key.age")
        val KEY_LAST_NAME = stringPreferencesKey("key.last_name")
        val KEY_FIRST_NAME = stringPreferencesKey("key.first_name")
        val KEY_ON_BOARDING_INTERACTION = booleanPreferencesKey("key.on_boarding_interaction")
    }
}
