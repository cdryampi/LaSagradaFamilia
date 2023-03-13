package com.ircarren.lasagradafamilia.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.ircarren.lasagradafamilia.View.FormView
import com.ircarren.lasagradafamilia.providers.IconProvider
import com.ircarren.lasagradafamilia.ui.theme.LaSagradaFamiliaTheme


// funcion que genera un SootheNavBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SootheNavBar(navController: NavController) {
    LaSagradaFamiliaTheme() {
        Scaffold(bottomBar = {
            bottomNavigation(navController = navController)
        }) { paddingValues ->

            when (IconProvider.icons.find { it.isSelected }?.title) {
                "Entradas" -> {
                    EntradasScreenNav(Modifier.padding(paddingValues))
                }
                "Visita" -> {
                    VisitaScreenNav(Modifier.padding(paddingValues))
                }
                "Descubre" -> {
                    DescubreScreenNav(Modifier.padding(paddingValues))
                }
            }

        }
    }
}


// Funcion que genera una HomeScreen
@Composable
fun DescubreScreenNav(modifier: Modifier = Modifier) {

    mainContainer()
}

// Funcion que genera una VistaScreenNav
@Composable
fun VisitaScreenNav(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        var formView = FormView()
        formView.MainScrrenForm()
    }
}


// Funcion que genera una EntradasScreen
@Composable
fun EntradasScreenNav(modifier: Modifier = Modifier){
    EntradasScreenHome()
}


// funcion que crea el bottom navigation
@Composable
fun bottomNavigation(modifier: Modifier = Modifier, navController: NavController) {

    val icons = IconProvider.icons
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        NavigationBar(containerColor = Color.White.copy(alpha = 0.9f)) {
            icons.forEachIndexed { index, icono ->
                NavigationBarItem(
                    selected = icono.isSelected,
                    onClick = {
                        IconProvider.icons.forEach { icon ->
                            icon.isSelected = icon.title == icono.title
                        }
                        IconProvider.icons.forEach { icon ->
                            println(icon)
                        }
                        navController.navigate(route = icono.route)
                    },
                    icon = { Icon(imageVector = icono.icon, contentDescription = icono.title) },
                    label = { Text(text = icono.title) }
                )
            }
        }
    }
}