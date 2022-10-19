package com.example.bmicalculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bmicalculator.components.AppBar
import com.example.bmicalculator.components.GenderBox
import com.example.bmicalculator.components.HeightAndAge
import com.example.bmicalculator.components.RoundIconButton
import com.example.bmicalculator.navigate.MyAppNavHost
import com.example.bmicalculator.ui.theme.BMICalculatorTheme
import java.nio.file.WatchEvent
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyAppNavHost()

                Root {
                    MyAppNavHost()
                }

        }
    }
}

@Composable
fun Root(content: @Composable () -> Unit) {
    BMICalculatorTheme {

    Surface(
        color = Color(9,12,34)
    ) {
        content()
    }
    }
}


@Composable
fun HomeView(
    navController: NavHostController
) {
    val genderSelectState = remember() {
        mutableStateOf(value = 0)
    }
    val weightSelectState = remember() {
        mutableStateOf(value = 60)
    }
    val ageSelectState = remember() {
        mutableStateOf(value = 21)
    }
    val sliderState = remember() {
        mutableStateOf(value = 130f)
    }
    Surface(color = Color(9,12,34, 1)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            AppBar(text = "BMI CALCULATOR", onTap = {}, color = Color(16,20,39))
            Spacer(modifier = Modifier.height(20.dp))
            Row(horizontalArrangement = Arrangement.Center
            ) {
                GenderBox(
                    text = "Male",
                    icon = Icons.Default.Male,
                    color = if (genderSelectState.value == 1) {
                        Color.White
                    } else Color.White.copy(0.5f),
                    onClick = {
                        genderSelectState.value = 1
                        Log.d("LOG MESSAGE", "Body: ${genderSelectState.value}")
                    },
                )
                Spacer(modifier = Modifier.width(5.dp))
                GenderBox(text = "Female",
                    icon = Icons.Default.Female,
                    color = if (genderSelectState.value == 2) { Color.White} else Color.White.copy(0.5f),
                    onClick = {
                              genderSelectState.value = 2
                    },
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            HeightSlider(sliderState)
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                HeightAndAge(text = "WEIGHT", value = weightSelectState)
                HeightAndAge(text = "AGE", value = ageSelectState)
            }
            Spacer(modifier = Modifier.height(20.dp))
            AppBar(text = "CALCULATE YOUR BMI", onTap = {
                val value = (weightSelectState.value / (sliderState.value * sliderState.value)) * 10000
                val lastValue = "%.0f".format(value)
                navController.navigate("showView/$lastValue")
            }, color = Color(234,21,86))
        }
    }
}

@Composable
fun HeightSlider(
    sliderStateLocal: MutableState<Float>
) {

    Box(modifier = Modifier
        .height(180.dp)
        .width(365.dp)
        .background(Color(16, 20, 39))) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)) {
            Text(text = "HEIGHT", style = MaterialTheme.typography.h6, fontWeight = FontWeight.Bold,
                color = Color.White.copy(0.5f))
            Row() {
                val height = "%.0f".format(sliderStateLocal.value)
                Text(text = "$height", style = MaterialTheme.typography.h3, fontWeight = FontWeight.ExtraBold, color = Color.White)
                Text(text = "cm", style = MaterialTheme.typography.h6, color = Color.White.copy(0.5f),
                    modifier = Modifier.padding(top = 28.dp), fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Slider(value = sliderStateLocal.value, onValueChange = {
                sliderStateLocal.value = it
            }, modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            valueRange = 30f..230f, colors = SliderDefaults.colors(thumbColor = Color(234,21,86)
                , inactiveTrackColor = Color.White.copy(0.5f), activeTrackColor = Color.White),
            )
        }
    }
}

