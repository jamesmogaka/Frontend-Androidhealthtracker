package com.example.androidhealthtracker.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androidhealthtracker.BuildConfig
import com.example.androidhealthtracker.R
import com.example.androidhealthtracker.navigation.Components
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Box(modifier = modifier){
        Image(
            painter = painterResource(id = R.mipmap.icon_foreground ),
            contentDescription ="Application logo goes here",
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp)
        )
        Text(
            text ="Version: ${BuildConfig.VERSION_NAME}",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp)
        )
    }
    //
    //TODO: Investigate on animations
    //api that enable us to launch a coroutine
    LaunchedEffect(key1 =true){
        delay(5000)
        /* TODO:Check if the user is a new user or returning user to determine the screen navigation
         1.Check if the user has a firebase phone no auth token
         2. Validate the authenticity of the token by the user
         3.if the firebase token is valid then proceed to default application navigation
         4.else use the new user navigation graph(includes verification and user creation )*/

        navController.navigate(Components.PhoneNumberVerificationComponents.route){
            popUpTo(Components.SplashComponents.route) {
                inclusive = true
            }
        }
    }
}