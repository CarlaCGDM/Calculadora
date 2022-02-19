// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
@Preview
fun App() {

    val composableScope = rememberCoroutineScope()
    var squirtleFrame by remember { mutableStateOf(1) }
    var bulbasaurFrame by remember { mutableStateOf(1) }
    var pichuFrame by remember { mutableStateOf(1) }
    var charmanderFrame by remember { mutableStateOf(1) }

    composableScope.launch {
        while(true) {
            delay(20L)
            if (squirtleFrame == 29) {squirtleFrame = 1} else {squirtleFrame++}
            if (bulbasaurFrame == 41) {bulbasaurFrame = 1} else {bulbasaurFrame++}
            if (pichuFrame == 47) {pichuFrame = 1} else {pichuFrame++}
            if (charmanderFrame == 69) {charmanderFrame = 1} else {charmanderFrame++}
        }
    }

    var especieElegida:String? by remember { mutableStateOf(null) }

    MaterialTheme (colors = lightColors(
        primary = Color.LightGray,
        secondary = Color.Green,

    )) {

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(),
        ) {

            Row() {

                Button( modifier = Modifier.padding(5.dp), onClick = {especieElegida = "SQUIRTLE"}) {
                    Image(
                        bitmap = useResource("Squirtle/frame (" + squirtleFrame + ").png") { loadImageBitmap(it) }, "imagen",
                        modifier = Modifier.size(60.dp)
                    )}

                Button( modifier = Modifier.padding(5.dp), onClick = {especieElegida = "CHARMANDER"}) {
                    Image(
                        bitmap = useResource("Charmander/frame (" + charmanderFrame + ").png") { loadImageBitmap(it) }, "imagen",
                        modifier = Modifier.size(60.dp)
                    )}

                Button( modifier = Modifier.padding(5.dp), onClick = {especieElegida = "PICHU"}) {
                    Image(
                        bitmap = useResource("Pichu/frame (" + pichuFrame + ").png") { loadImageBitmap(it) }, "imagen",
                        modifier = Modifier.size(60.dp)
                    )}

                Button( modifier = Modifier.padding(5.dp), onClick = {especieElegida = "BULBASAUR"}) {
                Image(
                    bitmap = useResource("Bulbasaur/frame (" + bulbasaurFrame + ").png") { loadImageBitmap(it) }, "imagen",
                    modifier = Modifier.size(60.dp)
                )}


            }

            Button (onClick = {}) {
                Text(if (especieElegida != null) {"Jugar con $especieElegida"} else {"Elige un Pokémon"})
            }

        }

    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, resizable = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
        ) {
            App()
        }
    }
}

