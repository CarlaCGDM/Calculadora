// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {

    var text by remember { mutableStateOf("Hello, World!") }
    var input1 by remember { mutableStateOf("") }
    var input2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf(0) }

    DesktopMaterialTheme {

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {


            Row() {
                TextField(value = input1, onValueChange = {input1 = it}, modifier = Modifier.padding(5.dp).size(100.dp,60.dp))
                TextField(value = input2, onValueChange = {input2 = it}, modifier = Modifier.padding(5.dp).size(100.dp,60.dp))
            }

            Button(onClick = {
                resultado = input1.toInt()*input2.toInt()
            }) {
                Text("Multiplicar")
            }

            Text(resultado.toString(), modifier = Modifier.padding(5.dp))

        }

    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

