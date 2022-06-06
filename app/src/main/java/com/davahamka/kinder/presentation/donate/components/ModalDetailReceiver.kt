package com.davahamka.kinder.presentation.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.davahamka.kinder.common.Screen
import com.davahamka.kinder.presentation.donate.CustomButton
import com.davahamka.kinder.presentation.ui.theme.Green3
import com.davahamka.kinder.presentation.ui.theme.PrimaryColor

@Composable
fun ModalDetailReceiver(navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Text(text = "Name", color = Green3, fontWeight = FontWeight.Bold)
                Text(text = "Dhimas", modifier = Modifier.padding(top = 4.dp), fontWeight = FontWeight.Medium)
                Text(text = "Number of family members", color = Green3, modifier = Modifier.padding(top = 10.dp), fontWeight = FontWeight.Bold)
                Text(text = "4", modifier = Modifier.padding(top = 4.dp), fontWeight = FontWeight.Medium)
                Text(text = "Food tabos", color = Green3, modifier = Modifier.padding(top = 10.dp), fontWeight = FontWeight.Bold)
                Text(text = "Daging kambing, Minyak Santan", modifier = Modifier.padding(top = 4.dp), fontWeight = FontWeight.Medium)
                Text(text = "Favorite food",color = Green3, modifier = Modifier.padding(top = 10.dp), fontWeight = FontWeight.Bold)
                Text(text = "Seafood, Nasi goreng", modifier = Modifier.padding(top = 4.dp), fontWeight = FontWeight.Medium)
            }
            Column(
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AsyncImage(
                    model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbSRylm21Dndh-8PckZUVBHASNyfcVbJmAgA&usqp=CAU",
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .width(92.dp)
                        .height(92.dp)
                )
            }
        }

//        Column(modifier = Modifier.fillMaxWidth().padding(24.dp)) {
//            CustomButton(
//                onClick = {
//                          navController.navigate(Screen.DonateConfirmationScreen.route)
//                },
//                text = "Deliver Now"
//            )
//        }
    }
}