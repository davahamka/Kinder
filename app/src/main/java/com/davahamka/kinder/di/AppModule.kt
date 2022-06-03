package com.davahamka.kinder.di

import com.davahamka.kinder.common.Constants
import com.davahamka.kinder.data.api.KinderApi
import com.davahamka.kinder.data.api.NutritionxApi
import com.davahamka.kinder.data.repository.AuthRepositoryImpl
import com.davahamka.kinder.data.repository.DonateRepositoryImpl
import com.davahamka.kinder.data.repository.NutritionRepositoryImpl
import com.davahamka.kinder.data.repository.UserRepositoryImpl
import com.davahamka.kinder.domain.repository.AuthRepository
import com.davahamka.kinder.domain.repository.DonateRepository
import com.davahamka.kinder.domain.repository.NutritionRepository
import com.davahamka.kinder.domain.repository.UserRepository
import com.davahamka.kinder.domain.usecase.auth.AuthUseCases
import com.davahamka.kinder.domain.usecase.auth.LoginAuth
import com.davahamka.kinder.domain.usecase.auth.ValidateToken
import com.davahamka.kinder.domain.usecase.nutrition.GetNutrients
import com.davahamka.kinder.domain.usecase.nutrition.NutritionUseCases
import com.davahamka.kinder.domain.usecase.user.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideKinderApi(): KinderApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KinderApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNutritionApi(): NutritionxApi {
        return Retrofit.Builder()
            .baseUrl(Constants.NUTRITIONX_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NutritionxApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: KinderApi): UserRepository {
        return UserRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideUserUseCases(repository: UserRepository): UserUseCases {
        return UserUseCases(
            registerUser = RegisterUser(repository),
            deleteUser = DeleteUser(repository),
            getUserById = GetUserById(repository),
            updateUser = UpdateUser(repository)
        )
    }

    @Provides
    @Singleton
    fun provideAuthRepository(api: KinderApi): AuthRepository {
        return AuthRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideAuthUseCases(repository: AuthRepository): AuthUseCases {
        return AuthUseCases(
            loginAuth = LoginAuth(repository),
            validateToken = ValidateToken(repository)
        )
    }

    @Provides
    @Singleton
    fun provideDonateRepository(api: KinderApi): DonateRepository {
        return DonateRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideNutritionRepository(api: NutritionxApi): NutritionRepository {
        return NutritionRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideNutritionUseCases(repository: NutritionRepository): NutritionUseCases {
        return NutritionUseCases(
            getNutrients = GetNutrients(repository)
        )
    }
}