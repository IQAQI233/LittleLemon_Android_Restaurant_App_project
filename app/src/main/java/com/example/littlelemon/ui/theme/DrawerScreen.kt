package com.example.littlelemon.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.PersonalInfo
import com.example.littlelemon.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerScreen(
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    navController: NavHostController
) {
    Column (
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.onPrimary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Header()
        Text(text = PersonalInfo.name.value, style = MaterialTheme.typography.h2)
        Divider(
            modifier = Modifier.padding(vertical = 15.dp),
            thickness = 1.dp,
        )
        Text(
            text = "Welcome to Little Lemon, ${PersonalInfo.name.value}!",
            style = MaterialTheme.typography.body1
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .clickable { scope.launch { scaffoldState.drawerState.close() } }
                .padding(15.dp)
        ) {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Exit")
            Text(text = "Back to Home", style = MaterialTheme.typography.body2)
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .clickable { scope.launch { scaffoldState.drawerState.close() } }
                .padding(15.dp)
        ) {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Exit")
            Text(text = "Back to Home", style = MaterialTheme.typography.body2)
        }
    }
}

@Composable
fun Header() {
    Image(
        painter = painterResource(id = R.drawable.upperpanelimage),
        contentDescription = "Avatar",
        modifier = Modifier
            .clip(CircleShape)
            .fillMaxWidth()
            .padding(10.dp)
    )
    }
}