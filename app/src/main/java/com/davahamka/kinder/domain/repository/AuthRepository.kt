package com.davahamka.kinder.domain.repository

import com.davahamka.kinder.common.DataState
import com.davahamka.kinder.common.Resource
import com.davahamka.kinder.domain.model.LoginRequest
import com.davahamka.kinder.domain.model.LoginResponse
import com.davahamka.kinder.domain.model.RegisterRequest
import com.davahamka.kinder.domain.model.RegisterResponse
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun setLogin(data: LoginRequest): LoginResponse

    suspend fun setRegister(data: RegisterRequest): RegisterResponse

    suspend fun validateToken()
}