package com.ogge.snusfri.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ogge.snusfri.ui.theme.Mint
import com.ogge.snusfri.ui.theme.Mint2
import com.ogge.snusfri.ui.theme.Purple40
import kotlin.math.sin


@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "SnusFri",
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Purple40
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Börja din resa idag",
            style = TextStyle(
                fontSize = 18.sp,
                color = Color.Gray
            )
        )
        Text(
            text = "mot en snusfri morgondag!",
            style = TextStyle(
                fontSize = 18.sp,
                color = Color.Gray
            )
        )

        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                println("Btn click!")
                navController.navigate("inputscreen2")

            },
            colors = ButtonDefaults.buttonColors(Purple40),
            modifier = Modifier
                .align(Alignment.End)
                .padding(20.dp)

        ) {
            Text(text = "Kom igång",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp
                    ),
                modifier = Modifier
                    .padding(8.dp)
                )
        }
    }
}

@Composable
fun CalmingBackground() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            drawWavePattern(
                color = Mint,
                amplitude = 20f,
                frequency = 0.02f,
                yOffset = -20f
            )
        }
    }
}

private fun DrawScope.drawWavePattern(
    color: Color,
    amplitude: Float,
    frequency: Float,
    yOffset: Float
) {
    val path = Path()

    val centerY = size.height / 3f + yOffset

    path.moveTo(0f, centerY)
    path.lineTo(size.width, centerY)

    for (x in 0 until size.width.toInt()) {
        val y = centerY + amplitude * sin(frequency * x)
        path.lineTo(x.toFloat(), y)
    }

    path.lineTo(size.width, size.height)
    path.lineTo(0f, size.height)
    path.close()

    drawPath(
        path = path,
        color = color
    )
}

@Composable
fun ImageBackground(imageResId: Int, content: @Composable () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null, // Provide an appropriate description
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        content()
    }
}

