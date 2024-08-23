package com.example.daycare.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


import com.example.daycare.R
import com.example.daycare.data.AuthViewModel
import com.example.daycare.navigation.ROUT_ABOUT
import com.example.daycare.navigation.ROUT_HOME
import com.example.daycare.navigation.ROUT_SIGNUP
import com.example.daycare.ui.theme.mybackground
import com.example.daycare.ui.theme.mybackground1
import com.example.daycare.ui.theme.mybrown

@Composable
fun LoginScreen(navController: NavController){
    Column(
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
                .size(200.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop

        )
        Spacer(modifier = Modifier.height(10.dp))



        Column {
            Card(modifier = Modifier.fillMaxWidth().height(700.dp),
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
                colors = CardDefaults.cardColors(mybackground1)){
                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text ="Carols Daycare",
                    fontSize = 40.sp,
                    fontFamily = FontFamily.Cursive,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text ="Already have an account.Please enter your credentials",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center
                )
                var email by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = email,
                    onValueChange = {email=it},
                    label = { Text(text = "email", color = Color.White,)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Person", tint = Color.Magenta) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = password,
                    onValueChange = {password=it},
                    label = { Text(text = "password", color = Color.White)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Person", tint = Color.Magenta) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
                Spacer(modifier = Modifier.height(10.dp))

                val context = LocalContext.current
                val authViewModel = AuthViewModel(navController, context)


                Button(onClick = {  authViewModel.login(email, password)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(mybackground),
                    shape = RoundedCornerShape(10.dp)


                ) {
                    Text(text = "Login as a Parent")
                }
                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = {  authViewModel.adminlogin(email, password)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(mybackground),
                    shape = RoundedCornerShape(10.dp)


                ) {
                    Text(text = "Login as Admin")
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text ="Do not have an account?Sign up.",
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                        navController.navigate(ROUT_SIGNUP)
                    }
                    ,
                    color = Color.White,
                )





            }
        }
    }


}

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview(){
    LoginScreen(rememberNavController())
}
