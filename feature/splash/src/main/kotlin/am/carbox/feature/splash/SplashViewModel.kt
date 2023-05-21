package am.carbox.feature.splash

import am.carbox.core.common.logger.Logger
import api.GetUserByIdUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCase: GetUserByIdUseCase
) : ViewModel() {

    fun test() {
        useCase("someId")
            .onEach { Logger.debug("Yeah!") }
            .launchIn(viewModelScope)
    }
}
