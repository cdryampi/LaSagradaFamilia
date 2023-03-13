package com.ircarren.lasagradafamilia.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ircarren.lasagradafamilia.R
import com.ircarren.lasagradafamilia.providers.SocialProvider


// funcion que muestra el contenido principal
@Composable
fun mainContainer(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        val painter = painterResource(id = R.drawable.home)
        imgMain(painter = painter)
        Spacer(modifier = Modifier.height(8.dp))
        galeriaContainer()
        Spacer(modifier = Modifier.height(8.dp))
    }
}


// funcion que muestra la imagen principal
@Composable
fun imgMain(modifier: Modifier = Modifier, painter:Painter) {
    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier.fillMaxHeight(0.5f),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun galeriaContainer(modifier: Modifier = Modifier) {
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
        logo()
        galeria()
        DescubreItems()
        CardEntrada()
        fullWithCard()


    }
    socialFooter()
    Spacer(modifier = Modifier.height(8.dp))
    blankSpace()
}


// funcion que muestra el logo
@Composable
fun logo(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(100.dp)
            .width(150.dp)
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

    }

}


// funcion que muestra la galeria
@Composable
fun galeria(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(20.dp))
    ) {
        val (primer, segon, tercer, quart) = createRefs()
        // primer
        Box(modifier = Modifier
            .height(150.dp)
            .width(100.dp)
            .constrainAs(primer) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)

            }) {
            Image(
                painter = painterResource(id = R.drawable.img1),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
        // segon
        Box(modifier = Modifier
            .height(75.dp)
            .width(175.dp)
            .constrainAs(segon) {
                top.linkTo(parent.top)
                start.linkTo(primer.absoluteRight, margin = 2.dp)
            }) {
            Image(
                painter = painterResource(id = R.drawable.img2),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
        // tercer
        Box(modifier = Modifier
            .height(75.dp)
            .width(175.dp)
            .constrainAs(tercer) {
                top.linkTo(segon.bottom, margin = 2.dp)
                start.linkTo(primer.absoluteRight, margin = 2.dp)
            }) {
            Image(
                painter = painterResource(id = R.drawable.img3),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
        // quart
        Box(modifier = Modifier
            .height(150.dp)
            .width(150.dp)
            .constrainAs(quart) {
                top.linkTo(parent.top)
                start.linkTo(segon.end, margin = 2.dp)
            }) {
            Image(
                painter = painterResource(id = R.drawable.img4),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
        // gap entre elementos
    }
}

@Composable
fun DescubreItems(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        val (primer, segon, tercer) = createRefs()
        // primer
        val painter1: Painter = painterResource(id = R.drawable.img3)
        Box(contentAlignment = Alignment.BottomStart,
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .constrainAs(primer)


                {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }) {
            imageCard(painter = painter1, title = "Descubre")
        }
        // segon
        val painter2: Painter = painterResource(id = R.drawable.img4)
        Box(contentAlignment = Alignment.BottomStart,
            modifier = Modifier
                .height(150.dp)
                .width(175.dp)
                .constrainAs(segon) {
                    top.linkTo(primer.bottom, margin = 20.dp)
                }) {
            imageCard(painter = painter2, title = "Descubre")
        }

        // tercer
        val painter3: Painter = painterResource(id = R.drawable.img1)
        Box(contentAlignment = Alignment.BottomStart,
            modifier = Modifier
                .height(150.dp)
                .width(175.dp)
                .constrainAs(tercer) {
                    top.linkTo(primer.bottom, margin = 20.dp)
                    end.linkTo(primer.end)
                }) {
            imageCard(painter = painter3, title = "Descubre")
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun imageCard(painter: Painter, title: String, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.height(200.dp)) {
                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent, Color.Black
                                ), startY = 50f
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = title, style = TextStyle(color = Color.White, fontSize = 16.sp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardEntrada(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(16.dp)
            .height(200.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color.Transparent)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val (primer, segon) = createRefs()
            // primer
            Box(
                modifier = Modifier
                    .width(250.dp)
                    .padding(16.dp)

                    .constrainAs(primer) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }, contentAlignment = Alignment.TopStart
            ) {
                Column {
                    Text(
                        text = "Entradas",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Ya puedes comprar tus entradas directamente desde esta app")
                    Spacer(modifier = Modifier.height(8.dp))
                    ElevatedButton(
                        onClick = {},
                        modifier = Modifier,
                        colors = ButtonDefaults.elevatedButtonColors(Color.Red)
                    ) {

                        Text(text = "Comprar entradas", color = Color.White)


                    }
                }


            }
            // segon
            Box(modifier = Modifier.constrainAs(segon) {
                top.linkTo(parent.top)
                start.linkTo(primer.end)
            }) {
                Image(
                    painter = painterResource(id = R.drawable.img1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }

    }
}

// funcion que crea un card con imagen y texto
@Composable
fun fullWithCard(
    modifier: Modifier = Modifier
) {
    var painter: Painter = painterResource(id = R.drawable.img1)
    Box(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent, Color.Black
                            ), startY = 50f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Column {
                    Text(
                        text = "De un impulso",
                        style = TextStyle(color = Color.White, fontSize = 16.sp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "A un cambio de vida",
                        style = TextStyle(color = Color.White, fontSize = 16.sp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ElevatedButton(onClick = { /*TODO*/ }) {
                        Text(text = "Dona", color = Color.Red)
                    }
                }

            }
        }
    }
}

// funcion que crea una lista de redes sociales
@Composable
fun socialFooter(
    modifier: Modifier = Modifier
) {
    Spacer(modifier = Modifier.height(32.dp))
    Column {
        val socialList = SocialProvider.redesSociales

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {

            Text(
                text = "Síguenos en nuestras redes sociales",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.wrapContentWidth()
            )

        }


        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {


            socialList.forEach { social ->
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.Black)
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp), horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Icon(
                            imageVector = social.imagen,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
    Spacer(modifier = Modifier.height(32.dp))
}

// funcion que crea un espacio en blanco
@Composable
fun blankSpace(modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier.height(64.dp))
}



