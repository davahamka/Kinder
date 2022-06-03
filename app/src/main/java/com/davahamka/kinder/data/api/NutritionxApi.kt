package com.davahamka.kinder.data.api

import com.davahamka.kinder.common.Constants
import com.davahamka.kinder.domain.model.NutrientsRequest
import com.davahamka.kinder.domain.model.NutrientsResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface NutritionxApi {

    @Headers(
        "x-app-id:${Constants.X_APP_ID}",
        "x-app-key: ${Constants.X_APP_KEY}"
    )
    @POST("natural/nutrients")
    suspend fun getNutrients(@Body data:NutrientsRequest): NutrientsResponse

}