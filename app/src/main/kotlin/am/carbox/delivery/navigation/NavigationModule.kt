package am.carbox.delivery.navigation

import am.carbox.delivery.CarBoxActivity
import am.carbox.delivery.R
import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.findNavController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(FragmentComponent::class)
object NavigationModule {

    @Provides
    fun provideNavController(
        @ActivityContext
        context: Context,
    ): NavController {
        return (context as CarBoxActivity).findNavController(R.id.fragment_container)
    }
}
