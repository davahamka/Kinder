package com.davahamka.kinder.presentation.donate

import android.net.Uri
import android.widget.Space
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.futured.donut.compose.DonutProgress
import app.futured.donut.compose.data.DonutModel
import app.futured.donut.compose.data.DonutSection
import coil.compose.rememberImagePainter
import com.davahamka.kinder.R
import com.davahamka.kinder.common.Screen
import com.davahamka.kinder.presentation.CameraCapture
import com.davahamka.kinder.presentation.auth.InformationScreen
import com.davahamka.kinder.presentation.auth.login.LoginViewModel
import com.davahamka.kinder.presentation.donate.components.ItemInformationGizi
import com.davahamka.kinder.presentation.donate.components.OptionPill
import com.davahamka.kinder.presentation.donate.components.QuantityPill
import com.davahamka.kinder.presentation.ui.component.TopBarDescription
import com.davahamka.kinder.presentation.ui.theme.*
import com.davahamka.kinder.static.NutritionSummaryDataStatic
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CameraScreen(modifier: Modifier = Modifier, navController: NavController, viewModel: DonateFormViewModel = hiltViewModel()) {
    val emptyImageUri = Uri.parse("file://dev/null")
    var imageUri by remember { mutableStateOf(emptyImageUri) }
    var label by remember { mutableStateOf("") }

    var expanded by remember { mutableStateOf(false)}
    val list = listOf("Kilogram", "Piece", "Serving")
    var selectedItem by remember { mutableStateOf("") }

    var textFieldSize by remember { mutableStateOf(Size.Zero)}

    val icon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }



    if (imageUri != emptyImageUri) {
        Scaffold(topBar = { TopBarDescription("Food Information") }) {
            LazyColumn(modifier = modifier) {
                item {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp)) {
                        Image(
                                painter = rememberImagePainter(imageUri),
                                modifier = Modifier
                                    .fillMaxSize(),
                                contentDescription = "Captured image",
                            contentScale = ContentScale.Crop
                            )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Row() {
//                            Image(
//                                painter = rememberImagePainter(imageUri),
//                                modifier = Modifier
//                                    .height(140.dp)
//                                    .width(140.dp),
//                                contentDescription = "Captured image"
//                            )
                            Image(painter = painterResource(id = R.drawable.r_img_banana), contentDescription = null, modifier = Modifier
                                .width(78.dp)
                                .height(78.dp))
                            Spacer(modifier = Modifier.width(10.dp))
                            Column() {
                                Text(text = label, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                                Text(text = "234 kal")
                            }
                        }
                        Column(modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                            .background(
                                Color(0XFF2F9A49).copy(0.2f),
                                shape = RoundedCornerShape(24.dp)
                            ),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ){
                            Text(text = "Good Condition", color = Green3, modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp))
                        }
                    }
                    Divider(
                        thickness = 1.dp,
                        modifier = Modifier.padding(vertical = 14.dp, horizontal = 18.dp)
                    )
                    Text(text = "Nutrition Summary", fontSize=14.sp, fontWeight= FontWeight.Bold, modifier = Modifier.padding(horizontal = 18.dp))

                    DonutProgress(
                        model = DonutModel(
                            cap = 8f,
                            masterProgress = 1f,
                            gapWidthDegrees = 270f,
                            gapAngleDegrees = 90f,
                            strokeWidth = 40f,
                            backgroundLineColor = Color.LightGray,
                            sections = listOf(
                                DonutSection(amount = 1f, color = Color.Cyan),
                                DonutSection(amount = 1f, color = Color.Red),
                                DonutSection(amount = 1f, color = Color.Green),
                                DonutSection(amount = 0f, color = Color.Blue)
                            )
                        )
                    )

                    LazyRow(
                        modifier = Modifier.padding(start = 18.dp, top = 12.dp)
                    ){
                        item {
                            NutritionSummaryDataStatic.dataNutrionSummary.forEach {
                                ItemInformationGizi(it)
                            }
                            Column(
                                modifier = Modifier
                                    .padding(end = 16.dp)
                                    .border(width = 1.dp,color = Color.Black, shape = RoundedCornerShape(16.dp))
                                    .width(90.dp)
                                    .background(shape = RoundedCornerShape(24.dp), color = Color.White), horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = "More")
                            }
                        }
                    }

                    Column(
                        modifier = Modifier
                            .padding(18.dp)
                            .background(color = Color(0xFEF2D5))
                    ) {
                        Text(text = "These foods are not for people with the problem health below")

                        FlowRow(
                            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                            mainAxisSpacing = 12.dp,
                            crossAxisSpacing = 16.dp,
                        ) {
                            OptionPill("Heart disease", notRecommended = true)
                            OptionPill("Diabetes",  notRecommended = true)
                            OptionPill("Stomach Ache",  notRecommended = true)
                        }

                        Text(text = "This type of food is beneficial for health problems")

                        FlowRow(
                            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                            mainAxisSpacing = 12.dp,
                            crossAxisSpacing = 16.dp,
                        ) {
                            OptionPill("Stomatch", notRecommended = false)
                            OptionPill("Low Blood", notRecommended = false)
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        Divider(modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp))
                        Spacer(modifier = Modifier.padding(16.dp))
                        Text(text = "Enter The Quantity You Want To Donate")
                        Row(modifier = Modifier.padding(vertical = 16.dp)) {
                            QuantityPill("1", active = viewModel.quantity == "1" , onClick = {viewModel.onEvent(DonateFormEvent.OnChangeQuantity("1"))})
                            QuantityPill("2", active = viewModel.quantity == "2", onClick = {viewModel.onEvent(DonateFormEvent.OnChangeQuantity("2"))})
                            QuantityPill("3", active = viewModel.quantity == "3", onClick = {viewModel.onEvent(DonateFormEvent.OnChangeQuantity("3"))})
                            QuantityPill("4", active = viewModel.quantity == "4",onClick = {viewModel.onEvent(DonateFormEvent.OnChangeQuantity("4"))})
                            QuantityPill("5", active = viewModel.quantity == "5" ,onClick = {viewModel.onEvent(DonateFormEvent.OnChangeQuantity("5"))})
                        }
              
                            OutlinedTextField(value = viewModel.quantity, onValueChange = {}, modifier = Modifier.fillMaxWidth(), placeholder = { Text(
                                text = ("Type other quantity")
                            )} )
                            
                        Spacer(modifier = Modifier.height(6.dp))
                            OutlinedTextField(
                                value = selectedItem,
                                onValueChange = { selectedItem = it},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { expanded = !expanded }
                                    .onGloballyPositioned { coordinates ->
                                        textFieldSize = coordinates.size.toSize()
                                    },
                                trailingIcon = {
                                    Icon(icon, contentDescription = null, modifier = Modifier.clickable { expanded = !expanded })
                                },
                                placeholder = { Text(text = "Select Unit")}
                            )

                            DropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false },
                                modifier = Modifier.width(with(LocalDensity.current){textFieldSize.width.toDp()})) {
                                
                                list.forEach { label ->
                                    DropdownMenuItem(onClick = {   selectedItem = label
                                        expanded = false }) {
                                        Text(text = label)
                                    }
                                }
                            }


                    }
                    Column(modifier = Modifier.padding(vertical = 16.dp, horizontal = 18.dp)) {
                        Text(text = "Activity Type")
                        Row(
                            modifier = Modifier.padding(top = 10.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .background(
                                        color = if (viewModel.activityType == "Donate") Orange1 else Grey2,
                                        shape = RoundedCornerShape(24.dp)
                                    )
                                    .width(100.dp)
                                    .height(37.dp)
                                    .clickable {
                                        viewModel.onEvent(DonateFormEvent.OnChangeActivityType("Donate"))
                                    },
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Donate",
                                    fontWeight = FontWeight.SemiBold,
                                    color = if (viewModel.activityType == "Donate") Color.White else Black1
                                )
                            }
                            Spacer(modifier = Modifier.width(14.dp))
                            Column(
                                modifier = Modifier
                                    .background(
                                        color = if (viewModel.activityType == "Cheap Sale") Orange1 else Grey2,
                                        shape = RoundedCornerShape(24.dp)
                                    )
                                    .width(100.dp)
                                    .height(37.dp)
                                    .clickable {
                                        viewModel.onEvent(DonateFormEvent.OnChangeActivityType("Cheap Sale"))
                                    },
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(text = "Cheap Sale", fontWeight = FontWeight.SemiBold, color = if (viewModel.activityType == "Cheap Sale") Color.White else Black1,)
                            }
                            Spacer(modifier = Modifier.width(14.dp))
                        }
                    }

                    Column(
                        modifier = Modifier.padding(vertical = 18.dp, horizontal = 18.dp)
                    ) {
                        CustomButton(
                            onClick = {
                                navController.navigate(Screen.DescriptionFormScreen.route)
                            },
                            text = "Continue"
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        CustomButton(
                            onClick = {
                                imageUri = emptyImageUri
                            },
                            text = "Go Back"
                        )
                    }

                }
            }
        }
    } else {
        CameraCapture(
            modifier = modifier,
            onImageFile = { file, value ->
                imageUri = file.toUri()
                label = value
            }
        )
    }
}