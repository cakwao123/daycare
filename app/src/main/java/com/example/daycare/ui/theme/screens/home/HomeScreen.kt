package com.example.daycare.ui.theme.screens.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.daycare.R
import com.example.daycare.navigation.ADD_ACCOUNT
import com.example.daycare.navigation.ROUT_ABOUT
import com.example.daycare.navigation.ROUT_DASHBOARD
import com.example.daycare.navigation.ROUT_HOME
import com.example.daycare.ui.theme.mybackground
import com.example.daycare.ui.theme.newpink
import com.example.daycare.ui.theme.newwhite


@Composable
fun HomeScreen(navController: NavController){
    Column (modifier = Modifier
        .fillMaxSize()
        .background(mybackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ){


        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription ="home",
            modifier = Modifier
                .size(100.dp)


        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text ="Carols Daycare",
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )





        Spacer(modifier = Modifier.height(10.dp))

     Column {
         Card(modifier = Modifier
                 .fillMaxWidth()
                 .height(200.dp).padding(start = 10.dp, end = 10.dp)
         ){
             Box(
                 modifier = Modifier.fillMaxSize(),
                 contentAlignment = Alignment.Center
             ) {
                 Image(
                     painter = painterResource(id = R.drawable.image1),
                     contentDescription = "image",
                     modifier = Modifier.fillMaxSize(),
                     contentScale = ContentScale.Crop

                 )
                 Icon(
                     imageVector = Icons.Default.Favorite,
                     contentDescription = "",
                     modifier = Modifier
                         .align(Alignment.TopStart)
                         .padding(10.dp)
                 )

             }

             Text(
                 text = "Let your child grow in faith",
                 fontSize = 20.sp,
                 color = Color.White,
                 modifier = Modifier.fillMaxWidth(),
                 textAlign = TextAlign.Center

             )
         }

     }

        Spacer(modifier = Modifier.height(40.dp))

        Column {
            Card(modifier = Modifier.fillMaxWidth().height(200.dp).padding(start = 10.dp, end = 10.dp)
            ){

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.art),
                        contentDescription = "image",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop

                    )
                    Icon(imageVector = Icons.Default.Favorite,
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(10.dp))

                }
            }
            Text(
                text = "Curious minds happy hearts",
                fontSize = 20.sp ,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center

            )

        }











        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = { navController.navigate(ROUT_ABOUT)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(Color.Black),
            shape = RoundedCornerShape(10.dp)


        ) {
            Text(text = "WELCOME")

        }

    }


}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}

