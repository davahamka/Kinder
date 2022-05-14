package com.davahamka.kinder.domain.model

data class RegisterResponse(
    val data: User,
    val message: String,
    val token: String
)
