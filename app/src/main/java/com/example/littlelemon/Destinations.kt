package com.example.littlelemon

interface Destinations {
    val route: String
}

object Home : Destinations {
    override val route = "Home"
}

object DishDetails : Destinations {
    override val route = "Menu"
    const val argDishId = "dishId"
}

object HomePageRoute : Destinations {
    override val route = "HomePage"
}

object MenuPageRoute : Destinations {
    override val route = "MenuPage"
}

object OrderPage : Destinations {
    override val route = "OrderPage"
}
