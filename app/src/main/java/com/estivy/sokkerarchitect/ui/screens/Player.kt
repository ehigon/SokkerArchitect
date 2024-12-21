package com.estivy.sokkerarchitect.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import com.estivy.sokkerarchitect.ui.SokkerArchitectScreen
import com.estivy.sokkerarchitect.ui.theme.attributes
import com.estivy.sokkerarchitect.ui.theme.attributesDown
import com.estivy.sokkerarchitect.ui.theme.attributesUp
import com.estivy.sokkerarchitect.ui.theme.characteritic
import com.estivy.sokkerarchitect.ui.theme.title
import com.estivy.sokkerarchitect.ui.util.Evolution
import com.estivy.sokkerarchitect.ui.screens.model.Skill

@Composable
fun Player(player: Player, navigateTo: (route: String) -> Unit) {
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Name(player)
        Characteristics(player, navigateTo)
        Attributes(player, navigateTo)
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
private fun Characteristics(player: Player, navigateTo: (route: String) -> Unit) {
    Text(
        stringResource(R.string.age) + " " + player.age,
        Modifier.padding(top = 10.dp),
        style = characteritic
    )
    Text(
        stringResource(R.string.value) + " " + player.value,
        style = characteritic
    )
    Text(
        stringResource(R.string.height) + " " + player.height
                + " " + stringResource(R.string.cm),
        style = characteritic
    )
    Text(
        stringResource(R.string.weight) + " " + player.weight
                + " " + stringResource(R.string.kg),
        style = characteritic
    )
    Cards(player)
    Injury(player)
}

@Composable
fun Attributes(player: Player, navigateTo: (route: String) -> Unit) {
    val evolution = Evolution(player)
    val status = evolution.currentWeek
    Row {
        Column {
            Text(
                stringResource(R.string.tactical_discipline),
                Modifier.padding(top = 14.dp),
                style = attributes
            )
            Text(
                stringResource(R.string.form),
                style = attributes
            )
            Text(
                stringResource(R.string.stamina),
                style = attributes
            )
            Text(
                stringResource(R.string.pace),
                Modifier.padding(top = 14.dp),
                style = attributes
            )
            Text(
                stringResource(R.string.technique),
                style = attributes
            )
            Text(
                stringResource(R.string.passing),
                style = attributes
            )
            Text(
                stringResource(R.string.keeper),
                style = attributes
            )
            Text(
                stringResource(R.string.defender),
                style = attributes
            )
            Text(
                stringResource(R.string.playmaker),
                style = attributes
            )
            Text(
                stringResource(R.string.striker),
                style = attributes
            )
        }
        Column(Modifier.padding(horizontal = 7.dp)) {
            Text(
                skill(status.skillDiscipline),
                Modifier.padding(top = 14.dp),
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
            ProgressBar(player = player,
                skill = Skill.DISCIPLINE,
                navigateTo = navigateTo,
                modifier = Modifier.padding(top = 14.dp))
            ProgressBar(player = player,
                skill = Skill.FORM,
                navigateTo = navigateTo)
            ProgressBar(player = player,
                skill = Skill.STAMINA,
                navigateTo = navigateTo)
            ProgressBar(player = player,
                skill = Skill.PACE,
                navigateTo = navigateTo,
                modifier = Modifier.padding(top = 14.dp))
            ProgressBar(player = player,
                skill = Skill.TECHNIQUE,
                navigateTo = navigateTo)
            ProgressBar(player = player,
                skill = Skill.PASSING,
                navigateTo = navigateTo)
            ProgressBar(player = player,
                skill = Skill.KEEPER,
                navigateTo = navigateTo)
            ProgressBar(player = player,
                skill = Skill.DEFENDING,
                navigateTo = navigateTo)
            ProgressBar(player = player,
                skill = Skill.PLAYMAKING,
                navigateTo = navigateTo)
            ProgressBar(player = player,
                skill = Skill.SCORING,
                navigateTo = navigateTo)
        }
    }
}

@Composable
private fun skill(skill: Int): String {
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
private fun Cards(player: Player) {
    if (player.cards != null && player.cards > 0) {
        Row {
            Text(
                stringResource(R.string.cards),
                style = characteritic
            )
            if (player.cards <= 2) {
                for (i in 0 until player.cards) {
                    Image(
                        painter = painterResource(id = R.drawable.yello_card),
                        contentDescription = stringResource(id = R.string.yellow_card),
                        Modifier
                            .padding(vertical = 2.dp)
                            .size(12.dp)
                    )
                }
            } else {
                Image(
                    painter = painterResource(id = R.drawable.red_card),
                    contentDescription = stringResource(id = R.string.red_card),
                    Modifier
                        .padding(vertical = 2.dp)
                        .size(12.dp)
                )
            }
        }
    }
}

@Composable
fun Injury(player: Player) {
    if (player.injuryDays != null && player.injuryDays > 0) {
        Row {
            Text(
                stringResource(R.string.injury) + " " + player.injuryDays + " " + stringResource(R.string.days),
                style = characteritic
            )
            Image(
                painter = painterResource(id = if (player.injuryDays <= 7) R.drawable.injury_low else R.drawable.injury_high),
                contentDescription = stringResource(id = R.string.red_card),
                Modifier
                    .padding(vertical = 2.dp)
                    .size(12.dp)
            )
        }
    }
}

@Composable
fun ProgressBar(
    player: Player,
    skill: Skill,
    navigateTo: (route: String) -> Unit,
    modifier: Modifier = Modifier
) {
    if(player.playerStatuses.size > 1) {
        val finalModifier = modifier.height(26.dp).width(70.dp)
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
                    .build()
            )
        )
        .build()
    Player(player) { println(it) }
}
