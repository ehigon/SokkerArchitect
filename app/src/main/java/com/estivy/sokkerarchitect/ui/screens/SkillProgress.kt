package com.estivy.sokkerarchitect.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.zIndex
import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.core.domain.Country
import com.estivy.sokkerarchitect.core.domain.Player
import com.estivy.sokkerarchitect.core.domain.PlayerStatus
import com.estivy.sokkerarchitect.core.domain.TrainingType
import com.estivy.sokkerarchitect.ui.screens.composables.Graph
import com.estivy.sokkerarchitect.ui.screens.composables.Training
import com.estivy.sokkerarchitect.ui.screens.model.GraphAppearance
import com.estivy.sokkerarchitect.ui.screens.model.GraphPoint
import com.estivy.sokkerarchitect.ui.screens.model.Skill
import com.estivy.sokkerarchitect.ui.theme.blueSA
import com.estivy.sokkerarchitect.ui.theme.greenGraph
import com.estivy.sokkerarchitect.ui.theme.playerTitle
import com.estivy.sokkerarchitect.ui.theme.redGraph
import com.estivy.sokkerarchitect.ui.util.calculateEfficiency

@Composable
fun SkillProgress(player: Player, skill: Skill) {
    val sortedPlayerStatuses = player.playerStatuses.sortedBy { it.week }
    val show = remember { mutableStateOf(false) }
    val status = remember { mutableStateOf(PlayerStatus.builder().build()) }
    val weeksAgo = remember { mutableLongStateOf(0) }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )
        {
            Text(
                text = player.name + " " + player.surname + " - " + stringResource(skill.resource),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = blueSA
            )
        }
        Graph(
            points = getPoints(sortedPlayerStatuses, skill),
            graphAppearance = GraphAppearance(
                graphAxisColor = Color.Black,
                backgroundColor = Color.White
            ),
            listener = {
                if (it < sortedPlayerStatuses.size) {
                    status.value = sortedPlayerStatuses[it]
                    weeksAgo.longValue =
                        sortedPlayerStatuses[sortedPlayerStatuses.size - 1].week - sortedPlayerStatuses[it].week
                    show.value = true
                }
            }
        )
    }
    TrainingPopUpBox(show, status, weeksAgo)
}

private fun getPoints(playerStatuses: List<PlayerStatus>, skill: Skill): List<GraphPoint> {
    return playerStatuses
        .map {
            GraphPoint(
                value = skill.skill(it),
                bar = getTraining(it),
                color = getColor(skill, it),
                week = if (it.week == null) 0 else it.week.toInt()
            )
        }
}

fun getTraining(playerStatus: PlayerStatus): Float {
    return ((calculateEfficiency(playerStatus) / 100) * (playerStatus.trainerSkill
        ?: 0) / 18).toFloat()
}

private fun getColor(skill: Skill, playerStatus: PlayerStatus): Color {
    return if (skill.trained(playerStatus)) greenGraph else redGraph
}

@Composable
fun TrainingPopUpBox(
    show: MutableState<Boolean>,
    status: MutableState<PlayerStatus>,
    weeksAgo: MutableState<Long>
) {
    if (show.value) {
        Popup(
            alignment = Alignment.Center,
            onDismissRequest = {
                show.value = false
            },
            content = {
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .clip(RoundedCornerShape(4.dp))
                        .border(BorderStroke(2.dp, MaterialTheme.colorScheme.secondary))
                        .padding(10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        Text(
                            stringResource(R.string.weeks_ago) + ": " + weeksAgo.value,
                            Modifier.padding(top = 10.dp),
                            style = playerTitle,
                            color = MaterialTheme.colorScheme.secondary
                        )
                        Training(status.value)
                    }
                }
            },
        )
    }
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
                    .injured(false)
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
                    .injured(false)
                    .skillTechnique(15)
                    .trainingType(TrainingType.TECHNIQUE)
                    .build(),
                PlayerStatus.builder()
                    .week(125)
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
                    .injured(true)
                    .trainingType(TrainingType.TECHNIQUE)
                    .build()
            ),

            )
        .build()
    SkillProgress(player, Skill.TECHNIQUE)
}
