package am.carbox.feature.splash.domain.impl

import am.carbox.data.auth.api.AuthRepository
import am.carbox.feature.splash.domain.api.TestUseCase
import android.util.Log
import javax.inject.Inject

internal class TestUseCaseImpl @Inject constructor(
    private val repo: AuthRepository
) : TestUseCase {
    override fun test() {
        Log.d(":::::::: ", "Fucking test called ${repo.isSignedIn}")
    }
}
