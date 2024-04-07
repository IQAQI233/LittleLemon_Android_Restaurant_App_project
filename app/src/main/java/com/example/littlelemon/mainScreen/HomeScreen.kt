package com.example.littlelemon.mainScreen

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
import com.example.littlelemon.dataResources.BasketPageRoute
import com.example.littlelemon.dataResources.DishRepository
import com.example.littlelemon.dataResources.HomePageRoute
import com.example.littlelemon.dataResources.MenuPageRoute
import com.example.littlelemon.mainScreen.scaffoldWidgets.BottomBar
import com.example.littlelemon.mainScreen.scaffoldWidgets.DrawerScreen
import com.example.littlelemon.mainScreen.scaffoldWidgets.TopAppBar

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
                com.example.littlelemon.dataResources.DishDetails.route + "/{${com.example.littlelemon.dataResources.DishDetails.argDishId}}",
                arguments = listOf(navArgument(com.example.littlelemon.dataResources.DishDetails.argDishId) { type = NavType.IntType })
            ) {
                val id = requireNotNull(it.arguments?.getInt(com.example.littlelemon.dataResources.DishDetails.argDishId)) { "Dish id is null" }
                DishDetails(id, navController2)
            }

            composable(BasketPageRoute.route) {
                Basket(navController2)
            }
        }

    }
}
