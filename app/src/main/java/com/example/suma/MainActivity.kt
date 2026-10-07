package com.example.suma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.suma.ui.theme.SumaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           App()
        }
    }
}


@Composable
fun App(){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var uno by remember { mutableStateOf("") }
        var dos by remember { mutableStateOf("") }
        var suma by remember { mutableStateOf("") }
        var resul by remember { mutableStateOf("") }

        Image(painterResource(R.drawable.logo),
            contentDescription = "logo"
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "APLICACION SUMA",
            fontSize = 35.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = "Uno",
            onValueChange = { uno = it },
            label = {Text("INGRESE NUMERO UNO: ")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        OutlinedTextField(
            value = "Dos",
            onValueChange = { dos = it },
            label = { Number("INGRESE NUMERO DOS: ")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val a = uno.toIntOrNull()
                val b = dos.toIntOrNull()

                if(a != null && b != null){
                    suma = (a + b).toString()
                    uno = ""
                    dos = ""
                }
            }
        ) {
            Text("CALCULAR")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "EL RESULTADO ES: $suma "
        )
    }

}

@Composable
@Preview
fun Vista(){
    App()
}







