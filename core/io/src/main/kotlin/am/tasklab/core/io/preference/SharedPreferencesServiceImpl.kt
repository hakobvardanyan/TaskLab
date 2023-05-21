package am.tasklab.core.io.preference

import am.tasklab.core.io.di.SharedPreferences
import am.tasklab.extensions.orFalse
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class SharedPreferencesServiceImpl @Inject constructor(
    @SharedPreferences
    private val dataStore: DataStore<Preferences>
) : SharedPreferencesService {

    override val hasUserInteractedWithOnBoarding: Flow<Boolean>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_ON_BOARDING_INTERACTION].orFalse()
        }

    override val phoneNumber: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_PHONE_NUMBER].orEmpty()
        }

    override val phoneFormatType: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_PHONE_FORMAT_TYPE].orEmpty()
        }

    override val phoneCountryCode: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_PHONE_COUNTRY_CODE].orEmpty()
        }

    override val firebaseForceResendingToken: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_FORCE_RESENDING_TOKEN].orEmpty()
        }

    override val hasUserInteractedWithCarOnBoarding: Flow<Boolean>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_CAR_ON_BOARDING_INTERACTION].orFalse()
        }

    override suspend fun updatePhoneFormatType(type: String) {
        dataStore.edit { preferences ->
            preferences[KEY_PHONE_FORMAT_TYPE] = type
        }
    }

    override suspend fun updatePhoneCountryCode(code: String) {
        dataStore.edit { preferences ->
            preferences[KEY_PHONE_COUNTRY_CODE] = code
        }
    }

    override suspend fun updatePhoneNumber(phoneNumber: String) {
        dataStore.edit { preferences ->
            preferences[KEY_PHONE_NUMBER] = phoneNumber
        }
    }

    override suspend fun updateFirebaseForceResendingToken(token: String) {
        dataStore.edit { preferences ->
            preferences[KEY_FORCE_RESENDING_TOKEN] = token
        }
    }

    override suspend fun updateInteractionWithOnBoarding(interacted: Boolean) {
        dataStore.edit { preferences ->
            preferences[KEY_ON_BOARDING_INTERACTION] = interacted
        }
    }

    override suspend fun updateInteractionWithCarOnBoarding(interacted: Boolean) {
        dataStore.edit { preferences ->
            preferences[KEY_CAR_ON_BOARDING_INTERACTION] = interacted
        }
    }

    override suspend fun clear() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    private companion object {
        val KEY_PHONE_NUMBER = stringPreferencesKey("key.phone_number")
        val KEY_PHONE_FORMAT_TYPE = stringPreferencesKey("key.phone_format_type")
        val KEY_PHONE_COUNTRY_CODE = stringPreferencesKey("key.phone_country_code")
        val KEY_FORCE_RESENDING_TOKEN = stringPreferencesKey("key.force_resending_token")
        val KEY_ON_BOARDING_INTERACTION = booleanPreferencesKey("key.on_boarding_interaction")
        val KEY_CAR_ON_BOARDING_INTERACTION = booleanPreferencesKey("key.car_on_boarding_interaction")
    }
}
