package am.tasklab.mapper.di

import am.tasklab.mapper.api.UserResponseToUserMapper
import am.tasklab.mapper.api.UserToUserRequestMapper
import am.tasklab.mapper.impl.UserResponseToUserMapperImpl
import am.tasklab.mapper.impl.UserToUserRequestMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal interface MapperModuleBindings {

    @Binds
    fun bindUserResponseToUserMapper(
        implementation: UserResponseToUserMapperImpl
    ): UserResponseToUserMapper

    @Binds
    fun bindUserToUserRequestMapper(
        implementation: UserToUserRequestMapperImpl
    ): UserToUserRequestMapper
}
