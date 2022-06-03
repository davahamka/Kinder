package com.davahamka.kinder.presentation.donate.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davahamka.kinder.presentation.ui.theme.Black1
import com.davahamka.kinder.presentation.ui.theme.Grey1
import com.davahamka.kinder.static.NutrionSummary

@Composable
fun ItemInformationGizi(data: NutrionSummary) {
    Column(modifier = Modifier.padding(end = 16.dp).border(width = 1.dp,color = Color.Black, shape = RoundedCornerShape(16.dp)).width(90.dp).background(shape = RoundedCornerShape(24.dp), color = Color.White), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = data.name, fontSize = 14.sp, color = Black1, modifier = Modifier.padding(top = 8.dp), fontWeight = FontWeight.Bold)
        Text(text = "${data.gram}", fontSize = 18.sp, color = Grey1, modifier = Modifier.padding(top = 2.dp, bottom = 8.dp), fontWeight = FontWeight.SemiBold)
    }
}