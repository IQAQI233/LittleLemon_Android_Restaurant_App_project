package com.example.littlelemon

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.ui.theme.LittleLemonColor

@Composable
fun MenuPage(navController2: NavHostController) {
    LazyColumn (modifier = Modifier.fillMaxSize()) {
        itemsIndexed(DishRepository.dishes) {_, dish ->
            MenuDish(dish = dish, navController = navController2)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuDish(navController: NavHostController? = null, dish: Dish) {
    Card(
        onClick = {
            Log.d("AAA", "Click ${dish.id}")
            navController?.navigate(DishDetails.route + "/${dish.id}")
        }
    ) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
            Column {
                Text(text = dish.name, style = MaterialTheme.typography.h2)
                Text(
                    text = dish.description,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .padding(top = 5.dp, bottom = 5.dp)
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text = "$${dish.price}", style = MaterialTheme.typography.body2)
                    TextButton(
                        onClick = {
                            if (OrderList.orderList[dish.id - 1] > 0) OrderList.orderList[dish.id - 1]--
                        }
                    ) {
                        Text(
                            text = "-",
                            style = MaterialTheme.typography.body2
                        )
                    }
                    Text(
                        text = OrderList.orderList[dish.id - 1].toString(),
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    TextButton(
                        onClick = {
                            OrderList.orderList[dish.id - 1]++
                        }
                    ) {
                        Text(
                            text = "+",
                            style = MaterialTheme.typography.body2
                        )
                    }
                }
            }
            Image(
                painter = painterResource(id = dish.imageResource),
                contentDescription = "dish image",
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            )
        }
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        thickness = 1.dp,
        color = LittleLemonColor.yellow
    )
}