package com.example.daycare.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.daycare.ui.theme.screens.login.LoginScreen
import com.example.daycare.ui.theme.screens.about.AboutScreen
import com.example.daycare.ui.theme.screens.account.AddAccountScreen
import com.example.daycare.ui.theme.screens.account.ViewAccountScreen
import com.example.daycare.ui.theme.screens.activity.ActivityScreen
import com.example.daycare.ui.theme.screens.admindashboard.AdminDashboardScreen
import com.example.daycare.ui.theme.screens.communication.CommunicationScreen
import com.example.daycare.ui.theme.screens.dashboard.DashboardScreen
import com.example.daycare.ui.theme.screens.emergency.AddEmergencyScreen
import com.example.daycare.ui.theme.screens.emergency.ViewEmergencyScreen
import com.example.daycare.ui.theme.screens.home.HomeScreen
import com.example.daycare.ui.theme.screens.payment.AddPaymentScreen
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
        composable(ROUT_ACTIVITY) {
          ActivityScreen(navController = navController)
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

        composable(ROUT_COMMUNICATION) {
            CommunicationScreen(navController = navController)
        }

        composable(ADD_ACCOUNT){
            AddAccountScreen(navController = navController)
        }

        composable(VIEW_ACCOUNT){
            ViewAccountScreen(navController = navController)
        }

        composable(ADD_EMERGENCY){
            AddEmergencyScreen(navController = navController)
        }
        composable(ADD_PAYMENT){
            AddPaymentScreen(navController = navController)
        }

        composable(VIEW_EMERGENCY){
            ViewEmergencyScreen(navController = navController)
        }
        composable(ROUT_ADMINDASHBOARD){
            AdminDashboardScreen(navController= navController)
        }




    }

}
