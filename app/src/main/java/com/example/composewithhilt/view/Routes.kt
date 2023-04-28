package com.example.composewithhilt.view

sealed class Routes(val route: String) {
    object Home: Routes("Home Page")
    object PayOut: Routes("Pay Out")
    object Income: Routes("Income")
}