package com.example.littlelemon

import androidx.compose.runtime.mutableStateOf

object PersonalInfo {
    var name = mutableStateOf("guest")
    var password = mutableStateOf("abc123")
    var logged = mutableStateOf(false)
}