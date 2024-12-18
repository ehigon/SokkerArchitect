package com.estivy.sokkerarchitect.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.core.service.UpdateService
import com.estivy.sokkerarchitect.ui.SokkerArchitectScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch


@Composable
fun Login(updateService: UpdateService, navigateTo: (route: String) -> Unit) {
    var modifier = Modifier
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
                updateService.update(user, password)
                    .thenApply {
                        runOnUiThread { navigateTo(SokkerArchitectScreen.players.route) }
                        println("logged in")
                    }.exceptionally { e ->
                        println("error " + e.message)
                        e.printStackTrace()
                    }
            },
            modifier = Modifier.size(width = 140.dp, height = 50.dp)
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

val uiScope = CoroutineScope(Dispatchers.Main + SupervisorJob())
fun runOnUiThread(block: suspend () -> Unit) = uiScope.launch { block() }