package am.tasklab.feature.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

private typealias Router = dagger.Lazy<SplashRouter>

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val viewModel by viewModels<SplashViewModel>()

    @Inject
    lateinit var router: Router

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        startCollectingViewModelFlows()
        viewModel.checkIsSignedIn()
    }

    private fun startCollectingViewModelFlows() {
        viewModel.isSignedIn
            .flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach(::onSignedInCollect)
            .launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.isPassedOnBoarding
            .flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach(::onPassedOnBoardingCollect)
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun onPassedOnBoardingCollect(hasPassed: Boolean) {
        if (hasPassed) {
            router.get().navigateToAuth()
        } else {
            Toast.makeText(context, "Navigate To OnBoarding", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onSignedInCollect(isSignedIn: Boolean) {
        if (isSignedIn) {
            Toast.makeText(context, "Navigate To Home", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.checkOnBoardingInteraction()
        }
    }
}
