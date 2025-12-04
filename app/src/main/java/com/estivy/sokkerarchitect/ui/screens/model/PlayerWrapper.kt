package com.estivy.sokkerarchitect.ui.screens.model

import com.estivy.sokkerarchitect.core.domain.Player

data class PlayerWrapper(
    val player: Player,
    val linearRegression: SimpleLinearRegression,
    val points: List<GraphPoint>
)