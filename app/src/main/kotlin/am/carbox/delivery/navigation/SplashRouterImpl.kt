package am.carbox.delivery.navigation

import am.carbox.delivery.R
import am.carbox.feature.splash.SplashRouter
import androidx.navigation.NavController
import javax.inject.Inject

class SplashRouterImpl @Inject constructor(
    private val navController: NavController,
) : SplashRouter {

    override fun navigateToLogin(someData: String) {
        navController.navigate(R.id.action_splashFragment_to_loginFragment)
    }
}
