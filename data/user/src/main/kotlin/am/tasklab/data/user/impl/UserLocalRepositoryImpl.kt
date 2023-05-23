package am.tasklab.data.user.impl

import am.tasklab.core.io.preference.SensitivePreferencesService
import am.tasklab.core.io.preference.SharedPreferencesService
import am.tasklab.data.user.api.UserLocalRepository
import am.tasklab.entity.UserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class UserLocalRepositoryImpl @Inject constructor(
    private val sharedPreferences: SharedPreferencesService,
    private val sensitivePreferences: SensitivePreferencesService
) : UserLocalRepository {

    override fun getMyUser(): Flow<UserResponse> = sensitivePreferences.userId
        .map { userId ->
            val firstName = sharedPreferences.getFirstName()
            val lastName = sharedPreferences.getLastName()
            val age = sharedPreferences.getAge()
            UserResponse(
                id = userId,
                firstName = firstName,
                lastName = lastName,
                age = age
            )
        }

    override suspend fun saveMyUser(user: UserResponse) {
        sharedPreferences.updateUserDetails(
            age = user.age ?: 0,
            lastName = user.lastName.orEmpty(),
            firstName = user.firstName.orEmpty()
        )
        sensitivePreferences.updateUserId(user.id.orEmpty())
    }

    override fun hasUserInteractedWithOnBoarding(): Flow<Boolean> = flow {
        emit(sharedPreferences.hasUserInteractedWithOnBoarding())
    }

    override fun getMyUserId(): Flow<String> = sensitivePreferences.userId
}
