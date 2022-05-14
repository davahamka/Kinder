package com.davahamka.kinder.domain.usecase.user

import com.davahamka.kinder.domain.model.RegisterRequest
import com.davahamka.kinder.domain.model.RegisterResponse
import com.davahamka.kinder.domain.repository.UserRepository

class RegisterUser(
    private val repository: UserRepository
) {
    suspend operator fun invoke(registerRequest: RegisterRequest): RegisterResponse {
        return repository.registerUser(registerRequest)
    }
}