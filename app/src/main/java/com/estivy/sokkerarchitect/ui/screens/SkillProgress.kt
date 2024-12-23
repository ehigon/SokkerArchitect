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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.estivy.sokkerarchitect.core.domain.Country
import com.estivy.sokkerarchitect.core.domain.Player
import com.estivy.sokkerarchitect.core.domain.PlayerStatus
import com.estivy.sokkerarchitect.core.domain.TrainingType
import com.estivy.sokkerarchitect.ui.screens.composables.Graph
import com.estivy.sokkerarchitect.ui.screens.model.GraphAppearance
import com.estivy.sokkerarchitect.ui.screens.model.GraphPoint
import com.estivy.sokkerarchitect.ui.screens.model.Skill
import com.estivy.sokkerarchitect.ui.theme.blueSA
import com.estivy.sokkerarchitect.ui.theme.greenGraph
import com.estivy.sokkerarchitect.ui.theme.redGraph

@Composable
fun SkillProgress(player: Player, skill: Skill) {
    Column {
        Row( modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally))
        {
            Text(text = player.name + " " +  player.surname + " - " + stringResource(skill.resource),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = blueSA)
        }
        Graph(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
            yValues = (0..17).map { (it + 1) },
            points = getPoints(player, skill),
            paddingSpace = 16.dp,
            verticalStep = 1,
            graphAppearance = GraphAppearance(
                graphAxisColor = Color.Black,
                backgroundColor = Color.White
            )
        )
    }
}

private fun getPoints(player: Player, skill: Skill): List<GraphPoint> {
    return player.playerStatuses.sortedBy { it.week }
        .map { GraphPoint(value = skill.skill(it), bar = 1f, getColor(skill, it)) }
}

private fun getColor(skill: Skill, playerStatus: PlayerStatus): Color {
    return if(skill.trained(playerStatus)) greenGraph else redGraph
}

@Preview
@Composable
fun SkillProgressPreview() {
    val player: Player = Player.builder()
        .name("Esteban")
        .surname("Higon")
        .value(1345678986)
        .age(23)
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
        .playerStatuses(
            listOf(
                PlayerStatus.builder()
                    .week(123)
                    .skillForm(10)
                    .skillPace(9)
                    .skillKeeper(1)
                    .skillPassing(12)
                    .skillDefending(11)
                    .skillDiscipline(10)
                    .skillExperience(8)
                    .skillPlaymaking(9)
                    .skillScoring(18)
                    .skillStamina(17)
                    .skillTeamwork(12)
                    .skillTechnique(14)
                    .trainingType(TrainingType.DEFENDING)
                    .build(),
                PlayerStatus.builder()
                    .week(124)
                    .skillForm(11)
                    .skillPace(9)
                    .skillKeeper(1)
                    .skillPassing(13)
                    .skillDefending(11)
                    .skillDiscipline(10)
                    .skillExperience(9)
                    .skillPlaymaking(9)
                    .skillScoring(18)
                    .skillStamina(17)
                    .skillTeamwork(13)
                    .skillTechnique(15)
                    .trainingType(TrainingType.TECHNIQUE)
                    .build()
            )
        )
        .build()
    SkillProgress(player, Skill.TECHNIQUE)
}
