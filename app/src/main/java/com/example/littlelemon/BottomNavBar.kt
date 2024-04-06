package com.example.littlelemon

import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(navController: NavController) {
    BottomAppBar {
        BottomNavigationItem(
            selected = navController.currentBackStackEntryAsState().value?.destination?.route == HomePageRoute.route,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home Icon") },
            label = { Text(text = "Home", style = MaterialTheme.typography.h2)}
        )
        BottomNavigationItem(
            selected = navController.currentBackStackEntryAsState().value?.destination?.route == MenuPageRoute.route,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu") },
            label = { Text(text = "Menu", style = MaterialTheme.typography.h2)}
        )
    }
}