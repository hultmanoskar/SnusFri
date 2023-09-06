package com.ogge.snusfri.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ogge.snusfri.ui.theme.Purple40



    @Composable
    fun MainScreen(
        navController: NavController,
        snusUsage: Float,
        pricePerDosa: Float
    ) {
        val moneySavedWeek = snusUsage * pricePerDosa
        val moneySavedMonth = moneySavedWeek * 4 // Assuming 4 weeks in a month
        val moneySavedYear = moneySavedMonth * 12

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp).padding(20.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Money Saved in a Month",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "$${moneySavedMonth.toInt()}",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Card to display money saved in a year
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp).padding(20.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Money Saved in a Year",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        Icons.Filled.ThumbUp,
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "$${moneySavedYear.toInt()}",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Button to navigate back to SnusConsumption screen
            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(10.dp)
            ) {
                Text(
                    text = "Go Back",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }



@Composable
fun Headline(mainTxt: String){
    Text(text = mainTxt, fontStyle = FontStyle.Normal, 
        fontWeight = FontWeight.Bold, 
        fontSize = 24.sp
        )
}