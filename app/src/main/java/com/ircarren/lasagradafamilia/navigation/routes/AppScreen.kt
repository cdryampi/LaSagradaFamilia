package com.ircarren.lasagradafamilia.navigation.routes

sealed class AppScreen(
    val route: String
){
    object Descubre : AppScreen("Descubre")
    object Entradas : AppScreen("Entradas")
    object Visita : AppScreen("Visita")
}
