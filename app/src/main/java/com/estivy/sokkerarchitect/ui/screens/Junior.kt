package com.estivy.sokkerarchitect.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.estivy.sokkerarchitect.core.domain.Player
import com.estivy.sokkerarchitect.ui.screens.composables.Graph
import com.estivy.sokkerarchitect.ui.screens.model.GraphAppearance
import com.estivy.sokkerarchitect.ui.screens.model.GraphPoint
import com.estivy.sokkerarchitect.ui.theme.blueSA
import com.estivy.sokkerarchitect.ui.theme.greenGraph

@Composable
fun Junior(player: Player) {
    Column {
        Row(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally))
        {
            Text(
                text = player.name + " " + player.surname,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = blueSA
            )
        }
        Graph(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
            yValues = (0..17).map { (it + 1) },
            points = getPoints(player),
            paddingSpace = 16.dp,
            verticalStep = 1,
            graphAppearance = GraphAppearance(
                graphAxisColor = Color.Black,
                backgroundColor = Color.White
            )
        )
    }
}

@Composable
private fun getPoints(player: Player): List<GraphPoint> {
    return player.juniorStatuses.sortedBy { it.week }
        .map { GraphPoint(value = it.skill, bar = 1f, greenGraph) }
}