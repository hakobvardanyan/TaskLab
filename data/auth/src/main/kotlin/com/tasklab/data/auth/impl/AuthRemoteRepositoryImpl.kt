package com.tasklab.data.auth.impl

import am.carbox.core.common.logger.Logger
import am.carbox.core.network.parser.BaseResponseParser
import com.tasklab.data.auth.api.AuthRemoteRepository
import com.tasklab.data.auth.model.AuthState
import com.tasklab.data.auth.model.SignInRequest
import com.tasklab.data.auth.model.SignInResponse
import com.tasklab.data.auth.service.AuthApiService
import android.app.Activity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class AuthRemoteRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val authApiService: AuthApiService,
    private val responseParser: BaseResponseParser,
    private val firebaseMessaging: FirebaseMessaging,
) : AuthRemoteRepository {

    override fun signIn(body: SignInRequest): Flow<SignInResponse> = flow {
        Logger.debug("$TAG.signIn() body = $body")
        emit(authApiService.signIn(body))
    }.map(responseParser::parse)

    override fun signOut(): Flow<Boolean> = flow {
        Logger.debug("$TAG.signOut()")
        firebaseAuth.signOut()
        emit(authApiService.signOut().status)
    }.catch {
        emit(false)
    }

    override fun getFirebaseIdToken(): Flow<String> = callbackFlow {
        Logger.debug("$TAG.getFirebaseIdToken()")
        firebaseAuth.currentUser?.let { user ->
            user.getIdToken(true)
                .addOnSuccessListener { trySend(it.token.orEmpty()) }
                .addOnFailureListener { close(it) }
        } ?: trySend("")
        awaitClose { Logger.warning("$TAG.getFirebaseIdToken() scope has closed") }
    }

    override fun consumeFirebasePushToken(): Flow<String> = callbackFlow {
        Logger.debug("$TAG.consumeFirebasePushToken()")
        firebaseMessaging.token.addOnSuccessListener { result ->
            result?.let { trySend(it) }
        }.addOnFailureListener {
            close(it)
        }
        awaitClose { Logger.warning("$TAG.consumeFirebasePushToken() producer scope has closed") }
    }

    override fun startVerification(
        activity: Activity,
        phone: String,
    ): Flow<AuthState> = callbackFlow {
        Logger.debug("$TAG.startVerification()")
        val options = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(phone)
            .setTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .setActivity(activity)
            .setCallbacks(createCallback(this))
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
        awaitClose { Logger.warning("$TAG.startVerification() producer scope has closed") }
    }

    override fun resendVerification(
        activity: Activity,
        phone: String,
        resendToken: PhoneAuthProvider.ForceResendingToken?,
    ): Flow<AuthState> = callbackFlow {
        Logger.debug("$TAG.resendVerification()")
        resendToken?.let { resendToken ->
            val options = PhoneAuthOptions.newBuilder(firebaseAuth)
                .setPhoneNumber(phone)
                .setTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .setActivity(activity)
                .setCallbacks(createCallback(this))
                .setForceResendingToken(resendToken)
                .build()
            PhoneAuthProvider.verifyPhoneNumber(options)
        }
        awaitClose { Logger.warning("$TAG.resendVerification() producer scope has closed") }
    }

    override fun verifyVerificationCode(
        verificationId: String,
        smsCode: String,
    ): Flow<AuthState> = callbackFlow {
        Logger.debug("$TAG.verifyVerificationCode() verificationId = $verificationId smsCode = $smsCode")
        val credential = PhoneAuthProvider.getCredential(verificationId, smsCode)
        firebaseAuth.signInWithCredential(credential)
            .addOnSuccessListener {
                val userId = it?.user?.uid.orEmpty()
                val userPhone = it?.user?.phoneNumber.orEmpty()
                getFirebaseIdToken(userId, userPhone, this)
            }
            .addOnFailureListener { close(it) }
        awaitClose {
            Logger.warning("$TAG.verifyVerificationCode() producer scope has closed")
        }
    }

    private fun createCallback(
        scope: ProducerScope<AuthState>,
    ) = object : OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
            Logger.debug("$TAG.onVerificationCompleted()")
            scope.trySend(AuthState.VerificationCompleted)
            firebaseAuth.signInWithCredential(phoneAuthCredential)
                .addOnSuccessListener {
                    val userId = it?.user?.uid.orEmpty()
                    val userPhone = it?.user?.phoneNumber.orEmpty()
                    getFirebaseIdToken(userId, userPhone, scope)
                }
                .addOnFailureListener { scope.close(it) }
        }

        override fun onVerificationFailed(exception: FirebaseException) {
            Logger.exception(exception, "$TAG.onVerificationFailed()")
            scope.close(exception)
        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken,
        ) {
            super.onCodeSent(verificationId, token)
            Logger.debug("$TAG.onCodeSent() verificationId = $verificationId token = $token")
            scope.trySend(AuthState.CodeSent(verificationId, token))
        }

        override fun onCodeAutoRetrievalTimeOut(verificationId: String) {
            super.onCodeAutoRetrievalTimeOut(verificationId)
            Logger.debug("$TAG.onCodeAutoRetrievalTimeOut() verificationId = $verificationId")
            scope.trySend(AuthState.Timeout(verificationId))
        }
    }

    private fun getFirebaseIdToken(
        userId: String,
        userPhone: String,
        scope: ProducerScope<AuthState>,
    ) {
        Logger.debug("$TAG.getFirebaseIdToken() userId = $userId userPhone = $userPhone")
        firebaseAuth.currentUser?.getIdToken(true)?.addOnCompleteListener {
            scope.trySend(AuthState.SignInCompleted(userId, it.result?.token.orEmpty(), userPhone))
        }
    }

    private companion object {
        const val TIMEOUT_SECONDS = 60L
        const val TAG = "AuthRemoteRepositoryImpl"
    }
}