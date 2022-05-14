package com.davahamka.kinder.presentation.auth.register

sealed class RegisterEvent {
    data class OnChangeName(val name: String): RegisterEvent()
    data class OnChangePassword(val password: String): RegisterEvent()
    data class OnChangeEmail(val email: String): RegisterEvent()
    data class OnChangePhoneNumber(val phoneNumber: String): RegisterEvent()
    object OnTogglePrivacyPolicy: RegisterEvent()
    data class OnSubmitRegister(val cb: ()-> Unit): RegisterEvent()
    data class NavigateToLogin(val cb: () -> Unit): RegisterEvent()
}
