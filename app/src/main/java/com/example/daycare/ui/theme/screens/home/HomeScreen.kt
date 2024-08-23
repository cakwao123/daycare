package com.example.daycare.ui.theme.screens.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.daycare.R
import com.example.daycare.navigation.ROUT_HOME
import com.example.daycare.ui.theme.newpink
import com.example.daycare.ui.theme.newwhite


@Composable
fun HomeScreen(navController: NavController){
    Column (modifier = Modifier
        .fillMaxSize()
        .background(newwhite),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text ="Carols Daycare",
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Magenta
        )

        Image(
            painter = painterResource(id = R.drawable.childcare),
            contentDescription ="home",
            modifier = Modifier
                .size(350.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop

        )

        Text(
            text ="Carols Daycare",
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Black
        )
        Text(
            text = "Let your child grow in faith",
            fontSize = 25.sp ,
            color = Color.Magenta

        )

        Spacer(modifier = Modifier.height(140.dp))

        Button(onClick = { navController.navigate(ROUT_HOME)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(Color.Black),
            shape = RoundedCornerShape(10.dp)


        ) {
            Text(text = "ENROLL NOW")
            
        }

    }


}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}

