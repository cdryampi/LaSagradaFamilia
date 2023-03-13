package com.ircarren.lasagradafamilia.providers

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import com.ircarren.lasagradafamilia.models.RedSocial

class SocialProvider {
    companion object{
        var redesSociales = listOf<RedSocial>(
            RedSocial("Facebook", "https://www.facebook.com/LaSagradaFamilia", Icons.Filled.AccountBox),
            RedSocial("Twitter", "https://twitter.com/LaSagradaFamilia", Icons.Filled.Add),
            RedSocial("Instagram", "https://www.instagram.com/lasagradafamilia/", Icons.Filled.ArrowDropDown)
        )
    }
}