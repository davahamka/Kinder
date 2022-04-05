package com.davahamka.kinder.data.repository

import com.davahamka.kinder.common.Resource
import com.davahamka.kinder.data.api.KinderApi
import com.davahamka.kinder.domain.model.RegisterRequest
import com.davahamka.kinder.domain.model.RegisterResponse
import com.davahamka.kinder.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    val api: KinderApi
): UserRepository {
    override suspend fun registerUser(user: RegisterRequest): RegisterResponse {
        return api.setRegister(user)
    }

    override suspend fun updateUser() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser() {
        TODO("Not yet implemented")
    }

    override suspend fun getUserById() {
        TODO("Not yet implemented")
    }
}