package com.estivy.sokkerarchitect.ui.screens.model

import androidx.compose.ui.graphics.Color
import com.estivy.sokkerarchitect.ui.theme.blueSA
import com.estivy.sokkerarchitect.ui.theme.redGraph

data class GraphAppearance(
    val graphAxisColor: Color,
    val backgroundColor: Color,
    val lineColor: Color = blueSA,
    val pointingLineColor: Color = Color.Black,
    val trendLineColor: Color = redGraph
)