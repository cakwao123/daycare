package com.example.daycare.ui.theme.screens.communication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.daycare.R
import com.example.daycare.navigation.ROUT_DASHBOARD
import com.example.daycare.ui.theme.mybackground1


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CommunicationScreen(navController: NavController){

    Column (modifier = Modifier.fillMaxSize()) {
        val mContext= LocalContext.current



        var selected by remember { mutableIntStateOf(0) }
        Scaffold(
            bottomBar = {
                NavigationBar (containerColor = mybackground1) {
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge {
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(
                                        imageVector =
                                        if (index == selected)
                                            bottomNavItem.selectedIcon
                                        else
                                            bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title
                                    )
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }
            },
            topBar = {
                TopAppBar(
                    title = { Text(text = "About Us") },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(mybackground1),
                    navigationIcon = { IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "menu"
                        )
                    }}
                )
            },


            floatingActionButton = {FloatingActionButton(onClick = { /*TODO*/ }) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "menu"
                        )
                    }
                }
            },
            //Content Section
            content = @Composable{
                Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 80.dp, start = 20.dp),


                    ) {
                    //start row
                    Row {
                        //card 1
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(200.dp)
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.music),
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
                        //end of card 1
                        Column(modifier = Modifier.padding(start = 20.dp)){
                            Text(text = "Growing together,one day at a time", fontSize = 20.sp)
                            Text(text = "learn.play.care!")
                            Row {
                                Icon(imageVector = Icons.Default.Star, contentDescription = "")
                                Icon(imageVector = Icons.Default.Star, contentDescription = "")
                                Icon(imageVector = Icons.Default.Star, contentDescription = "")
                                Icon(imageVector = Icons.Default.Star, contentDescription = "")
                                Icon(imageVector = Icons.Default.Star, contentDescription = "")

                            }
                            Text(text = "4,580 reviews")


                        }


                    }
                    //end of row
                    Spacer(modifier = Modifier.height(10.dp))

                    //start row
                    Row {
                        //card 1
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(200.dp)
                        ) {
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
                        //end of card 1
                        Column(modifier = Modifier.padding(start = 20.dp)){
                            Text(text = "Let your child learn with faith", fontSize = 20.sp)
                            Text(text = "learn.play.care!")
                            Row {
                                Icon(imageVector = Icons.Default.Star, contentDescription = "")
                                Icon(imageVector = Icons.Default.Star, contentDescription = "")
                                Icon(imageVector = Icons.Default.Star, contentDescription = "")
                                Icon(imageVector = Icons.Default.Star, contentDescription = "")
                                Icon(imageVector = Icons.Default.Star, contentDescription = "")

                            }
                            Text(text = "24,580 reviews")


                        }


                    }
                    //end of row


                    Spacer(modifier = Modifier.height(10.dp))
                    //start row
                    Row {
                        //card 1
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(200.dp)
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.play),
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
                        //end of card 1
                        Column(modifier = Modifier.padding(start = 20.dp)){
                            Text(text = "Let your child learn with faith", fontSize = 20.sp)
                            Text(text = "learn.play.care!")
                            Row {
                                Icon(imageVector = Icons.Default.Star, contentDescription = "")
                                Icon(imageVector = Icons.Default.Star, contentDescription = "")
                                Icon(imageVector = Icons.Default.Star, contentDescription = "")
                                Icon(imageVector = Icons.Default.Star, contentDescription = "")
                                Icon(imageVector = Icons.Default.Star, contentDescription = "")

                            }
                            Text(text = "54,580 reviews")


                        }


                    }
                    //end of row

                    Spacer(modifier = Modifier.height(40.dp))

                    Button(onClick = { navController.navigate(ROUT_DASHBOARD)},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        shape = RoundedCornerShape(10.dp)


                    ) {
                        Text(text = "CALL")

                    }


                }
            }
        )
    }



}

val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon= Icons.Filled.Home,
        unselectedIcon= Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "login",
        route="login",
        selectedIcon= Icons.Filled.Person,
        unselectedIcon= Icons.Outlined.Person,
        hasNews = true,
        badges=5
    ),

    BottomNavItem(
        title = "Communication",
        route="communication",
        selectedIcon= Icons.Filled.Face,
        unselectedIcon= Icons.Outlined.Face,
        hasNews = true,
        badges=1
    ),


    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews :Boolean,
    val badges :Int
)


@Composable
@Preview(showBackground = true)
fun CommunicationScreenPreview(){
    CommunicationScreen(rememberNavController())
}
