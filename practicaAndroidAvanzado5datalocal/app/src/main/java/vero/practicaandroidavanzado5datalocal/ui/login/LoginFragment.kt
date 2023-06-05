package vero.practicaandroidavanzado5datalocal.ui.login


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController


import dagger.hilt.android.AndroidEntryPoint
import vero.practicaandroidavanzado5datalocal.R
import vero.practicaandroidavanzado5datalocal.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            login.setOnClickListener {
                viewModel.login(email.text.toString(), password.text.toString())
            }
        }


        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is LoginState.Failure -> {
                    Toast.makeText(requireContext(), R.string.error_login, Toast.LENGTH_LONG)
                        .show()
                }
                is LoginState.Success -> {
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSuperHeroListFragment())
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
