package com.davahamka.kinder.presentation.home

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.davahamka.kinder.R
import com.davahamka.kinder.common.Screen
import com.davahamka.kinder.presentation.home.components.ListItemNearest
import com.davahamka.kinder.presentation.home.components.ModalBottomShare
import com.davahamka.kinder.presentation.home.components.RecommendationMission
import com.davahamka.kinder.presentation.ui.component.BottomNavigationBar
import com.davahamka.kinder.presentation.ui.component.TopBar
import com.davahamka.kinder.presentation.ui.theme.Black1
import com.davahamka.kinder.presentation.ui.theme.Grey2
import com.davahamka.kinder.presentation.ui.theme.PrimaryColor
import com.davahamka.kinder.presentation.ui.theme.White1
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    val bottomSheetScaffoldShareState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )

    val bottomSheetScaffoldReceiveState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )

    val modalBottomSheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden
    )

    val coroutineScope = rememberCoroutineScope()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = PrimaryColor,
        )
    }

    
    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = {
            ModalBottomShare(navController)
    } ) {
        Scaffold(topBar = {
            TopBar()
        },bottomBar = { BottomNavigationBar(navController = navController!!)} ) {
            LazyColumn(modifier = Modifier.padding(bottom = 32.dp)) {
                item {
                    Column(
                        modifier = Modifier
                            .background(PrimaryColor)
                            .height(158.dp)
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth()
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 6.dp)
                        ) {
                            Column() {
                                Text(color = White1, fontWeight = FontWeight.Medium, text = "Hi Siti,", fontSize = 18.sp)
                                Text(
                                    color = White1,
                                    text = "Find good things today",
                                    )
                            }
                            Column(
                                modifier = Modifier.padding(top = 8.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(painter = painterResource(id = R.drawable.ic_leaderboard), contentDescription = null, tint = Color.White, modifier = Modifier.clickable {
                                    navController?.navigate(Screen.LeaderboardScreen.route)
                                })
                                Text(text = "400xp", color = Color.White)
                            }
                        }
                        Spacer(modifier = Modifier.height(18.dp))
                        Box(
                            modifier = Modifier
                                .background(Color.White, shape = RoundedCornerShape(30.dp))
                                .fillMaxWidth()
                                .height(54.dp)
                        ){
                            OutlinedTextField(
                                value = "",
                                onValueChange = {},
                                shape = RoundedCornerShape(30.dp),
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    unfocusedBorderColor = Grey2,
                                    focusedBorderColor = Color.White,
                                    cursorColor = PrimaryColor
                                ),
                                placeholder = {
                                    Text(text = "Find items here")
                                },
                                leadingIcon = {
                                    Icon(imageVector = Icons.Outlined.Search, contentDescription = null)
                                },

                                modifier = Modifier
                                    .matchParentSize()
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .offset(y = (-12).dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(
                                Color.White
                            )
                    ) {
                        RecommendationMission()
                    }
                    DonateOrReceiveButton(
                        onClickDonate = {
                            coroutineScope.launch { modalBottomSheetState.show() }
                        },
                        onClickReceive = {
                           navController.navigate(Screen.DonateDetailMapScreen.route+"/true")
                        }
                    )
                    LevelCard(navController = navController)
                    Column(
                        modifier = Modifier.padding(top = 14.dp, start = 16.dp, end = 16.dp)
                    ) {
                        Text(text = "Nearest Search", fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
                        ListItemNearest(navController)
                    }
                }
            }

        }
    }


}
