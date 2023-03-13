package com.ircarren.lasagradafamilia.providers

import com.ircarren.lasagradafamilia.R
import com.ircarren.lasagradafamilia.models.Entrada

class EntradaProvider {

    companion object{
        var entrada_data = listOf<Entrada>(
            Entrada("Sagrada familia", "https://sagradafamilia.org/es/home", 25.00, R.drawable.img3),
            Entrada("Sagrada familia con visita guiada", "https://sagradafamilia.org/es/home", 30.00, R.drawable.img1),
            Entrada("Sagrada familia con Guía y visita a las Torres", "https://sagradafamilia.org/es/home", 40.00, R.drawable.img3),
            Entrada("Sagrada familia con torres", "https://sagradafamilia.org/es/home", 36.00, R.drawable.img4),
            Entrada("Grupos", "https://sagradafamilia.org/es/home", 25.00, R.drawable.img1)
        )
    }
}