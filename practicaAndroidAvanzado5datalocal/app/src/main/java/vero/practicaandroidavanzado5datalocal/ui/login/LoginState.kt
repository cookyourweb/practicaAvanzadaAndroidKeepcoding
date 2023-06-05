package vero.practicaandroidavanzado5datalocal.ui.login

sealed class LoginState {
    object Success : LoginState()
    object Failure : LoginState()
}
