package am.carbox.core.network.di

import am.carbox.core.network.parser.BaseResponseParser
import am.carbox.core.network.parser.BaseResponseParserImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface NetworkModuleBindings {

    @Binds
    @Singleton
    fun bindResponseParser(
        implementation: BaseResponseParserImpl
    ): BaseResponseParser
}
