package am.tasklab.core.io.preference

import am.tasklab.core.io.di.SensitivePreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class SensitivePreferencesServiceImpl @Inject constructor(
    @SensitivePreferences
    private val dataStore: DataStore<Preferences>
) : SensitivePreferencesService {

    override val authToken: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_AUTH_TOKEN].orEmpty()
        }

    override val pushToken: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_PUSH_TOKEN].orEmpty()
        }

    override val firebaseUserId: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_FIREBASE_USER_ID].orEmpty()
        }

    override val regenerateToken: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_REGENERATE_TOKEN].orEmpty()
        }

    override val firebaseIdToken: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_FIREBASE_ID_TOKEN].orEmpty()
        }

    override val firebaseVerificationId: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_FIREBASE_VERIFICATION_ID].orEmpty()
        }

    override val firebaseUserPhoneNumber: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_FIREBASE_USER_PHONE_NUMBER].orEmpty()
        }

    override suspend fun updateAuthToken(token: String) {
        dataStore.edit { preferences ->
            preferences[KEY_AUTH_TOKEN] = token
        }
    }

    override suspend fun updatePushToken(token: String) {
        dataStore.edit { preferences ->
            preferences[KEY_PUSH_TOKEN] = token
        }
    }

    override suspend fun updateFirebaseUserId(id: String) {
        dataStore.edit { preferences ->
            preferences[KEY_FIREBASE_USER_ID] = id
        }
    }

    override suspend fun updateRegenerateToken(token: String) {
        dataStore.edit { preferences ->
            preferences[KEY_REGENERATE_TOKEN] = token
        }
    }

    override suspend fun updateFirebaseIdToken(token: String) {
        dataStore.edit { preferences ->
            preferences[KEY_FIREBASE_ID_TOKEN] = token
        }
    }

    override suspend fun updateFirebaseVerificationId(id: String) {
        dataStore.edit { preferences ->
            preferences[KEY_FIREBASE_VERIFICATION_ID] = id
        }
    }

    override suspend fun updateFirebaseUserPhoneNumber(number: String) {
        dataStore.edit { preferences ->
            preferences[KEY_FIREBASE_USER_PHONE_NUMBER] = number
        }
    }

    override suspend fun clear() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    private companion object {
        val KEY_AUTH_TOKEN = stringPreferencesKey("key.auth_token")
        val KEY_PUSH_TOKEN = stringPreferencesKey("key.push_token")
        val KEY_FIREBASE_USER_ID = stringPreferencesKey("key.firebase_user_id")
        val KEY_REGENERATE_TOKEN = stringPreferencesKey("key.regenerate_token")
        val KEY_FIREBASE_ID_TOKEN = stringPreferencesKey("key.firebase_id_token")
        val KEY_FIREBASE_VERIFICATION_ID = stringPreferencesKey("key.firebase_verification_id")
        val KEY_FIREBASE_USER_PHONE_NUMBER = stringPreferencesKey("key.firebase_user_phone_number")
    }
}
