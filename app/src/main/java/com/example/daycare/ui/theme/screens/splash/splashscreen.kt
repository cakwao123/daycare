package com.example.daycare.ui.theme.screens.splash

import android.annotation.SuppressLint
import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.daycare.R
import com.example.daycare.navigation.ROUT_LOGIN
import com.example.daycare.ui.theme.mybackground
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun splashscreen(navController: NavController){
    Column (modifier = Modifier
        .fillMaxSize()
        .background(mybackground),
        verticalArrangement =Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var coroutineScope = rememberCoroutineScope()
        coroutineScope.launch {
            delay(timeMillis = 2000)
            navController.navigate(ROUT_LOGIN)
        }
        Spacer(modifier = Modifier.height(5.dp))


        Text(
            text ="Carol's",
            fontSize = 70.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Red
        )

        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.daycare),
            contentDescription ="image",
            modifier = Modifier.fillMaxWidth()

        )



















    }


}

@Composable
@Preview(showBackground = true)
fun splashscreenPreview(){
    splashscreen(rememberNavController())

}