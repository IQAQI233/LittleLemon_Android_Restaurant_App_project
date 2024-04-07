package com.example.littlelemon.mainScreen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.R
import com.example.littlelemon.dataResources.DishRepository
import com.example.littlelemon.dataResources.OrderList

@Composable
fun Basket(navController2: NavHostController) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_cart), contentDescription = "Basket", modifier = Modifier.size(40.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text ="Contents in basket:",
                style = MaterialTheme.typography.h1,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
        LazyColumn (modifier = Modifier.weight(1f)) {
            itemsIndexed(DishRepository.dishes) { index, dish ->
                if (OrderList.orderList[index] != 0) {
                    MenuDish(dish = dish)
                }
            }
        }
        Divider(modifier = Modifier.fillMaxWidth(0.8f), color = MaterialTheme.colors.primary)
        val price = remember {
            derivedStateOf {
                var temp = 0.0
                for (i in DishRepository.dishes) {
                    if (OrderList.orderList[i.id - 1] > 0) {
                        temp += OrderList.orderList[i.id - 1] * i.price
                    }
                }
                return@derivedStateOf temp
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text ="Total price: $${"%.2f".format(price.value)}",
                style = MaterialTheme.typography.h1,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        val context = LocalContext.current
        Button(
            onClick = { navController2.popBackStack(); Toast.makeText(context, "Order Successful, thank you!", Toast.LENGTH_LONG).show() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Send the order!", style = MaterialTheme.typography.h2)
        }
    }
}