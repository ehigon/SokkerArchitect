package com.estivy.sokkerarchitect.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.core.service.UpdateService


enum class MessageDialog{
    NONE,
    SUCCESS,
    ERROR
}

enum class UpdateState{
    NOT_STARTED,
    IN_PROGRESS,
    SUCCESS,
    ERROR
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SokkerArchitectAppBar(
    currentScreen: SokkerArchitectScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    updateService: UpdateService,
    navigateTo: (route: String) -> Unit
) {
    val shouldShowDialog = remember { mutableStateOf(MessageDialog.NONE) }
    val errorMessage = remember { mutableStateOf(null as String?) }
    val updating = remember { mutableStateOf(UpdateState.NOT_STARTED) }
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        },
        actions = {
            if (currentScreen != SokkerArchitectScreen.login) {
                Button(
                    onClick = {
                        updating.value = UpdateState.IN_PROGRESS
                        navigateTo(SokkerArchitectScreen.updating.route)
                        updateService.update()
                            .thenApply {
                                updating.value = UpdateState.SUCCESS
                                shouldShowDialog.value = MessageDialog.SUCCESS
                            }.exceptionally { e ->
                                updating.value = UpdateState.ERROR
                                e.printStackTrace()
                                errorMessage.value = e.message
                                shouldShowDialog.value = MessageDialog.ERROR
                            }
                    },
                    content = {
                        Image(
                            painter = painterResource(id = R.drawable.update),
                            contentDescription = stringResource(id = R.string.update),
                            Modifier
                                .padding(vertical = 2.dp)
                                .size(22.dp)
                        )
                    },
                    colors = ButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Transparent,
                        disabledContentColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent
                    ),
                    enabled = updating.value == UpdateState.NOT_STARTED
                )
            }
        }
    )
    if (shouldShowDialog.value == MessageDialog.SUCCESS) {
        UpdateAlertDialog(shouldShowDialog = shouldShowDialog)
    }else if(shouldShowDialog.value == MessageDialog.ERROR){
        UpdateErrorAlertDialog(shouldShowDialog= shouldShowDialog, errorMessage)
    }
    if(updating.value == UpdateState.SUCCESS){
        updating.value = UpdateState.NOT_STARTED
        navigateTo(SokkerArchitectScreen.players.route)
    }else if(updating.value == UpdateState.ERROR){
        updating.value = UpdateState.NOT_STARTED
        navigateTo(SokkerArchitectScreen.login.route)
    }

}

@Composable
fun UpdateAlertDialog(
    shouldShowDialog: MutableState<MessageDialog>
) {
    if (shouldShowDialog.value == MessageDialog.SUCCESS) {
        AlertDialog(
            onDismissRequest = {
                shouldShowDialog.value = MessageDialog.NONE
            },
            title = { Text(text = stringResource(R.string.update_success_title)) },
            text = { Text(text = stringResource(R.string.update_success_message)) },
            confirmButton = {
                Button(
                    onClick = {
                        shouldShowDialog.value = MessageDialog.NONE
                    }
                ) {
                    Text(
                        text = stringResource(R.string.ok),
                        color = Color.White
                    )
                }
            },
            icon = { Icons.Default.Info }
        )
    }
}

@Composable
fun UpdateErrorAlertDialog(
    shouldShowDialog: MutableState<MessageDialog>,
    errorMessage: MutableState<String?>
) {
    if (shouldShowDialog.value == MessageDialog.ERROR) {
        AlertDialog(
            onDismissRequest = {
                shouldShowDialog.value = MessageDialog.NONE
            },
            title = { Text(text = stringResource(R.string.update_error_title)) },
            text = { Text(text = stringResource(R.string.update_error_message)  + (errorMessage.value?: "") ) },
            confirmButton = {
                Button(
                    onClick = {
                        shouldShowDialog.value = MessageDialog.NONE
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