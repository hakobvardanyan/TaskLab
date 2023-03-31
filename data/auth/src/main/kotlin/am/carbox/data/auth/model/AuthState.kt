package am.carbox.data.auth.model

import com.google.firebase.auth.PhoneAuthProvider

sealed class AuthState {
    data class Timeout(val firebaseVerificationId: String,): AuthState()
    data class CodeSent(
        val firebaseVerificationId: String,
        val firebaseForceResendingToken: PhoneAuthProvider.ForceResendingToken
    ): AuthState()
    data class SignInCompleted(
        val firebaseUserId: String,
        val firebaseIdToken: String,
        val firebaseUserPhone: String
    ): AuthState()
    object VerificationCompleted: AuthState()
}
