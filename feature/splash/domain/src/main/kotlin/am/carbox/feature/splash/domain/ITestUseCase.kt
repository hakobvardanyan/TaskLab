package am.carbox.feature.splash.domain

import kotlinx.coroutines.flow.Flow

interface ITestUseCase {
    fun exec(): Flow<Boolean>
}