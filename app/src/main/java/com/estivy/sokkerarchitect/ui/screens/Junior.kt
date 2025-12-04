package com.estivy.sokkerarchitect.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.estivy.sokkerarchitect.core.domain.Country
import com.estivy.sokkerarchitect.core.domain.JuniorFormation
import com.estivy.sokkerarchitect.core.domain.JuniorStatus
import com.estivy.sokkerarchitect.core.domain.Player
import com.estivy.sokkerarchitect.ui.screens.composables.graph.Graph
import com.estivy.sokkerarchitect.ui.screens.composables.JuniorDetails
import com.estivy.sokkerarchitect.ui.screens.model.GraphAppearance
import com.estivy.sokkerarchitect.ui.screens.model.PlayerWrapper
import com.estivy.sokkerarchitect.ui.screens.model.SimpleLinearRegression
import com.estivy.sokkerarchitect.ui.theme.blueSA
import com.estivy.sokkerarchitect.ui.theme.juniorDetail
import com.estivy.sokkerarchitect.ui.util.getGraphPoints

@Composable
fun Junior(player: PlayerWrapper) {
    val graphAppearance = GraphAppearance(
        graphAxisColor = Color.Black,
        backgroundColor = Color.White
    )
    val yValues = (-1..17).map { (it + 1) }
    val drawer = createJuniorDrawer(
        points = player.points,
        yValues = yValues,
        graphAppearance,
        linearRegression = player.linearRegression
    )
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )
        {
            Text(
                text = player.player.name + " " + player.player.surname,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = blueSA
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        {
            JuniorDetails(
                currentWeek = player.player.juniorStatuses.sortedBy { it.week }.last(),
                player = player,
                textStyle = juniorDetail
            )
        }
        Graph(
            points = player.points,
            graphAppearance = graphAppearance,
            listener = {},
            drawer = drawer,
            yValues = yValues,
        )
    }
}


@Preview
@Composable
fun JuniorPreview() {
    val player: Player = Player.builder()
        .name("Esteban")
        .surname("Higon")
        .value(1345678986)
        .age(19)
        .height(183)
        .weight(80.5)
        .cards(1)
        .injuryDays(5)
        .country(
            Country.builder()
                .name("Spain")
                .countryId(34)
                .build()
        )
        .juniorStatuses(
            listOf(
                JuniorStatus.builder()
                    .week(119)
                    .skill(7)
                    .remainingWeeks(6)
                    .formation(JuniorFormation.FIELD_PLAYER)
                    .age(17)
                    .build(),
                JuniorStatus.builder()
                    .week(120)
                    .skill(7)
                    .remainingWeeks(5)
                    .formation(JuniorFormation.FIELD_PLAYER)
                    .age(17)
                    .build(),
                JuniorStatus.builder()
                    .week(121)
                    .skill(7)
                    .remainingWeeks(4)
                    .formation(JuniorFormation.FIELD_PLAYER)
                    .age(17)
                    .build(),
                JuniorStatus.builder()
                    .week(122)
                    .skill(7)
                    .remainingWeeks(3)
                    .formation(JuniorFormation.FIELD_PLAYER)
                    .age(17)
                    .build(),
                JuniorStatus.builder()
                    .week(123)
                    .skill(8)
                    .remainingWeeks(2)
                    .formation(JuniorFormation.FIELD_PLAYER)
                    .age(17)
                    .build(),
                JuniorStatus.builder()
                    .week(124)
                    .skill(9)
                    .remainingWeeks(1)
                    .formation(JuniorFormation.FIELD_PLAYER)
                    .age(17)
                    .build()
            )
        )
        .build()
    val points = getGraphPoints(player)
    val playerWrapper = PlayerWrapper(player, SimpleLinearRegression(points), points)
    Junior(playerWrapper)
}