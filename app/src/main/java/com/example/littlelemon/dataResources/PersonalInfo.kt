package com.example.littlelemon.dataResources

import androidx.compose.runtime.mutableStateOf

object PersonalInfo {
    var name = mutableStateOf("guest")
    var password = mutableStateOf("abc123")
    var logged = mutableStateOf(false)
}