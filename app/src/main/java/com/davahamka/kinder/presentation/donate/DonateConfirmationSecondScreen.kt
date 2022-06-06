package com.davahamka.kinder.presentation.donate

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.davahamka.kinder.R
import com.davahamka.kinder.common.Screen
import com.davahamka.kinder.presentation.ui.theme.Black1
import com.davahamka.kinder.presentation.ui.theme.PrimaryColor

@Composable
fun DonateConfirmationSecondScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Confirm if the recipient", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Black1)
        Text(text = "taken the donation you offered", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Black1)
        Spacer(modifier = Modifier.height(24.dp))
        Image(painter = painterResource(R.drawable.img_confirmation_am), contentDescription = null)
        Spacer(modifier = Modifier.height(24.dp))
        Column() {
            CustomButton(text = "Confirmation Has Been Taken By Receipent", onClick = { /*TODO*/ })
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = PrimaryColor
                ),
                contentPadding = PaddingValues(vertical = 12.dp),
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 2.dp, color = PrimaryColor, shape = RoundedCornerShape(25.dp)),
                onClick = {
                    navController.navigate(Screen.HomeScreen.route){
                        popUpTo(0) {
                            inclusive = true
                        }
                    }
                }
            ) {
                Text(text = "Back to Home")
            }
        }
    }
}