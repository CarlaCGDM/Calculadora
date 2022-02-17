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
    var frame by remember { mutableStateOf(1) }

    composableScope.launch {
        while(true) {
            delay(20L)
            if (frame == 33) {frame = 1} else {frame++}
        }
    }


    var input1 by remember { mutableStateOf("") }
    var input2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf(0) }

    MaterialTheme (colors = lightColors(
        primary = Color.Red,
        secondary = Color.Green,
    )) {

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(),
        ) {

            Row() {
                Image(
                    bitmap = useResource("Pikachu/ (" + frame + ").png") { loadImageBitmap(it) }, "imagen",
                    modifier = Modifier.padding(5.dp).size(60.dp)
                )

                Image(
                    bitmap = useResource("Charmander/ (" + frame + ").png") { loadImageBitmap(it) }, "imagen",
                    modifier = Modifier.padding(5.dp).size(60.dp)
                )


            }

            Row() {
                TextField(value = input1, onValueChange = {input1 = it}, modifier = Modifier.padding(5.dp).size(100.dp,60.dp))
                TextField(value = input2, onValueChange = {input2 = it}, modifier = Modifier.padding(5.dp).size(100.dp,60.dp))
            }

            Button(modifier = Modifier.padding(5.dp).clip(RoundedCornerShape(50.dp)), onClick = {
                resultado = input1.toInt()*input2.toInt()
            }) {
                Text("Multiplicar")
            }

            Text(resultado.toString(), modifier = Modifier.padding(5.dp))
            Text(frame.toString(), modifier = Modifier.padding(5.dp))

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

