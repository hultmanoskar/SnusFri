package com.ogge.snusfri.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ogge.snusfri.R
import com.ogge.snusfri.ui.theme.HotPink
import androidx.compose.ui.unit.dp


@Composable 
fun InputScreen(navController: NavController) {
    Column {
        Text(text = "Input Screen")
        Row {
            Text(text = "Heej")
        }
    }
}

@Composable
fun InputScreen2(navController: NavController) {
    var snusUsage by remember { mutableStateOf(1f) }
    var snusUsage2 by remember { mutableStateOf(1f) }

    Column( modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Card(colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
        ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(200.dp), elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,



                )) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                UserQuestions(question = "Snusade dosor per vecka?")

                Spacer(modifier = Modifier.height(10.dp))
                SnusUsageSlider(
                    value = snusUsage
                ) { newValue ->
                    snusUsage = newValue
                }
               /* Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "1", style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Text(
                        text = "15", style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                } */
                Text(
                    text = "Antal dosor: ${snusUsage.toInt()}",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Card(colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
        ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(200.dp), elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,



        )) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                UserQuestions(question = "Vad kostar en dosa?")

                Spacer(modifier = Modifier.height(10.dp))

                SnusUsageSlider2(
                    value = snusUsage2
                ) { newValue ->
                    snusUsage2 = newValue
                }

                Text(
                    text = "Pris per dosa: ${snusUsage2.toInt()}",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }
        }



    }


@Composable
fun UserQuestions(question: String){
        Text(text = question,
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    
}

@Composable
fun SnusUsageSlider(
    value: Float,
    onValueChange: (Float) -> Unit
) {
    Slider(
        value = value,
        onValueChange = onValueChange,
        valueRange = 1f..15f,
        steps = 14,
        modifier = Modifier.fillMaxWidth()

    )
}

@Composable
fun SnusUsageSlider2(
    value: Float,
    onValueChange: (Float) -> Unit
) {
    Slider(
        value = value,
        onValueChange = onValueChange,
        valueRange = 10f..60f,
        steps = 50,
        modifier = Modifier.fillMaxWidth()

    )
}