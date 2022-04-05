package com.davahamka.kinder.data.repository

import android.util.Log
import com.davahamka.kinder.common.DataState
import com.davahamka.kinder.common.Resource
import com.davahamka.kinder.data.api.KinderApi
import com.davahamka.kinder.domain.model.LoginRequest
import com.davahamka.kinder.domain.model.LoginResponse
import com.davahamka.kinder.domain.model.RegisterRequest
import com.davahamka.kinder.domain.model.RegisterResponse
import com.davahamka.kinder.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: KinderApi
): AuthRepository {
    override suspend fun setLogin(data: LoginRequest): LoginResponse {
        return api.setLogin(data)
    }

    override suspend fun setRegister(data: RegisterRequest): RegisterResponse {
        return api.setRegister(data)
    }

    override suspend fun validateToken() {
        return api.validateToken()
    }
}