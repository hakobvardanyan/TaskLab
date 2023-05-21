package am.tasklab.core.network.di

import am.tasklab.core.network.parser.BaseResponseParser
import am.tasklab.core.network.parser.BaseResponseParserImpl
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
