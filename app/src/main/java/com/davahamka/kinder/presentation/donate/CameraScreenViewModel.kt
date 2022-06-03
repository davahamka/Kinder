package com.davahamka.kinder.presentation.donate

import androidx.lifecycle.ViewModel
import com.davahamka.kinder.domain.usecase.auth.AuthUseCases
import com.davahamka.kinder.domain.usecase.nutrition.NutritionUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CameraScreenViewModel @Inject constructor(
    private val nutritionUseCases: NutritionUseCases
): ViewModel() {

}