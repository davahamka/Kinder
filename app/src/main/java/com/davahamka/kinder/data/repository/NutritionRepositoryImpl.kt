package com.davahamka.kinder.data.repository

import android.util.Log
import com.davahamka.kinder.common.DataState
import com.davahamka.kinder.common.Resource
import com.davahamka.kinder.data.api.KinderApi
import com.davahamka.kinder.data.api.NutritionxApi
import com.davahamka.kinder.domain.model.*
import com.davahamka.kinder.domain.repository.AuthRepository
import com.davahamka.kinder.domain.repository.NutritionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NutritionRepositoryImpl @Inject constructor(
    private val api: NutritionxApi
): NutritionRepository {
    override suspend fun getNutrients(data: NutrientsRequest): NutrientsResponse {
        return api.getNutrients(data)
    }
}