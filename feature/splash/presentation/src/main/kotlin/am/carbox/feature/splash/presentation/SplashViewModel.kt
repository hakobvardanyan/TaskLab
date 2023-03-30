package am.carbox.feature.splash.presentation

//import am.carbox.feature.splash.domain.TestUseCase
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
//    private val useCase: TestUseCase
) : ViewModel() {

    fun test() {
//        useCase.exec()
//            .onEach { Log.d("::::: ", "Success") }
//            .launchIn(viewModelScope)
    }
}