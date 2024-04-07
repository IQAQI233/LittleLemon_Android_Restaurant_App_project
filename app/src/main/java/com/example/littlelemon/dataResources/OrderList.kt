package com.example.littlelemon.dataResources

import androidx.compose.runtime.mutableStateListOf

object OrderList {
    val orderList = mutableStateListOf<Int>().apply { repeat(DishRepository.dishes.size) { add(0) } }
}