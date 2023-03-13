package com.ircarren.lasagradafamilia.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import androidx.navigation.navigation
import com.ircarren.lasagradafamilia.navigation.routes.AppScreen
import com.ircarren.lasagradafamilia.screens.DescubreScreen
import com.ircarren.lasagradafamilia.screens.EntradasScreen
import com.ircarren.lasagradafamilia.screens.VisitaScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.Descubre.route) {
        composable(route = AppScreen.Descubre.route) {
            DescubreScreen(navController = navController)
        }
        composable(route = AppScreen.Entradas.route) {
            EntradasScreen(navController = navController)
        }
        composable(route = AppScreen.Visita.route) {
            VisitaScreen(navController = navController)
        }
    }
}