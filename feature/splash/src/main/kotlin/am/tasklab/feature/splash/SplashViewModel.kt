package am.tasklab.feature.splash

import am.tasklab.auth.api.CheckSignedInUseCase
import am.tasklab.core.common.logger.Logger
import am.tasklab.domain.user.api.CheckInteractedWithOnBoardingUseCase
import am.tasklab.domain.user.api.GetUserByIdUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val checkSignedInUseCase: CheckSignedInUseCase,
    private val checkInteractedWithOnBoardingUseCase: CheckInteractedWithOnBoardingUseCase
) : ViewModel() {

    private val _isSignedIn = MutableSharedFlow<Boolean>()
    val isSignedIn = _isSignedIn.asSharedFlow()

    private val _isPassedOnBoarding = MutableSharedFlow<Boolean>()
    val isPassedOnBoarding = _isSignedIn.asSharedFlow()

    fun checkIsSignedIn() {
        checkSignedInUseCase()
            .onEach { _isSignedIn.emit(it) }
            .catch { _isSignedIn.emit(false) }
            .launchIn(viewModelScope)
    }

    fun checkOnBoardingInteraction() {
        checkInteractedWithOnBoardingUseCase()
            .onEach { _isPassedOnBoarding.emit(it) }
            .catch { _isPassedOnBoarding.emit(false) }
            .launchIn(viewModelScope)
    }
}
