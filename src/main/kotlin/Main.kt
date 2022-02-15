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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import javax.imageio.ImageIO

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    DesktopMaterialTheme {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                text = "Hello, Desktop!"
            }) {
                Greeting(text)
            }
        }

    }
}

@Composable
fun Greeting(text:String) {
    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text, style = TextStyle(color = Color.LightGray))
        Text("Hello, World!", style = TextStyle(color = Color.Blue))
        Text("Hello, Second World!", style = TextStyle(color = Color.Red))

        var input by remember { mutableStateOf("") }
        var input2 by remember { mutableStateOf("") }

        Row (modifier = Modifier.padding(10.dp)) {
            TextField(
                modifier = Modifier.size(65.dp).padding(5.dp),
                value = input,
                onValueChange = { input = it } ,
            )

            TextField(
                modifier = Modifier.size(65.dp).padding(5.dp),
                value = input2,
                onValueChange = { input2 = it },
            )

        }
        var dato by remember { mutableStateOf(0) }
        var dato2 by remember { mutableStateOf(0) }

        Button (onClick = { dato = input.toInt(); dato2 = input2.toInt()}) {
            Text("Multiplicar")
        }

        Text((dato*dato2).toString())
    }
}

@Composable
@Preview
fun Calculadora() {

}









fun main() = application {
    Window(
        //icon = crear funcion imageFromFile
        onCloseRequest = ::exitApplication) {
        Calculadora()
    }
}
