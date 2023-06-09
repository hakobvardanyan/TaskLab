package am.tasklab.feature.auth

import am.tasklab.feature.auth.presentation.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private typealias Router = dagger.Lazy<AuthRouter>

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel by viewModels<LoginViewModel>()

    @Inject
    lateinit var router: Router

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        viewModel.hashCode()
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
}
