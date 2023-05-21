package am.carbox.feature.splash.domain.impl

import com.tasklab.data.auth.api.AuthRepository
import com.tasklab.data.auth.model.AuthState
import am.carbox.feature.splash.domain.api.TestUseCase
import android.app.Activity
import android.util.Log
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class TestUseCaseImpl @Inject constructor(
    private val repo: AuthRepository
) : TestUseCase {
    override fun test(activity: Activity): Flow<AuthState> {
        return repo.startVerification(activity, "+37493878776")
    }
}
