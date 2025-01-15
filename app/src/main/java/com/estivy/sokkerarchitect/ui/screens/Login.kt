package com.estivy.sokkerarchitect.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.core.service.UpdateService
import com.estivy.sokkerarchitect.ui.SokkerArchitectScreen
import com.estivy.sokkerarchitect.ui.screens.composables.getMessage

enum class Status {
    NONE,
    SUCCESS,
    ERROR
}

@Composable
fun Login(updateService: UpdateService, navigateTo: (route: String) -> Unit) {
    val status = remember { mutableStateOf(Status.NONE) }
    val exception = remember { mutableStateOf(null as RuntimeException?) }
    val loading = remember { mutableStateOf(false) }
    if(loading.value) {
        Updating()
    }else{
        Login(updateService, status, exception, loading)
    }

    if (status.value == Status.ERROR) {
        LoginErrorAlertDialog(status = status, getMessage(exception.value))
    }
    if (status.value == Status.SUCCESS) {
        navigateTo(SokkerArchitectScreen.PLAYERS.route)
    }
}

@Composable
private fun Login(
    updateService: UpdateService,
    status: MutableState<Status>,
    exception: MutableState<RuntimeException?>,
    loading: MutableState<Boolean>
) {
    val modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        User(
            user, onValueChange = { user = it },
            Modifier.padding(bottom = 8.dp)
        )
        Password(
            password, onValueChange = { password = it },
            Modifier.padding(bottom = 8.dp)
        )
        Button(
            onClick = {
                loading.value = true
                updateService.update(user, password)
                    .thenApply {
                        status.value = Status.SUCCESS
                        loading.value = false
                    }.exceptionally { e ->
                        e.printStackTrace()
                        if (e.cause != null && e.cause is RuntimeException) {
                            exception.value = e.cause as RuntimeException
                        }
                        status.value = Status.ERROR
                        loading.value = false
                    }
            },
            modifier = Modifier.size(width = 140.dp, height = 50.dp),
            enabled = user.isNotBlank() && password.isNotBlank()
        ) {
            Text(stringResource(R.string.login))
        }
    }
}

@Composable
fun User(
    user: String, onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = user,
        label = { Text(stringResource(R.string.user)) },
        onValueChange = onValueChange,
        modifier = modifier
    )
}

@Composable
fun Password(
    password: String, onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = password,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        label = { Text(stringResource(R.string.password)) },
        onValueChange = onValueChange,
        modifier = modifier
    )
}

@Composable
fun LoginErrorAlertDialog(
    status: MutableState<Status>,
    errorMessage: String?
) {
    if (status.value == Status.ERROR) {
        AlertDialog(
            onDismissRequest = {
                status.value = Status.NONE
            },
            title = { Text(text = stringResource(R.string.login_error_title)) },
            text = {
                Text(
                    text = stringResource(R.string.login_error_message) + (errorMessage
                        ?: "")
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        status.value = Status.NONE
                    }
                ) {
                    Text(
                        text = stringResource(R.string.ok),
                        color = Color.White
                    )
                }
            },
            icon = { android.R.drawable.stat_sys_warning }
        )
    }
}