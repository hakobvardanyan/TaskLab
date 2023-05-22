package com.tasklab.data.auth.impl

import com.tasklab.data.auth.api.AuthLocalRepository
import com.tasklab.data.auth.api.AuthRemoteRepository
import com.tasklab.data.auth.api.AuthRepository
import com.tasklab.data.auth.model.AuthState
import android.app.Activity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class AuthRepositoryImpl @Inject constructor(
    private val authLocalRepository: AuthLocalRepository,
    private val authRemoteRepository: AuthRemoteRepository,
) : AuthRepository {

    override val isSignedIn: Flow<Boolean>
        get() = authLocalRepository.isSignedIn

    override val verificationId: Flow<String>
        get() = flowOf("")

    override val firebaseUserId: Flow<String>
        get() = flowOf("")

    override val isFirebaseTokenExists: Flow<Boolean>
        get() = flowOf(false)

    override fun signIn(): Flow<Boolean> = flow {

    }

    override fun signOut(): Flow<Boolean> = flow {

    }

    override fun getFirebaseIdToken(): Flow<String> = flow {

    }

    override fun consumeFirebasePushToken(): Flow<String>  = flow {

    }

    override fun startVerification(activity: Activity, phoneNumber: String): Flow<AuthState> {
        return authRemoteRepository.startVerification(activity, phoneNumber)
    }

    override fun resendVerification(phoneNumber: String): Flow<AuthState> = flow {

    }

    override fun verifyVerificationCode(verificationId: String, smsCode: String): Flow<AuthState> = flow {

    }
}
