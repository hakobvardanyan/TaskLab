package am.carbox.feature.splash.presentation

import am.carbox.feature.splash.domain.api.TestUseCase
import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCase: TestUseCase
) : ViewModel() {

    fun test(activity: Activity) {
//        useCase.test(activity).launchIn(viewModelScope)
    }
}
