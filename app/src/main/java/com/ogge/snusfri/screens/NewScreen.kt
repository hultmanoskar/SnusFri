package com.ogge.snusfri.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun NewScreen(navController: NavController) {
    Column {
        Text(text = "Input Screen")
        Row {
            Text(text = "Heej")
        }
    }
}