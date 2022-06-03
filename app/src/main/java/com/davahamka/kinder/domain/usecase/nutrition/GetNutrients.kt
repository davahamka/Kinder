package com.davahamka.kinder.domain.usecase.nutrition

import com.davahamka.kinder.domain.model.NutrientsRequest
import com.davahamka.kinder.domain.model.NutrientsResponse
import com.davahamka.kinder.domain.repository.NutritionRepository

class GetNutrients(private val repository: NutritionRepository) {
    suspend fun invoke(nutrientsRequest: NutrientsRequest): NutrientsResponse {
        return repository.getNutrients(nutrientsRequest)
    }
}