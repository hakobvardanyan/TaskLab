package am.tasklab.core.io.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class SensitivePreferences

@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class SharedPreferences
