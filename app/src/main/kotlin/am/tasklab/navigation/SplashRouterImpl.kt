package am.tasklab.navigation

import am.tasklab.R
import am.tasklab.feature.splash.SplashRouter
import androidx.navigation.NavController
import javax.inject.Inject

class SplashRouterImpl @Inject constructor(
    private val navController: NavController,
) : SplashRouter {

    override fun navigateToLogin(someData: String) {
        navController.navigate(R.id.action_splashFragment_to_loginFragment)
    }
}
