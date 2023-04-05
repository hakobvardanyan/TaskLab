package am.carbox.delivery.navigation

import am.carbox.feature.auth.AuthRouter
import androidx.navigation.NavController
import javax.inject.Inject

class AuthRouterImpl @Inject constructor(
    private val navController: NavController,
) : AuthRouter {

    override fun navigateToHome() {
        navController.context
    }
}
