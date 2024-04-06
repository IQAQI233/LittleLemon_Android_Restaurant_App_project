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

object OrderPageRoute : Destinations {
    override val route = "OrderPage"
}

object LoginPageRoute : Destinations {
    override val route = "LoginPage"
}

object RegisterPageRoute : Destinations {
    override val route = "RegisterPage"
}

object BasketPageRoute : Destinations {
    override val route = "BasketPage"
}