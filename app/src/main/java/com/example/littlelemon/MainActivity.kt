package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.PopUpToBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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


