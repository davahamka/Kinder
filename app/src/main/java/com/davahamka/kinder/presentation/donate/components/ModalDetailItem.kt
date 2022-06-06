package com.davahamka.kinder.presentation.home.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.PinDrop
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.futured.donut.compose.DonutProgress
import app.futured.donut.compose.data.DonutModel
import app.futured.donut.compose.data.DonutSection
import coil.compose.AsyncImage
import com.davahamka.kinder.R
import com.davahamka.kinder.common.Screen
import com.davahamka.kinder.presentation.donate.CustomButton
import com.davahamka.kinder.presentation.donate.components.ItemInformationGizi
import com.davahamka.kinder.presentation.ui.theme.*
import com.davahamka.kinder.static.NutritionSummaryDataStatic

@Composable
fun ModalDetailItem(navController: NavController) {
    LazyColumn {
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, start = 24.dp, end = 24.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Column() {
                        AsyncImage(
                            model = "https://cdn.antaranews.com/cache/800x533/2017/05/20170508pisang.jpg",
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .width(120.dp)
                                .height(120.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(24.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(text = "Good Quality Banana", color = Black1, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(top = 4.dp)
                        ) {
                            Icon(imageVector = Icons.Filled.CalendarToday, contentDescription = null, modifier = Modifier.size(12.dp))
                            Text(text = "4 Juni 2022", modifier = Modifier.padding(start = 6.dp), fontSize = 12.sp)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier
                                .background(color = Orange2, shape = RoundedCornerShape(10.dp))
                                .padding(horizontal = 12.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(painter = painterResource(id = R.drawable.ic_free), modifier = Modifier.size(12.dp), contentDescription = null, tint = Color.White)
                            Text(text = "Donation", color = Color.White, fontSize = 12.sp, modifier = Modifier.padding(start = 4.dp))
                        }
                    }
                }

                Divider(
                    modifier = Modifier.padding(vertical = 14.dp, horizontal = 24.dp)
                )
                
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                ) {
                    Text(text = "Food Owner", fontWeight = FontWeight.Bold, fontSize = 18.sp, modifier = Modifier.padding(bottom = 12.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row() {
                            AsyncImage(
                                model = "https://mer-c.org/images/2020/11-dr-siti-fadilah-supari-Sp-JP.jpg",
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .width(54.dp)
                                    .height(54.dp)
                            )
                            Spacer(modifier = Modifier.padding(start = 10.dp))
                            Column() {
                                Text(text = "Siti", fontWeight = FontWeight.Bold)
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(top = 4.dp)
                                ) {
                                    Icon(imageVector = Icons.Filled.PinDrop, contentDescription = null, tint = PrimaryColor, modifier = Modifier.size(11.dp))
                                    Text(text = "Jebres, Surakarta", fontSize = 11.sp)
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(top = 4.dp)
                                ) {
                                    Icon(imageVector = Icons.Filled.Star, contentDescription = null, tint = Orange2, modifier = Modifier.size(11.dp))
                                    Text(text = "4.5")
                                }
                            }
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .background(color = Grey2, shape = RoundedCornerShape(12.dp))
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Image(painter = painterResource(id = R.drawable.ic_level_icon) , contentDescription = null, modifier = Modifier.size(12.dp))
                            Text(text = "Donation Warrior", modifier = Modifier.padding(start = 8.dp), fontSize = 12.sp)
                        }
                    }
                }

                Divider(modifier = Modifier.padding(vertical = 14.dp, horizontal = 24.dp))

                Column(modifier = Modifier.padding(bottom = 20.dp)) {
                    Text(text = "Description",  fontSize=18.sp, fontWeight= FontWeight.Bold, modifier = Modifier.padding(horizontal = 24.dp))
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(modifier = Modifier.padding(horizontal = 24.dp),lineHeight = 24.sp ,color = Color(0xFF565656),text = "Saya ingin membagikan buah pisang dari toko saya sendiri secara gratis. karena jika saya jual besok buah ini tidak layak makan dan hampir busuk. Bagi yang berminat bisa langsung ke rumah saya untuk mengambilnya ya. Untuk detail alamat rumah bisa kontak saya melalui chat ya.")
                }

                
                Column() {
                    Text(text = "Nutrition Summary", fontSize=18.sp, fontWeight= FontWeight.Bold, modifier = Modifier.padding(horizontal = 24.dp))

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
                        }
                    }
                }
                
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),

                ) {
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(text = "Food Details", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(12.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth().border(shape = RoundedCornerShape(10.dp),width = 2.dp, color = White1).padding(vertical = 18.dp, horizontal = 14.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Donated Amount")
                            Text(text = "100")
                        }
                        
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(top = 6.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Quantity of food available")
                            Text(text = "25")
                        }
                    }
                }
                
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(64.dp)) {
                    CustomButton(
                        onClick = {
                            navController.navigate(Screen.DonateConfirmationReceiveScreen.route)
                        },
                        text = "Take It Now"
                    )
                }
            }
        }
    }
}