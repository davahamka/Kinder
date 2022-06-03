package com.davahamka.kinder.static

import androidx.compose.ui.graphics.Color

data class NutrionSummary(
    val percent: Int,
    val name: String,
    val gram: String,
    val colorBackground: Color,
    val colorText: Color
)

object NutritionSummaryDataStatic {
    val dataNutrionSummary = listOf(
        NutrionSummary(percent = 50, name = "Fat", colorBackground = Color(0xff0EC7E0).copy(0.2f),colorText = Color(0xff3165D8), gram = "48 gram"),
        NutrionSummary(percent = 50, name = "Cholesterol", colorBackground = Color(0xffF1963A).copy(0.2f),colorText = Color(0xffF1963A), gram = "2 mg"),
        NutrionSummary(percent = 50, name = "Sodium", colorBackground = Color(0xffC7CEDC),colorText = Color(0xff5073B8), gram = "3 mg"),
        NutrionSummary(percent = 50, name = "Potassium", colorBackground = Color(0xffB9DBD6),colorText = Color(0xff0AB39C), gram = "3 mg"),
        NutrionSummary(percent = 50, name = "Carbohydrate", colorBackground = Color(0xffE7CBC5),colorText = Color(0xffF16548), gram = "5 g"),
        NutrionSummary(percent = 50, name = "Protein", colorBackground = Color(0xffE7CBC5),colorText = Color(0xffF16548), gram = "3 g"),
    )
}
