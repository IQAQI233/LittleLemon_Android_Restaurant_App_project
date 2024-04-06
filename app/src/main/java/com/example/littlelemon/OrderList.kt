package com.example.littlelemon

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSaveable

object OrderList {
    val orderList = mutableStateListOf<Int>().apply { repeat(DishRepository.dishes.size) { add(0) } }
}