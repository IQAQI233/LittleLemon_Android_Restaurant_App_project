package com.example.littlelemon

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Register(navController: NavController) {
    var username = rememberSaveable() { mutableStateOf("") }
    var password = rememberSaveable() { mutableStateOf("") }
    var passwordVisibility = rememberSaveable() { mutableStateOf(false) }
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    Column (
        modifier = Modifier.fillMaxSize().verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.wrapContentSize()) {
            Image(painter = painterResource(id = R.drawable.littlelemontxt), contentDescription = "Background")
            Image(painter = painterResource(id = R.drawable.littlelemonimg), contentDescription = "Lemon")
        }
        TextField(
            value = username.value,
            onValueChange = { username.value = it},
            label = { Text(text = "Set Username", style = MaterialTheme.typography.h2) },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            placeholder = { Text(text = "Format: xxxx@mail.com") }
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = password.value,
            onValueChange = { password.value = it},
            label = { Text(text = "Set Password", style = MaterialTheme.typography.h2) },
            singleLine = true,
            visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                Icon(
                    imageVector = if (passwordVisibility.value) Icons.Filled.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = "Visibility",
                    modifier = Modifier.clickable { passwordVisibility.value = !passwordVisibility.value }
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            placeholder = { Text(text = "Password must be at least 6 digits!!!") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (password.value.length >= 6 && username.value != "") {
                    Toast.makeText(context, "${PersonalInfo.name.value} register successful!", Toast.LENGTH_LONG).show()
                    PersonalInfo.name.value = username.value
                    PersonalInfo.password.value = password.value
                    navController.navigate(LoginPageRoute.route)
                } else if (username.value == "") {
                    Toast.makeText(context, "Username cannot be empty!!!!", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Password is too short!!!!", Toast.LENGTH_LONG).show()
                }
            }
        ) {
            Text(text = "Register Now", style = MaterialTheme.typography.h2)
        }

        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Already have an account?" +
                    "Log in now!!",
            textAlign = TextAlign.Center,
            modifier = Modifier.clickable {
                navController.navigate(LoginPageRoute.route) {
                    popUpTo(LoginPageRoute.route)
                    launchSingleTop = true
                }
            },
            textDecoration = TextDecoration.Underline,
            color = Color.Blue
        )
    }
}
