package com.ircarren.lasagradafamilia.providers

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import com.ircarren.lasagradafamilia.models.Icono
import com.ircarren.lasagradafamilia.navigation.routes.AppScreen

class IconProvider {
    companion object {
        var icons = listOf<Icono>(
            Icono(Icons.Filled.Home, "Descubre", AppScreen.Descubre.route, true),
            Icono(Icons.Filled.Favorite, "Entradas", AppScreen.Entradas.route, false),
            Icono(Icons.Default.Add, "Visita", AppScreen.Visita.route, false)
        )
    }
}