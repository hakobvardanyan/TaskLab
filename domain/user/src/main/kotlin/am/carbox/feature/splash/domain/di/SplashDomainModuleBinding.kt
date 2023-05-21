package am.carbox.feature.splash.domain.di

import am.carbox.feature.splash.domain.api.TestUseCase
import am.carbox.feature.splash.domain.impl.TestUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal interface SplashDomainModuleBinding {

    @Binds
    fun bindTestUseCase(
        useCaseImpl: TestUseCaseImpl,
    ): TestUseCase
}