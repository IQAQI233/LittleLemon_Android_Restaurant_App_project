package com.example.littlelemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Popup
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.DrawerScreen

@Composable
fun HomeScreen(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val navController2 = rememberNavController()
    Scaffold (
        topBar = { TopAppBar(scaffoldState, scope) },
        drawerContent = { DrawerScreen(scaffoldState, scope, navController) },
        bottomBar = { BottomBar(navController = navController2) }
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController2,
            startDestination = HomePageRoute.route,
            ent
        ) {
            composable(
                HomePageRoute.route
            ) {
                Column (modifier = Modifier.fillMaxSize()) {
                    UpperPanel()
                    LowerPanel(navController, DishRepository.dishes)
                }
            }
        }

    }
}
