package com.tasklab.data.auth.impl

import com.tasklab.data.auth.api.AuthLocalRepository
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class AuthLocalRepositoryImpl @Inject constructor() : AuthLocalRepository {

    override val isSignedIn: Flow<Boolean>
        get() = flowOf(true)

    override val firebaseUserId: Flow<String>
        get() = flowOf("")

    override val firebaseIdToken: Flow<String>
        get() = flowOf("")

    override val firebaseUserPhone: Flow<String>
        get() = flowOf("")

    override val isFirebaseTokenExists: Flow<Boolean>
        get() = flowOf(false)

    override val firebaseVerificationId: Flow<String>
        get() = flowOf("")

    override val firebaseForceResendingToken: Flow<PhoneAuthProvider.ForceResendingToken?>
        get() = flow {  }

    override fun removeUserSensitiveData(): Flow<Unit> = flow {

    }

    override fun cacheUserSensitiveData(
        authToken: String?,
        regenerateToken: String?,
        firebaseUserId: String?,
        firebaseIdToken: String?,
        firebaseUserPhone: String?,
        firebaseVerificationId: String?,
        firebaseForceResendingToken: PhoneAuthProvider.ForceResendingToken?,
    ): Flow<Unit> = flow {

    }
}
