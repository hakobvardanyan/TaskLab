package am.tasklab.navigation

import am.tasklab.R
import am.tasklab.feature.splash.SplashRouter
import androidx.navigation.NavController
import javax.inject.Inject

class SplashRouterImpl @Inject constructor(
    private val navController: NavController
) : SplashRouter {

    override fun navigateToAuth() {
        navController.navigate(R.id.action_splashFragment_to_loginFragment)
    }

    override fun navigateToHome() {
        navController.navigate(R.id.action_splashFragment_to_loginFragment)
    }

    override fun navigateToOnBoarding() {
        navController.navigate(R.id.action_splashFragment_to_loginFragment)
    }
}
