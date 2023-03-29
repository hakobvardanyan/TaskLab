package am.carbox.feature.splash.domain.di

import am.carbox.feature.splash.domain.ITestUseCase
import am.carbox.feature.splash.domain.TestUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
abstract class SplashDomainModule {

    @Binds
    abstract fun bindTestUseCase(useCase: TestUseCase): ITestUseCase
}
