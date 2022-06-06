package com.davahamka.kinder.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.davahamka.kinder.common.Screen
import com.davahamka.kinder.static.NearestDataStatic

@Composable
fun ListItemNearest(navController: NavController) {
    Column(
        modifier = Modifier.padding(bottom = 32.dp)
    ) {
        NearestDataStatic.dataCard.map {
            ItemNearest(it, onClick = { navController.navigate(Screen.DonateDetailMapScreen.route+"/false")})
        }
    }
}