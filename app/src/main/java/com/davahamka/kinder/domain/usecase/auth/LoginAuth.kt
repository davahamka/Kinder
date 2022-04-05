package com.davahamka.kinder.domain.usecase.auth

import android.service.autofill.Dataset
import android.util.Log
import com.davahamka.kinder.common.DataState
import com.davahamka.kinder.common.Resource
import com.davahamka.kinder.domain.model.LoginRequest
import com.davahamka.kinder.domain.model.LoginResponse
import com.davahamka.kinder.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginAuth(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(loginRequest: LoginRequest): LoginResponse {
        return repository.setLogin(loginRequest)
    }
}