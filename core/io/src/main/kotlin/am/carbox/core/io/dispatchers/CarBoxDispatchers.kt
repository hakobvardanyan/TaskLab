package am.carbox.core.io.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface CarBoxDispatchers {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
    val mainImmediate: CoroutineDispatcher
}
