package com.example.diceroller

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   DiceRollerApp()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DiceRollerApp(){
    DiceWithButtonAndImage()
}


@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier.fillMaxSize()) {

    var result by remember { mutableStateOf(1) }
    var image = when (result){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {


        Image(painter = painterResource(image),
            contentDescription = "$result")
        Spacer(modifier= Modifier.height(5.dp))
        Button(onClick = {result = (1..6).random()},
            colors= ButtonDefaults.buttonColors(Color(0xFFab81b6))){
            Text(text = "Roll",
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 8.dp))

            }
    }

    
}

