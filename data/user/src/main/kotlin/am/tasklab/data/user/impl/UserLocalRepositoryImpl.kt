package am.tasklab.data.user.impl

import am.tasklab.core.io.preference.SensitivePreferencesService
import am.tasklab.data.user.api.UserLocalRepository
import javax.inject.Inject

internal class UserLocalRepositoryImpl @Inject constructor(
    private val sharedPreferences: SensitivePreferencesService,
    private val sensitivePreferences: SensitivePreferencesService
) : UserLocalRepository