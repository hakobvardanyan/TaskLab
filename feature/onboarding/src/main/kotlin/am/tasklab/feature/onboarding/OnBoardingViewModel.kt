package am.tasklab.feature.onboarding

import am.tasklab.domain.user.api.UpdateInteractionWithOnBoardingUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val updateInteractionWithOnBoardingUseCase: UpdateInteractionWithOnBoardingUseCase
) : ViewModel() {

    private val _onBoardingFinished = MutableSharedFlow<Unit>()
    val onBoardingFinished = _onBoardingFinished.asSharedFlow()

    fun finishOnBoarding() {
        updateInteractionWithOnBoardingUseCase(true)
            .onEach(_onBoardingFinished::emit)
            .launchIn(viewModelScope)
    }
}
