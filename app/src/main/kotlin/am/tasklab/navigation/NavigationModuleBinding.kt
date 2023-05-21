package am.tasklab.navigation

import am.tasklab.feature.auth.AuthRouter
import am.tasklab.feature.splash.SplashRouter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
interface NavigationModuleBinding {

    @Binds
    fun bindSplashRouter(implementation: SplashRouterImpl): SplashRouter

    @Binds
    fun bindAuthRouter(implementation: AuthRouterImpl): AuthRouter
}
