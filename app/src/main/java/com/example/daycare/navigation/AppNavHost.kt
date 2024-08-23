package com.example.daycare.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.DayCare.ui.theme.screens.login.LoginScreen
import com.example.daycare.ui.theme.screens.about.AboutScreen
import com.example.daycare.ui.theme.screens.communication.CommunicationScreen
import com.example.daycare.ui.theme.screens.dashboard.DashboardScreen
import com.example.daycare.ui.theme.screens.emergency.EmergencyScreen
import com.example.daycare.ui.theme.screens.home.HomeScreen
import com.example.daycare.ui.theme.screens.payment.PaymentScreen
import com.example.daycare.ui.theme.screens.registration.RegistrationScreen
import com.example.daycare.ui.theme.screens.signup.SignupScreen
import com.example.daycare.ui.theme.screens.splash.splashscreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination:String = ROUT_SPLASH
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    )
    {
        composable(ROUT_HOME) {
            HomeScreen(navController = navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController = navController)
        }

        composable(ROUT_SPLASH) {
            splashscreen(navController = navController)
        }

        composable(ROUT_SIGNUP) {
            SignupScreen(navController = navController)
        }
        composable(ROUT_LOGIN) {
            LoginScreen(navController = navController)
        }
        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController = navController)
        }
        composable(ROUT_REGISTRATION) {
            RegistrationScreen(navController = navController)
        }
        composable(ROUT_COMMUNICATION) {
            CommunicationScreen(navController = navController)
        }
        composable(ROUT_EMERGENCY) {
            EmergencyScreen(navController = navController)
        }
        composable(ROUT_PAYMENT) {
            PaymentScreen(navController = navController)
        }








    }

}