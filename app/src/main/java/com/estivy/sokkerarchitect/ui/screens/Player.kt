package com.estivy.sokkerarchitect.ui.screens

import android.icu.text.DecimalFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.core.domain.Country
import com.estivy.sokkerarchitect.core.domain.Player
import com.estivy.sokkerarchitect.core.domain.PlayerStatus
import com.estivy.sokkerarchitect.core.domain.TrainingType
import com.estivy.sokkerarchitect.ui.SokkerArchitectScreen
import com.estivy.sokkerarchitect.ui.screens.composables.Cards
import com.estivy.sokkerarchitect.ui.screens.composables.Injury
import com.estivy.sokkerarchitect.ui.screens.composables.Training
import com.estivy.sokkerarchitect.ui.screens.composables.skill
import com.estivy.sokkerarchitect.ui.theme.attributes
import com.estivy.sokkerarchitect.ui.theme.attributesDown
import com.estivy.sokkerarchitect.ui.theme.attributesUp
import com.estivy.sokkerarchitect.ui.theme.characteristic
import com.estivy.sokkerarchitect.ui.theme.title
import com.estivy.sokkerarchitect.ui.util.Evolution
import com.estivy.sokkerarchitect.ui.screens.model.Skill
import com.estivy.sokkerarchitect.ui.theme.playerTitle

@Composable
fun Player(player: Player, navigateTo: (route: String) -> Unit) {
    val scrollState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        Name(player)
        Characteristics(player)
        Skills(player, navigateTo)
        TrainingWithTitle(player)
    }
}

@Composable
private fun Name(player: Player) {
    Text(
        player.name + " " + player.surname,
        Modifier.padding(top = 10.dp),
        style = title
    )
}

@Composable
private fun Characteristics(player: Player) {
    val dec = DecimalFormat("#,###")
    Text(
        stringResource(R.string.characteritics),
        Modifier.padding(top = 10.dp),
        style = playerTitle,
        color = MaterialTheme.colorScheme.secondary
    )
    Text(
        stringResource(R.string.age) + " " + player.age,
        style = characteristic
    )
    Text(
        stringResource(R.string.value) + " " + dec.format(player.valueInCurrency) + " " + player.currency,
        style = characteristic
    )
    Text(
        stringResource(R.string.height) + " " + player.height
                + " " + stringResource(R.string.cm),
        style = characteristic
    )
    Text(
        stringResource(R.string.weight) + " " + player.weight
                + " " + stringResource(R.string.kg),
        style = characteristic
    )
    Cards(player)
    Injury(player)
}

@Composable
private fun Injury(player: Player) {
    if (player.injuryDays != null && player.injuryDays > 0) {
        Row {
            Text(
                stringResource(R.string.injury) + " " + player.injuryDays + " " + stringResource(R.string.days),
                style = characteristic
            )
            Injury(player, 6, 12)
        }
    }
}

@Composable
private fun Cards(player: Player) {
    if (player.cards != null && player.cards > 0) {
        Row {
            Text(
                stringResource(R.string.cards),
                style = characteristic
            )
            Cards(player, 5, 12)
        }
    }
}

