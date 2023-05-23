package am.tasklab.navigation.router

import am.tasklab.R
import am.tasklab.feature.onboarding.OnBoardingRouter
import androidx.navigation.NavController
import javax.inject.Inject

class OnBoardingRouterImpl @Inject constructor(
    private val navController: NavController
) : OnBoardingRouter {

    override fun navigateToAuth() {
        navController.navigate(R.id.action_splashFragment_to_loginFragment)
    }
}