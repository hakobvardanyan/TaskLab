package am.tasklab.core.io.preference

interface SharedPreferencesService {

    suspend fun getAge(): Int

    suspend fun getLastName(): String

    suspend fun getFirstName(): String

    suspend fun hasUserInteractedWithOnBoarding(): Boolean

    suspend fun updateUserDetails(firstName: String, lastName: String, age: Int)

    suspend fun clear()
}
