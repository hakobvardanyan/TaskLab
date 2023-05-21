package am.tasklab.core.io.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface TaskLabDispatchers {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
    val mainImmediate: CoroutineDispatcher
}
