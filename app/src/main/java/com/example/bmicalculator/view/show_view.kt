package com.example.bmicalculator.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bmicalculator.components.AppBar


@Composable
fun ShowView(
    value: String?,
    navController: NavHostController
) {
    val bmi = value?.toInt()?: 10
     val textList = arrayListOf<String>("You are under Weight",
         "You are at a healthy weight.",
         "You are at overweight.","You are obese.")
    val headlineList = arrayListOf<String>("UNDERWEIGHT", "NORMAL","OVERWEIGHT","OBESE")

    val index = if (bmi < 18) {0}
    else if (bmi >= 18.5 && bmi <25) {
        1
    } else if (bmi > 25 && bmi <= 29.99) {
        2
    } else {
        3
    }

    Surface() {
        Column(modifier = Modifier.background(color = Color(9,12,34))) {
            AppBar(text = "BMI CALCULATOR", onTap = { /*TODO*/ }, color = Color(16,20,39))
            Text(text = "Your Result", style = MaterialTheme.typography.h3, color = Color.White,
                fontWeight = FontWeight.Bold,textAlign = TextAlign.Start
                , modifier = Modifier.padding(start = 20.dp, top = 25.dp, bottom = 15.dp))
            
            Box(modifier = Modifier
                .padding(horizontal = 20.dp)
                .background(color = Color(16, 20, 39))
                .fillMaxWidth()
                .height(520.dp), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = headlineList[index], color = Color.Green, fontWeight = FontWeight.Bold,style = MaterialTheme.typography.h5)
                    Text(text = bmi.toString(), style = MaterialTheme.typography.h1, fontWeight = FontWeight.ExtraBold, color = Color.White)
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(text = "Normal BMI range:", style = MaterialTheme.typography.h6, fontWeight = FontWeight.Bold,
                        color = Color.White.copy(0.5f))
                    Text(text = "18 - 25 kg/m2", style = MaterialTheme.typography.h6, fontWeight = FontWeight.Bold,
                        color = Color.White)
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(text = textList[index], textAlign = TextAlign.Center, style = MaterialTheme.typography.h6, fontWeight = FontWeight.Bold,
                        color = Color.White)
                    Spacer(modifier = Modifier.height(60.dp))
                    Box(contentAlignment = Alignment.Center,modifier = Modifier
                        .width(260.dp)
                        .height(80.dp)
                        .background(color = Color(9, 12, 34))) {
                        Text(text = "SAVE RESULT", textAlign = TextAlign.Center, style = MaterialTheme.typography.h6, fontWeight = FontWeight.Bold,
                            color = Color.White)
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            AppBar(text = "RE-CALCULATE YOUR BMI", onTap = { navController.navigate("home")}, color = Color(234,21,86))
        }
    }
}