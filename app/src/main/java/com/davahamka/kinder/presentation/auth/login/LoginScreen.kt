package com.davahamka.kinder.presentation.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.internal.isLiveLiteralsEnabled
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.davahamka.kinder.common.Screen
import com.davahamka.kinder.presentation.auth.component.AuthenticationButton
import com.davahamka.kinder.presentation.ui.theme.Black1
import com.davahamka.kinder.presentation.ui.theme.Grey2
import com.davahamka.kinder.presentation.ui.theme.PrimaryColor
import com.davahamka.kinder.presentation.ui.theme.White1
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun LoginScreen(
    navController: NavController?,
    viewModel: LoginViewModel = hiltViewModel()
) {

    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = White1,
        )
    }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        item {
            Text(
                text = "Login",
                color= Black1,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 36.dp, top = 120.dp)
            )


            if(viewModel.state.value.error.isNotEmpty()) {
                Text(text = viewModel.state.value.error, color = Color.Red, modifier = Modifier.padding(bottom = 6.dp))
            }
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.email,
                onValueChange = { viewModel.onEvent(LoginEvent.OnChangeEmail(it))
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.MailOutline, contentDescription = "")
                },
                placeholder = {
                    Text("Email")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Grey2,
                    focusedBorderColor = PrimaryColor
                ),
                shape = RoundedCornerShape(11.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                ,
                visualTransformation = PasswordVisualTransformation(),
                value = viewModel.password,
                onValueChange = { viewModel.onEvent(LoginEvent.OnChangePassword(it))},
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Lock, contentDescription = "")
                },
                placeholder = {
                    Text("Password")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Grey2,
                    focusedBorderColor = PrimaryColor
                ),
                shape = RoundedCornerShape(11.dp)
            )


            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp), horizontalArrangement = Arrangement.End, ) {
                ClickableText(
                    onClick = {  },
                    modifier = Modifier.fillMaxWidth(),
                    text = AnnotatedString("Forgot your password?"),
                    style = TextStyle(color = Black1, textAlign = TextAlign.Right, fontWeight = FontWeight.Bold),
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            AuthenticationButton(
                text = "Login",
                isLoading = viewModel.state.value.isLoading,
                onClick = { LoginEvent.OnSubmitLogin(cb={navController?.navigate(Screen.HomeScreen.withArgs())}) }
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Dont't have an account yet?", color = Black1)
                ClickableText(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    onClick = {
                        viewModel.onEvent(LoginEvent.NavigateToRegister(cb = {
                            navController?.navigate(Screen.RegisterScreen.route){
                                popUpTo(Screen.LoginScreen.route) {
                                    inclusive = true
                                }
                            }
                        }))
                    },
                    text = AnnotatedString("Register"),
                    style = TextStyle(fontWeight = FontWeight.Bold, color = PrimaryColor)
                )
            }
        }

    }
}
