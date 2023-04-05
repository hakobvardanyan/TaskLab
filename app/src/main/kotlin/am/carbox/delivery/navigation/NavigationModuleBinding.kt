package am.carbox.delivery.navigation

import am.carbox.feature.auth.AuthRouter
import am.carbox.feature.splash.SplashRouter
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
