package am.carbox.splash.domain.di

import am.carbox.splash.domain.api.TestUseCase
import am.carbox.splash.domain.impl.TestUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface SplashDomainModuleBinding {

    @Binds
    fun bindTestUseCase(
        useCaseImpl: TestUseCaseImpl,
    ): TestUseCase
}
