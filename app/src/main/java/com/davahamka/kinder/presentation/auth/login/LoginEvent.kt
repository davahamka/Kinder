package com.davahamka.kinder.presentation.auth.login


sealed class LoginEvent {
    data class OnChangeEmail(val email: String) : LoginEvent()
    data class OnChangePassword(val password: String) : LoginEvent()
    data class NavigateToRegister(val cb: () -> Unit): LoginEvent()
    data class OnSubmitLogin(val cb: () -> Unit): LoginEvent()
}
