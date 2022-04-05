package com.davahamka.kinder.data.api
import android.util.Log
import com.davahamka.kinder.common.DataState
import com.davahamka.kinder.common.Resource
import com.davahamka.kinder.domain.model.LoginRequest
import com.davahamka.kinder.domain.model.LoginResponse
import com.davahamka.kinder.domain.model.RegisterRequest
import com.davahamka.kinder.domain.model.RegisterResponse
import dagger.hilt.internal.GeneratedEntryPoint
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.*

interface KinderApi {

    // auth
    @POST("auth/login")
    suspend fun setLogin(@Body data: LoginRequest): LoginResponse

    @GET("auth")
    suspend fun validateToken()


    // donate
    @POST("donate")
    suspend fun insertDonate()

    @GET("donate/:id")
    suspend fun getDonateById()

    @GET("donate")
    suspend fun getAllDonate()

    @PUT("donate/:id")
    suspend fun updateDonate()

    @POST("predict")
    suspend fun predictImage()


    // user
    @POST("user/register")
    suspend fun setRegister(@Body data: RegisterRequest): RegisterResponse

    @POST("user/:id")
    suspend fun updateUser(@Body s: String)

    @DELETE("user/:id")
    suspend fun deleteUser()

    @GET("user")
    suspend fun getUserById()
}