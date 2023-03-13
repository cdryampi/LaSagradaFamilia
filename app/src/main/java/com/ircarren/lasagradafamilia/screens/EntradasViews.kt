package com.ircarren.lasagradafamilia.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ircarren.lasagradafamilia.R
import com.ircarren.lasagradafamilia.models.Entrada
import com.ircarren.lasagradafamilia.providers.EntradaProvider


// Funcion que genera una EntradasScreenNav -> principal

@Composable
fun EntradasScreenHome(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        val painter: Painter = painterResource(id = R.drawable.home)
        imgMain(painter = painter)
        Spacer(modifier = Modifier.height(8.dp))
        EntradasContainer()
        EntradasList()
        blankSpace()
    }

}

// Funcion que genera un contenedor de entradasScreenHome -> principal
@Composable
fun EntradasContainer(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = 20.dp, topEnd = 20.dp, bottomStart = 0.dp, bottomEnd = 0.dp
                )
            )
            .background(Color.Gray)
            .fillMaxSize()

    ) {
        EntradasTitle()
    }

}

// Funcion que genera una EntradasScreenNav -> principal
@Composable
fun EntradasTitle(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.White)
            .padding(8.dp)
    ) {
        Text(text = "Comprar Entradas", color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

// Funcion que genera una lista de entradas -> principal
@Composable
fun EntradasList(modifier: Modifier = Modifier) {
    val entradas = EntradaProvider.entrada_data
    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(entradas.size) { index ->
            EntradaCard(entrada = entradas[index], modifier = Modifier.padding(32.dp))
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntradaCard(entrada: Entrada, modifier: Modifier = Modifier) {
    Card(modifier = Modifier
        .width(320.dp)
        .height(200.dp)
        , shape = RoundedCornerShape(10.dp)) {
        Box(modifier = Modifier.fillMaxWidth()) {

            Box(modifier = Modifier.height(95.dp)) {

                Image(
                    painter = painterResource(id = entrada.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
            ,
            contentAlignment = Alignment.BottomStart


        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = entrada.titulo, style = TextStyle(color = Color.Black, fontSize = 16.sp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Row() {
                        ElevatedButton(
                            onClick = {},
                            modifier = Modifier,
                            colors = ButtonDefaults.elevatedButtonColors(Color.Red)
                        ) {
                            Text(text = "Comprar", color = Color.White)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        ElevatedButton(
                            onClick = {},
                            modifier = Modifier,
                            colors = ButtonDefaults.elevatedButtonColors(Color.White)
                        ) {
                            Text(text = "Info", color = Color.Red)
                        }
                    }
                    Row() {
                        Text(
                            text = entrada.precio.toString().split(".")[0]+"€", style = TextStyle(color = Color.Black, fontSize = 16.sp)
                        )
                    }

                }

            }

        }
    }
    Spacer(modifier = Modifier.width(8.dp))
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardInFooter() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(10.dp),

    ) {
        Row(modifier = Modifier
            .background(Color.Red)
            .fillMaxSize()
            .padding(horizontal = 32.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Box() {
                // icono de la card
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Box() {
                Column {
                    Text(text = "Contenido de la Card")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Contenido de la Card")
                }
            }
            Box() {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

    }

}