package am.tasklab.navigation.router

import am.tasklab.feature.auth.AuthRouter
import androidx.navigation.NavController
import javax.inject.Inject

class AuthRouterImpl @Inject constructor(
    private val navController: NavController
) : AuthRouter {

    override fun navigateToHome() {
        navController.context
    }
}
