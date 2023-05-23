package am.tasklab.feature.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private typealias Router = dagger.Lazy<OnBoardingRouter>

@AndroidEntryPoint
class OnBoardingFragment : Fragment(R.layout.fragment_on_boarding) {

    private val viewModel by viewModels<OnBoardingViewModel>()

    @Inject
    lateinit var router: Router

}
