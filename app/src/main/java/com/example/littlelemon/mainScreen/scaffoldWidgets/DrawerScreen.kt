package com.example.littlelemon.mainScreen.scaffoldWidgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.R
import com.example.littlelemon.dataResources.LoginPageRoute
import com.example.littlelemon.dataResources.PersonalInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerScreen(
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    navController: NavHostController
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.onPrimary),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Header()
        Text(
            text = PersonalInfo.name.value.replaceFirstChar { if (it.isLowerCase()) it.uppercaseChar() else it },
            style = MaterialTheme.typography.h1
        )
        Divider(
            modifier = Modifier.padding(vertical = 15.dp),
            thickness = 1.dp,
        )
        Text(
            text = "Welcome to Little Lemon, ${PersonalInfo.name.value}!",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(30.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate(LoginPageRoute.route) }
                .padding(horizontal = 30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.AutoMirrored.Filled.Logout, contentDescription = "Log Out")
            Spacer(modifier = Modifier.width(15.dp))
            Text(text = "Log Out", style = MaterialTheme.typography.h2)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .clickable { scope.launch { scaffoldState.drawerState.close() } }
                .padding(horizontal = 30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Exit")
            Spacer(modifier = Modifier.width(15.dp))
            Text(text = "Back to Home", style = MaterialTheme.typography.h2)
        }
    }
}

@Composable
fun Header() {
    Image(
        painter = painterResource(id = R.drawable.upperpanelimage),
        contentDescription = "Avatar",
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(10.dp)
            .clip(CircleShape)
    )
}