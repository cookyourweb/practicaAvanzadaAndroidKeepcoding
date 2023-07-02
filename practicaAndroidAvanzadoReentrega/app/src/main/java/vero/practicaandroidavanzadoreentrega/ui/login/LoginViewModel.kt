package vero.practicaandroidavanzadoreentrega.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import vero.practicaandroidavanzadoreentrega.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    companion object {
        private val TAG = "LoginViewModel: "
    }

    private val _state = MutableLiveData<LoginState>()
    val state: LiveData<LoginState>
        get() = _state

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val boolean = withContext(Dispatchers.IO) {
                repository.login(email, password)
            }
            if (boolean) {
                _state.value = LoginState.Success
            } else {
                _state.value = LoginState.Failure
            }
        }
    }
}
