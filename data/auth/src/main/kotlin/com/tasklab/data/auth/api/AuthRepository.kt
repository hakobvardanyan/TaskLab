package com.tasklab.data.auth.api

import com.tasklab.data.auth.model.AuthState
import android.app.Activity
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val isSignedIn: Flow<Boolean>
    val verificationId: Flow<String>
    val firebaseUserId: Flow<String>
    val isFirebaseTokenExists: Flow<Boolean>

    fun signIn(): Flow<Boolean>
    fun signOut(): Flow<Boolean>
    fun getFirebaseIdToken(): Flow<String>
    fun consumeFirebasePushToken(): Flow<String>
    fun startVerification(activity: Activity, phoneNumber: String): Flow<AuthState>
    fun resendVerification(phoneNumber: String): Flow<AuthState>
    fun verifyVerificationCode(verificationId: String, smsCode: String): Flow<AuthState>
}
