package com.estivy.sokkerarchitect.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LoadingScreen() {
    Text(text = "Loading...")
}

@Composable
fun ErrorScreen(exception: Exception) {
    exception.printStackTrace()
    Text(text = "Error" + exception.message)
}