package com.ogge.snusfri.screens

import android.app.DatePickerDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ogge.snusfri.navigation.NavigationScreens
import com.ogge.snusfri.ui.theme.Purple40
import java.util.Calendar
import kotlin.math.roundToInt


@Composable
fun StartDateInput(navController: NavController, snusUsage: Float, pricePerDosa: Float) {
    val selectedDate = remember { mutableStateOf(Calendar.getInstance()) }
    val context = LocalContext.current

    val navBackStackEntry = navController.currentBackStackEntry
    val snusUsagePerWeek =
        navBackStackEntry?.arguments?.getFloat("snusUsagePerWeek") ?: 0f
    val pricePerDosa =
        navBackStackEntry?.arguments?.getFloat("pricePerDosa") ?: 0f


    var isDatePickerVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp),
        contentAlignment = Alignment.Center
    ){
        Column(modifier = Modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "När ska du sluta snusa?", fontSize = 22.sp, fontWeight = FontWeight.SemiBold,
            )
            Text(text = "Dosor per vecka: ${snusUsage.toInt()} + kr per dosa: $pricePerDosa")
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(200.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp,
                )
            ){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Välj startdatum",
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            isDatePickerVisible = true
                        },
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(text = "Välj datum", fontSize = 14.sp, modifier = Modifier.padding(4.dp))
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row {
                        Text(
                            text = "Valt datum: ",
                            fontSize = 18.sp
                        )
                        Text(
                            text = "${selectedDate.value.get(Calendar.YEAR)}/${selectedDate.value.get(Calendar.MONTH) + 1}/${selectedDate.value.get(Calendar.DAY_OF_MONTH)}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }


                    if (isDatePickerVisible) {
                        // Show the date picker when isDatePickerVisible is true
                        DatePickerDialog(
                            context,
                            { _, year, month, dayOfMonth ->
                                selectedDate.value.set(Calendar.YEAR, year)
                                selectedDate.value.set(Calendar.MONTH, month)
                                selectedDate.value.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                                isDatePickerVisible = false
                            },
                            selectedDate.value.get(Calendar.YEAR),
                            selectedDate.value.get(Calendar.MONTH),
                            selectedDate.value.get(Calendar.DAY_OF_MONTH)
                        ).show()
                    }
                }
            }


        }

    }
        }


@Composable
fun InputScreen2(navController: NavController) {
    var snusUsage by remember { mutableStateOf(1f) }
    var pricePerDosa by remember { mutableStateOf(10f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(200.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp,
                )
            ) {
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
                    Text(
                        text = "Antal dosor: ",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Text(
                        text = "${snusUsage.toInt()} st",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(200.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp,
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    UserQuestions(question = "Vad kostar en dosa?")

                    Spacer(modifier = Modifier.height(10.dp))

                    PricePerDosaSlider(
                        value = pricePerDosa
                    ) { newValue ->
                        pricePerDosa = newValue
                    }

                    Text(
                        text = "Pris per dosa: ",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Text(
                        text = "${pricePerDosa.toInt()} kr",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    println("Gå vidare BTN pressed")
                    /*TODO*/
                    navController.navigate("${NavigationScreens.StarDateInput}/$snusUsage/$pricePerDosa")
                },
                colors = ButtonDefaults.buttonColors(Purple40),
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(10.dp)
            ) {

                Text(text = "Gå vidare", style = TextStyle(fontSize = 18.sp,), modifier = Modifier.padding(8.dp))
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
        onValueChange = { newValue ->
            onValueChange(newValue.roundToInt().toFloat())
        },
        valueRange = 1f..15f,
        steps = 14,
        modifier = Modifier.fillMaxWidth(),


    )
}

@Composable
fun PricePerDosaSlider(
    value: Float,
    onValueChange: (Float) -> Unit
) {
    Slider(
        value = value,
        onValueChange = { newValue ->
            onValueChange(newValue.roundToInt().toFloat())
        },
        valueRange = 10f..60f,
        steps = 50,
        modifier = Modifier.fillMaxWidth(),


    )
}