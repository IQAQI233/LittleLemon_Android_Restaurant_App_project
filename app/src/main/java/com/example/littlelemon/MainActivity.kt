package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.dataResources.Home
import com.example.littlelemon.dataResources.LoginPageRoute
import com.example.littlelemon.dataResources.RegisterPageRoute
import com.example.littlelemon.loginScreen.LogIn
import com.example.littlelemon.loginScreen.Register
import com.example.littlelemon.mainScreen.HomeScreen
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = LoginPageRoute.route) {
                    composable(Home.route) {
                        HomeScreen(navController)
                    }
                    composable(LoginPageRoute.route) {
                        LogIn(navController = navController)
                    }
                    composable(RegisterPageRoute.route) {
                        Register(navController = navController)
                    }
                }
            }
        }
    }
}


