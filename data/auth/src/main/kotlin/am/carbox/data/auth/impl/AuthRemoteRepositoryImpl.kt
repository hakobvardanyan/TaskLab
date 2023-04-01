package am.carbox.data.auth.impl

import am.carbox.data.auth.api.AuthRemoteRepository
import am.carbox.data.auth.model.AuthState
import am.carbox.data.auth.model.SignInApiDto
import am.carbox.data.auth.model.SignInRequestDto
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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class AuthRemoteRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
//    private val authApiService: AuthApiService,
    private val firebaseMessaging: FirebaseMessaging
) : AuthRemoteRepository {

    override fun signIn(body: SignInRequestDto): Flow<SignInApiDto> = flow {
//        emit(authApiService.signIn(body))
//    }.flatMapMerge {
//        parseResponse(it)
    }

    override fun signOut(): Flow<Boolean> = flow {
//        firebaseAuth.signOut()
//        emit(authApiService.signOut().status)
//    }.catch {
//        emit(false)
    }

    override fun getFirebaseIdToken(): Flow<String> = callbackFlow {
        firebaseAuth.currentUser?.let { user ->
            user.getIdToken(true)
                .addOnSuccessListener { trySend(it.token.orEmpty()) }
                .addOnFailureListener { close(it) }
        } ?: trySend("")
        awaitClose {
//            Logger.warning("$tagName.getFirebaseIdToken() scope has closed")
        }
    }

    override fun consumeFirebasePushToken(): Flow<String> = callbackFlow {
        firebaseMessaging.token.addOnSuccessListener { result ->
            result?.let { trySend(it) }
        }.addOnFailureListener { close(it) }
        awaitClose {
//            Logger.warning("$tagName.consumeFirebasePushToken() producer scope has closed")
        }
    }

    override fun startVerification(
        activity: Activity,
        phone: String
    ): Flow<AuthState> = callbackFlow {
        val options = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(phone)
            .setTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .setActivity(activity)
            .setCallbacks(createCallback(this))
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
        awaitClose {
//            Logger.warning("$tagName.startVerification() producer scope has closed")
        }
    }

    override fun resendVerification(
        activity: Activity,
        phone: String,
        resendToken: PhoneAuthProvider.ForceResendingToken?
    ): Flow<AuthState> = callbackFlow {
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
        awaitClose {
//            Logger.warning("$tagName.resendVerification() producer scope has closed")
        }
    }

    override fun verifyVerificationCode(
        verificationId: String,
        smsCode: String
    ): Flow<AuthState> = callbackFlow {
        val credential = PhoneAuthProvider.getCredential(verificationId, smsCode)
        firebaseAuth.signInWithCredential(credential)
            .addOnSuccessListener {
                val userId = it?.user?.uid.orEmpty()
                val userPhone = it?.user?.phoneNumber.orEmpty()
                getFirebaseIdToken(userId, userPhone, this)
            }
            .addOnFailureListener { close(it) }
        awaitClose {
//            Logger.warning("$tagName.verifyVerificationCode() producer scope has closed")
        }
    }

    private fun createCallback(
        scope: ProducerScope<AuthState>
    ) = object : OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
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
            scope.close(exception)
        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken,
        ) {
            super.onCodeSent(verificationId, token)
            scope.trySend(AuthState.CodeSent(verificationId, token))
        }

        override fun onCodeAutoRetrievalTimeOut(verificationId: String) {
            super.onCodeAutoRetrievalTimeOut(verificationId)
            scope.trySend(AuthState.Timeout(verificationId))
        }
    }

    private fun getFirebaseIdToken(
        firebaseUserId: String,
        firebaseUserPhone: String,
        scope: ProducerScope<AuthState>
    ) {
        firebaseAuth.currentUser?.getIdToken(true)?.addOnCompleteListener {
            scope.trySend(
                AuthState.SignInCompleted(
                    firebaseUserId,
                    it.result?.token.orEmpty(),
                    firebaseUserPhone
                )
            )
        }
    }

    private companion object {
        const val TIMEOUT_SECONDS = 60L
        const val TAG = "AuthRemoteRepositoryImpl"
    }
}
