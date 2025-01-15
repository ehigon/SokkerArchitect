package com.estivy.sokkerarchitect.ui.screens.composables

import android.icu.text.DecimalFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.core.domain.PlayerStatus
import com.estivy.sokkerarchitect.core.domain.TrainingType
import com.estivy.sokkerarchitect.ui.theme.characteristic
import com.estivy.sokkerarchitect.ui.util.calculateEfficiency

@Composable
fun Training(status: PlayerStatus) {
    Text(
        stringResource(R.string.training_type) + ": " + getTrainingName(status.trainingType),
        style = characteristic
    )
    Text(
        stringResource(R.string.official_minutes) + ": " + (status.officialMinutes ?: 0),
        style = characteristic
    )
    Text(
        stringResource(R.string.unofficial_minutes) + ": " + (status.unofficialMinutes ?: 0),
        style = characteristic
    )
    Text(
        stringResource(R.string.coach_skill) + ": " + skill(status.trainerSkill),
        style = characteristic
    )
    Text(
        stringResource(R.string.efficiency) + ": " +
                DecimalFormat("#").format(calculateEfficiency(status)),
        style = characteristic
    )
    if (status.injured == true) {
        Row() {
            Text(
                stringResource(R.string.injured),
                style = characteristic,
                color = Color.Red
            )
            Image(
                painter = painterResource(R.drawable.injury_high),
                contentDescription = stringResource(id = R.string.injured),
                Modifier
                    .padding(vertical = 6.dp, horizontal = 2.dp)
                    .size(12.dp)
            )
        }
    }
}

@Composable
fun skill(skill: Int): String {
    val skillName: String = when (skill) {
        0 -> stringResource(R.string.tragic)
        1 -> stringResource(R.string.hopeless)
        2 -> stringResource(R.string.unsatisfactory)
        3 -> stringResource(R.string.poor)
        4 -> stringResource(R.string.weak)
        5 -> stringResource(R.string.average)
        6 -> stringResource(R.string.adequate)
        7 -> stringResource(R.string.good)
        8 -> stringResource(R.string.solid)
        9 -> stringResource(R.string.very_good)
        10 -> stringResource(R.string.excellent)
        11 -> stringResource(R.string.formidable)
        12 -> stringResource(R.string.outstanding)
        13 -> stringResource(R.string.incredible)
        14 -> stringResource(R.string.brilliant)
        15 -> stringResource(R.string.magical)
        16 -> stringResource(R.string.unearthly)
        17 -> stringResource(R.string.divine)
        18 -> stringResource(R.string.superdivine)
        else -> ""
    }
    return "$skill ($skillName)"
}

@Composable
fun getTrainingName(trainingType: TrainingType?): String {
    if (trainingType == null) {
        return ""
    }
    return when (trainingType) {
        TrainingType.GENERAL -> stringResource(R.string.general)
        TrainingType.STAMINA -> stringResource(R.string.stamina)
        TrainingType.KEEPER -> stringResource(R.string.keeper)
        TrainingType.PLAYMAKING -> stringResource(R.string.playmaker)
        TrainingType.PASSING -> stringResource(R.string.passing)
        TrainingType.TECHNIQUE -> stringResource(R.string.technique)
        TrainingType.DEFENDING -> stringResource(R.string.defender)
        TrainingType.SCORING -> stringResource(R.string.striker)
        TrainingType.PACE -> stringResource(R.string.pace)
    }
}