package com.davahamka.kinder.presentation.donate

import com.davahamka.kinder.domain.model.NutrientsResponse

data class GetNutrientsState(
    var isLoading: Boolean = false,
    var data:NutrientsResponse? = null,
    var error: String = "",
)