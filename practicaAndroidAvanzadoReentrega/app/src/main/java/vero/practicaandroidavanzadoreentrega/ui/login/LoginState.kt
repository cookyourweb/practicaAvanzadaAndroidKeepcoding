package vero.practicaandroidavanzadoreentrega.ui.login

sealed class LoginState {
    object Success : LoginState()
    object Failure : LoginState()
}
