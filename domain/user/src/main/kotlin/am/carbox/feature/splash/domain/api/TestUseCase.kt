package am.carbox.feature.splash.domain.api

import com.tasklab.data.auth.model.AuthState
import android.app.Activity
import kotlinx.coroutines.flow.Flow

interface TestUseCase {

    fun test(activity: Activity): Flow<AuthState>
}