package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DishDetails(id: Int, navController: NavController) {
    val dish = requireNotNull(DishRepository.getDish(id))
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        //TODO: Insert code here
        Image(
            painter = painterResource(id = dish.imageResource),
            contentDescription = "Dish image",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Column (
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        ) {
            Text(text = dish.name, style = MaterialTheme.typography.h1)
            Text(text = dish.description, style = MaterialTheme.typography.body1)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {
                TextButton(
                    onClick = {
                        if (OrderList.orderList[dish.id - 1] > 0) OrderList.orderList[dish.id - 1]--
                    }
                ) {
                    Text(
                        text = "-",
                        style = MaterialTheme.typography.h2
                    )
                }
                Text(
                    text = OrderList.orderList[dish.id - 1].toString(),
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.padding(16.dp)
                )
                TextButton(
                    onClick = {
                        OrderList.orderList[dish.id - 1]++
                    }
                ) {
                    Text(
                        text = "+",
                        style = MaterialTheme.typography.h2
                    )
                }
            }
            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text(
                    text = stringResource(id = R.string.add_for) + " $${dish.price}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().align(Alignment.CenterVertically)
                )
            }

            
        }
        
    }
}

