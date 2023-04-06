package com.tasklab.data.auth.impl

import com.tasklab.data.auth.api.AuthLocalRepository
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class AuthLocalRepositoryImpl @Inject constructor() : AuthLocalRepository {

    override val isSignedIn: Flow<Boolean>
        get() = flowOf(true)

    override val firebaseUserId: Flow<String>
        get() = TODO("Not yet implemented")

    override val firebaseIdToken: Flow<String>
        get() = TODO("Not yet implemented")

    override val firebaseUserPhone: Flow<String>
        get() = TODO("Not yet implemented")

    override val isFirebaseTokenExists: Flow<Boolean>
        get() = TODO("Not yet implemented")

    override val firebaseVerificationId: Flow<String>
        get() = TODO("Not yet implemented")

    override val firebaseForceResendingToken: Flow<PhoneAuthProvider.ForceResendingToken?>
        get() = TODO("Not yet implemented")

    override fun removeUserSensitiveData(): Flow<Unit> {
        TODO("Not yet implemented")
    }

    override fun cacheUserSensitiveData(
        authToken: String?,
        regenerateToken: String?,
        firebaseUserId: String?,
        firebaseIdToken: String?,
        firebaseUserPhone: String?,
        firebaseVerificationId: String?,
        firebaseForceResendingToken: PhoneAuthProvider.ForceResendingToken?,
    ): Flow<Unit> {
        TODO("Not yet implemented")
    }
}
