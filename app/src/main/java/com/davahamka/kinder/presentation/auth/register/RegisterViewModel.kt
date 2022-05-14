package com.davahamka.kinder.presentation.auth.register

import android.provider.ContactsContract
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davahamka.kinder.domain.model.RegisterRequest
import com.davahamka.kinder.domain.usecase.user.RegisterUser
import com.davahamka.kinder.domain.usecase.user.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val userUseCases: UserUseCases
): ViewModel() {

    private val _state = mutableStateOf(RegisterState())
    val state: State<RegisterState> = _state

    var name by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var email by mutableStateOf("")
        private set

    var phoneNumber by mutableStateOf("")
        private set

    var isConfirmPrivacyPolicy by mutableStateOf(false)
        private set

    fun onEvent(event: RegisterEvent) {
        when(event) {
            is RegisterEvent.OnChangeName -> {
                name = event.name
            }
            is RegisterEvent.OnChangePassword -> {
                password = event.password
            }
            is RegisterEvent.OnChangeEmail -> {
                email = event.email
            }
            is RegisterEvent.OnChangePhoneNumber -> {
                phoneNumber = event.phoneNumber
            }
            is RegisterEvent.OnTogglePrivacyPolicy -> {
                isConfirmPrivacyPolicy = !isConfirmPrivacyPolicy
            }
            is RegisterEvent.OnSubmitRegister -> {
                viewModelScope.launch {
                    _state.value = _state.value.copy(
                        isLoading = true
                    )
                    val result = userUseCases.registerUser(
                        RegisterRequest(
                            name = name, no_hp = phoneNumber, password = password, email = email
                        )
                    )
                    if (result.message == "Success") {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            successMessage = result.message
                        )
                        event.cb()

                    } else {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            successMessage = "error"
                        )
                    }
                }
            }
            is RegisterEvent.NavigateToLogin -> {
                event.cb()
            }
        }
    }
}