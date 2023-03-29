package am.carbox.feature.splash.domain

import am.carbox.data.auth.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TestUseCase @Inject constructor(
    private val repo: AuthRepository,
) : ITestUseCase {

    override fun exec(): Flow<Boolean> {
        return repo.isSignedIn
    }
}