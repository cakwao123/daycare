package com.example.daycare.ui.theme.screens.activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.daycare.ui.theme.mybackground
import com.example.daycare.ui.theme.mybackground1



@Composable
fun ActivityScreen(navController: NavController){
  Column (
    modifier = Modifier
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
    Spacer(modifier = Modifier.height(5.dp))
    Text(
      text ="DAILY SCHEDULE",
      fontSize = 35.sp,
      fontFamily = FontFamily.SansSerif,
      color = Color.Black,
      modifier = Modifier.fillMaxWidth(),
      textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.height(5.dp))

    Column (modifier = Modifier.verticalScroll(rememberScrollState())){
      Card(modifier = Modifier
        .fillMaxWidth()
        .height(700.dp),
        shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
        colors = CardDefaults.cardColors(mybackground1)

      ){
        Image(
          painter = painterResource(id = R.drawable.activity),
          contentDescription = "image",
          modifier = Modifier.fillMaxSize(),
          contentScale = ContentScale.Crop

        )
        Spacer(modifier = Modifier.height(5.dp))
      }










































      }
    Spacer(modifier = Modifier.height(5.dp))

    }




  }




@Composable
@Preview(showBackground = true)
fun ActivityScreenPreview(){
  ActivityScreen(rememberNavController())
}
