package com.estivy.sokkerarchitect.ui.screens.composables

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
    if(exception == null || exception !is LoginException){
        return stringResource(R.string.unknown)
    }
    return stringResource(LoginErrorMapping.fromLoginError(exception.loginError).resource)
}

@Composable
fun JuniorDetails(
    currentWeek : JuniorStatus,
    textStyle: TextStyle,
    textAlign: TextAlign = TextAlign.Unspecified
) {
    Text(
        style = textStyle,
        text = stringResource(R.string.age) + " " + currentWeek.age,
        textAlign = textAlign
    )
    TextWithValue(stringResource(R.string.skill), currentWeek.skill, textStyle, textAlign)
    TextWithValue(stringResource(R.string.weeks), currentWeek.remainingWeeks, textStyle, textAlign)
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