package com.example.daycare.ui.theme.screens.account

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.daycare.data.AccountViewModel
import com.example.daycare.models.Account
import com.example.daycare.ui.theme.mybackground


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ViewAccountScreen(navController:NavHostController) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(mybackground),
      horizontalAlignment = Alignment.CenterHorizontally



    ) {

        var context = LocalContext.current
        var accountRepository = AccountViewModel(navController, context)


        val emptyAccountState = remember { mutableStateOf(Account("","","","","")) }
        var emptyAccountsListState = remember { mutableStateListOf<Account>() }

        var accounts = accountRepository.ViewAccount(emptyAccountState, emptyAccountsListState)



        Spacer(modifier = Modifier.height(50.dp))


         Text(
             text = "Registered Children",
             fontSize = 18.sp,
             fontFamily = FontFamily.SansSerif
         )


                    Spacer(modifier = Modifier.height(20.dp))

                    LazyColumn(){
                        items(accounts){
                            AccountItem(
                                name = it.name,
                                age = it.email,
                                email = it.age,
                                id = it.id,
                                navController = navController,
                                accountRepository = accountRepository,
                                accountImage = it.imageUrl
                            )
                        }
                    }

    }
}







@Composable
fun AccountItem(name:String, age:String, email:String, id:String,
                navController:NavHostController,
                accountRepository:AccountViewModel, accountImage:String) {

    //1 item


        Card (modifier = Modifier
            .height(200.dp)
            .width(370.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberAsyncImagePainter(accountImage),
                    contentDescription = "null",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

            }
        }
            Text(text ="Account Name : $name",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Default,
                color = Color.Black
            )


            Text(text = "Age : $email",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.Default,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(text = "Email : $age",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Default,
                color = Color.Black
            )
        Spacer(modifier = Modifier.height(5.dp))

        Row {

            Button(onClick = { accountRepository.updateAccount(id)},
                shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp),
                colors = ButtonDefaults.buttonColors(Color.Green),) {
                Row {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "", tint = Color.White)
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(text = "Update")

                }
            }


            Spacer(modifier = Modifier.width(5.dp))

            Button(onClick = { accountRepository.deleteAccount(id)},
                shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp),
                colors = ButtonDefaults.buttonColors(Color.Red),) {
                Row {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "", tint = Color.White)
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(text = "Delete")

                }
            }


        }
        Spacer(modifier = Modifier.height(5.dp))


        Divider()








        //end 1 item

    }









@Composable
@Preview(showBackground = true)
fun ViewAccountScreenPreview(){

    ViewAccountScreen(navController = rememberNavController())

}




