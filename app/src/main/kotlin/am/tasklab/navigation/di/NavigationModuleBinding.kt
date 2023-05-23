package am.tasklab.navigation.di

import am.tasklab.feature.auth.AuthRouter
import am.tasklab.feature.onboarding.OnBoardingRouter
import am.tasklab.feature.splash.SplashRouter
import am.tasklab.navigation.router.AuthRouterImpl
import am.tasklab.navigation.router.OnBoardingRouterImpl
import am.tasklab.navigation.router.SplashRouterImpl
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

    @Binds
    fun bindOnBoardingRouter(implementation: OnBoardingRouterImpl): OnBoardingRouter
}
