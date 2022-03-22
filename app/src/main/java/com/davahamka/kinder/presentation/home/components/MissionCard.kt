package com.davahamka.kinder.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davahamka.kinder.presentation.ui.theme.PrimaryColor

@Composable
fun MissionCard() {
    Card(
        modifier = Modifier
            .height(140.dp)
            .width(310.dp),
        shape = RoundedCornerShape(14.dp),
        backgroundColor = Color(0xFFFDE7F4)
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Ambil donasi dari Pak Bayu Juragan buah Pasar Senen", fontSize = 14.sp, color = Color(0xffE66480), fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp))
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = null, modifier = Modifier.size(9.dp))
                    Text(text = "4173", fontWeight = FontWeight.Medium, fontSize = 10.sp)
                    Text(text = " orang telah mengikuti misi ini", fontSize = 10.sp)
                }
                Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFE7335A),
                    contentColor = Color.White,
                ),
                    shape = RoundedCornerShape(25.dp)
                    ) {
                    Text(text = "Ikuti Sekarang", fontSize = 11.sp)
                }
            }
        }
    }
}