package com.example.littlelemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun HomeScreen(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val navController2 = rememberNavController()
    Scaffold (
        topBar = { TopAppBar(scaffoldState, scope, navController2) },
        drawerContent = { DrawerScreen(scaffoldState, scope, navController) },
        bottomBar = { BottomBar(navController = navController2) },
        scaffoldState = scaffoldState
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController2,
            startDestination = HomePageRoute.route,
        ) {
            composable(
                HomePageRoute.route
            ) {
                Column (modifier = Modifier.fillMaxSize()) {
                    UpperPanel(navController2)
                    LowerPanel(navController2, DishRepository.dishes)
                }
            }

            composable(MenuPageRoute.route) {
                MenuPage(navController2)
            }


            composable(
                DishDetails.route + "/{${DishDetails.argDishId}}",
                arguments = listOf(navArgument(DishDetails.argDishId) { type = NavType.IntType })
            ) {
                val id = requireNotNull(it.arguments?.getInt(DishDetails.argDishId)) { "Dish id is null" }
                DishDetails(id, navController2)
            }

            composable(BasketPageRoute.route) {
                Basket(navController2)
            }
        }

    }
}
