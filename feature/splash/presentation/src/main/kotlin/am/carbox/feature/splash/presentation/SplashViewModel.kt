package am.carbox.feature.splash.presentation

import am.carbox.feature.splash.domain.api.TestUseCase
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCase: TestUseCase
) : ViewModel() {

    fun test() {
        useCase.test()
    }
}
