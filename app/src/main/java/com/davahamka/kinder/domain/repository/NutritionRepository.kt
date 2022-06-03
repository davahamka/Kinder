package com.davahamka.kinder.domain.repository


import com.davahamka.kinder.domain.model.NutrientsRequest
import com.davahamka.kinder.domain.model.NutrientsResponse

interface NutritionRepository {
    suspend fun getNutrients(data: NutrientsRequest): NutrientsResponse
}