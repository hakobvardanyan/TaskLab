package am.carbox.splash.domain

import am.carbox.data.auth.AuthRepository
import android.util.Log
import javax.inject.Inject

internal class TestUseCaseImpl @Inject constructor(
    private val repo: AuthRepository
) : TestUseCase {
    override fun test() {
        Log.d(":::::::: ", "Fucking test called ${repo.isSignedIn}")
    }
}
