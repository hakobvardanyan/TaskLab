package am.tasklab.auth.api

import kotlinx.coroutines.flow.Flow

interface ConsumePushTokenUseCase {

    operator fun invoke(): Flow<String>
}