@Composable
fun Skills(player: Player, navigateTo: (route: String) -> Unit) {
    val evolution = Evolution(player)
    val status = evolution.currentWeek
    Text(
        stringResource(R.string.skills),
        Modifier.padding(top = 10.dp),
        style = playerTitle,
        color = MaterialTheme.colorScheme.secondary
    )
    Row {
        Column {
            Text(
                stringResource(R.string.tactical_discipline) + ":",
                style = attributes
            )
            Text(
                stringResource(R.string.form) + ":",
                style = attributes
            )
            Text(
                stringResource(R.string.stamina) + ":",
                style = attributes
            )
            Text(
                stringResource(R.string.pace) + ":",
                Modifier.padding(top = 14.dp),
                style = attributes
            )
            Text(
                stringResource(R.string.technique) + ":",
                style = attributes
            )
            Text(
                stringResource(R.string.passing) + ":",
                style = attributes
            )
            Text(
                stringResource(R.string.keeper) + ":",
                style = attributes
            )
            Text(
                stringResource(R.string.defender) + ":",
                style = attributes
            )
            Text(
                stringResource(R.string.playmaker) + ":",
                style = attributes
            )
            Text(
                stringResource(R.string.striker) + ":",
                style = attributes
            )
        }
        Column(Modifier.padding(horizontal = 7.dp)) {
            Text(
                skill(status.skillDiscipline),
                style = getAttributesStyle(evolution.getSkillDiscipline())
            )
            Text(
                skill(status.skillForm),
                style = getAttributesStyle(evolution.getSkillForm())
            )
            Text(
                skill(status.skillStamina),
                style = getAttributesStyle(evolution.getSkillStamina())
            )
            Text(
                skill(status.skillPace),
                Modifier.padding(top = 14.dp),
                style = getAttributesStyle(evolution.getSkillPace())
            )
            Text(
                skill(status.skillTechnique),
                style = getAttributesStyle(evolution.getSkillTechnique())
            )
            Text(
                skill(status.skillPassing),
                style = getAttributesStyle(evolution.getSkillPassing())
            )
            Text(
                skill(status.skillKeeper),
                style = getAttributesStyle(evolution.getSkillKeeper())
            )
            Text(
                skill(status.skillDefending),
                style = getAttributesStyle(evolution.getSkillDefending())
            )
            Text(
                skill(status.skillPlaymaking),
                style = getAttributesStyle(evolution.getSkillPlaymaking())
            )
            Text(
                skill(status.skillScoring),
                style = getAttributesStyle(evolution.getSkillScoring())
            )
        }
        Column {
            ProgressButton(
                player = player,
                skill = Skill.DISCIPLINE,
                navigateTo = navigateTo
            )
            ProgressButton(
                player = player,
                skill = Skill.FORM,
                navigateTo = navigateTo
            )
            ProgressButton(
                player = player,
                skill = Skill.STAMINA,
                navigateTo = navigateTo
            )
            ProgressButton(
                player = player,
                skill = Skill.PACE,
                navigateTo = navigateTo,
                modifier = Modifier.padding(top = 14.dp)
            )
            ProgressButton(
                player = player,
                skill = Skill.TECHNIQUE,
                navigateTo = navigateTo
            )
            ProgressButton(
                player = player,
                skill = Skill.PASSING,
                navigateTo = navigateTo
            )
            ProgressButton(
                player = player,
                skill = Skill.KEEPER,
                navigateTo = navigateTo
            )
            ProgressButton(
                player = player,
                skill = Skill.DEFENDING,
                navigateTo = navigateTo
            )
            ProgressButton(
                player = player,
                skill = Skill.PLAYMAKING,
                navigateTo = navigateTo
            )
            ProgressButton(
                player = player,
                skill = Skill.SCORING,
                navigateTo = navigateTo
            )
        }
    }
}

@Composable
private fun TrainingWithTitle(player: Player) {
    Text(
        stringResource(R.string.last_training),
        Modifier.padding(top = 10.dp),
        style = playerTitle,
        color = MaterialTheme.colorScheme.secondary
    )
    Training((player.playerStatuses.maxBy { ps -> ps.week }) ?: PlayerStatus())
}

fun getAttributesStyle(skillDiscipline: Int): TextStyle {
    return if (skillDiscipline > 0) {
        attributesUp
    } else if (skillDiscipline == 0) {
        attributes
    } else {
        attributesDown
    }
}

@Composable
fun ProgressButton(
    player: Player,
    skill: Skill,
    navigateTo: (route: String) -> Unit,
    modifier: Modifier = Modifier
) {
    if (player.playerStatuses.size > 1) {
        val finalModifier = modifier
            .height(24.2.dp)
            .width(63.dp)
        Button(
            modifier = finalModifier,
            onClick = {
                navigateTo(
                    SokkerArchitectScreen.SKILL_PROGRESS.route.replace(
                        "{id}", player.id.toString()
                    ).replace("{skill}", skill.name)
                )
            },
            content = {
                Image(
                    painter = painterResource(id = R.drawable.bar_chart),
                    contentDescription = stringResource(id = R.string.evolution_graph),
                    modifier = Modifier.fillMaxHeight(),
                    contentScale = ContentScale.FillBounds
                )
            },
            colors = ButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Transparent,
                disabledContentColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            )
        )
    }
}

@Preview
@Composable
fun PlayerPreview() {
    val player: Player = Player.builder()
        .name("Esteban")
        .surname("Higon")
        .value(1345678986)
        .valueInCurrency(336419746.5)
        .currency("€")
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
                    .skillTechnique(15)
                    .build(),
                PlayerStatus.builder()
                    .week(124)
                    .skillForm(10)
                    .skillPace(9)
                    .skillKeeper(1)
                    .skillPassing(12)
                    .skillDefending(12)
                    .skillDiscipline(10)
                    .skillExperience(8)
                    .skillPlaymaking(9)
                    .skillScoring(18)
                    .skillStamina(17)
                    .skillTeamwork(12)
                    .skillTechnique(15)
                    .officialMinutes(90)
                    .trainerSkill(10)
                    .trainingType(TrainingType.GENERAL)
                    .build()
            )
        )
        .build()
    Player(player) { println(it) }
}
