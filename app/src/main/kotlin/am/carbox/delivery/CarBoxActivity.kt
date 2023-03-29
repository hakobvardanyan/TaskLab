package am.carbox.delivery

import am.carbox.feature.splash.presentation.SplashFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CarBoxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SplashFragment::class.java, null)
                .commit()
        }
    }
}
