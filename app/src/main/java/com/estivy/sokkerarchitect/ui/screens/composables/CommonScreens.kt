package com.estivy.sokkerarchitect.ui.screens.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.core.domain.JuniorStatus
import com.estivy.sokkerarchitect.core.domain.exception.LoginException
import com.estivy.sokkerarchitect.ui.screens.model.PlayerWrapper
import com.estivy.sokkerarchitect.ui.util.LoginErrorMapping

@Composable
fun LoadingScreen() {
    Text(text = "Loading...")
}

@Composable
fun ErrorScreen(exception: Exception) {
    exception.printStackTrace()
    Text(text = "Error" + exception.message)
}

@Composable
fun getMessage(exception: RuntimeException?): String {
    if (exception == null || exception !is LoginException) {
        return stringResource(R.string.unknown)
    }
    return stringResource(LoginErrorMapping.fromLoginError(exception.loginError).resource)
}

@Composable
fun JuniorDetails(
    currentWeek: JuniorStatus,
    player: PlayerWrapper,
    textStyle: TextStyle,
    textAlign: TextAlign = TextAlign.Unspecified
) {
    val talent = getTalent(player)
    val estimated = getEstimatedSkill(player, currentWeek)
    val expected = getExpectedSkill(player, currentWeek)
    Column {
        Row {
            Text(
                style = textStyle,
                text = stringResource(R.string.age) + " " + currentWeek.age,
                textAlign = textAlign
            )
            TextWithValue(stringResource(R.string.skill), currentWeek.skill, textStyle, textAlign)
            TextWithValue(
                stringResource(R.string.weeks),
                currentWeek.remainingWeeks,
                textStyle,
                textAlign
            )
            TextWithValue(stringResource(R.string.talent), if (talent != null) "%.2f".format(
                talent
            ) else "-", textStyle, textAlign)
        }
        Row {
            Text(

                style = textStyle,
                text = stringResource(R.string.estimated_skill) + ":",
                textAlign = TextAlign.Center
            )
            TextWithValue(stringResource(R.string.current), estimated, textStyle, textAlign)
            TextWithValue(stringResource(R.string.finalsk), expected, textStyle, textAlign)
        }
    }
}

@Composable
fun TextWithValue(name: String, value: Int, textStyle: TextStyle, textAlign: TextAlign) {
    Text(
        modifier = Modifier.padding(start = 8.dp),
        style = textStyle,
        text = name + if (value > 9) {
            ": "
        } else {
            ":   "
        } + value,
        textAlign = textAlign
    )
}

@Composable
fun TextWithValue(name: String, value: String, textStyle: TextStyle, textAlign: TextAlign) {
    Text(
        modifier = Modifier.padding(start = 8.dp),
        style = textStyle,
        text = name + if (value.length > 1) {
            ": "
        } else {
            ":   "
        } + value,
        textAlign = textAlign
    )
}

fun getTalent(player: PlayerWrapper): Float? {
    if (player.points.size < 2) {
        return null
    }
    return 1 / player.linearRegression.b1
}

fun getExpectedSkill(player: PlayerWrapper, currentWeek: JuniorStatus): String {
    if (player.points.size <= 2) {
        return "-";
    }
    val expected = player.linearRegression
        .calculateY(currentWeek.week + currentWeek.remainingWeeks + 0.0f)
    return "%.2f".format(expected)
}

fun getEstimatedSkill(player: PlayerWrapper, currentWeek: JuniorStatus): String {
    if (player.points.size <= 2) {
        return "-";
    }
    val expected = player.linearRegression
        .calculateY(currentWeek.week + 0.0f)
    return "%.2f".format(expected)
}