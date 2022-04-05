package com.davahamka.kinder.domain.repository

import com.davahamka.kinder.common.Resource
import com.davahamka.kinder.domain.model.RegisterRequest
import com.davahamka.kinder.domain.model.RegisterResponse
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun registerUser(user: RegisterRequest): RegisterResponse

    suspend fun updateUser()

    suspend fun deleteUser()

    suspend fun getUserById()
}