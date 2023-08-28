package com.ogge.snusfri.ui.theme

import android.media.Image
import android.text.Layout
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StartScreen(daysSince: Int, moneySaved: Double) {
               Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Congratulations!",
                    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, color = HotPink)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "You've been snus-free for $daysSince days!",
                    style = TextStyle(fontSize = 18.sp, color = Color.Gray)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "You've saved $moneySaved kr.",
                            style = TextStyle(fontSize = 18.sp, color = Color.Gray)
                )
            }
        }



@Composable
fun Header(appName: String, logo: Image?){
    Text(text = appName, fontSize = 30.sp, fontWeight = FontWeight.Bold)
}