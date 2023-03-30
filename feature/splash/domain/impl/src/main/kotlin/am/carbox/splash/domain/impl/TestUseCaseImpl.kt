package am.carbox.splash.domain.impl

import am.carbox.data.auth.AuthRepository
import am.carbox.splash.domain.api.TestUseCase
import android.util.Log
import javax.inject.Inject

class TestUseCaseImpl @Inject constructor(
    private val repo: AuthRepository
) : TestUseCase {
    override fun test() {
        Log.d(":::::::: ", "Fucking test called ${repo.isSignedIn}")
    }
}