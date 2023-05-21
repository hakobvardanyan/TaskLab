package am.carbox.core.io.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

internal class CarBoxDispatchersImpl @Inject constructor() : CarBoxDispatchers {

    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

    override val main: CoroutineDispatcher
        get() = Dispatchers.Main

    override val default: CoroutineDispatcher
        get() = Dispatchers.Default

    override val mainImmediate: CoroutineDispatcher
        get() = Dispatchers.Main.immediate
}
