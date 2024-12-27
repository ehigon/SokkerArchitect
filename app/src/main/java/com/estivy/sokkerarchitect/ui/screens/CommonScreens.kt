package com.estivy.sokkerarchitect.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.estivy.sokkerarchitect.R
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