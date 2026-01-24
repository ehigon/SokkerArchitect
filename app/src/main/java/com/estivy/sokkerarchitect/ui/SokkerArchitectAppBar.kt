package com.estivy.sokkerarchitect.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.core.domain.exception.CredentialsLoginException
import com.estivy.sokkerarchitect.core.service.UpdateService
import com.estivy.sokkerarchitect.ui.screens.composables.getMessage
import com.estivy.sokkerarchitect.ui.screens.model.PlayersViewModel


enum class MessageDialog {
    NONE,
    SUCCESS,
    ERROR
}

enum class UpdateState {
    NOT_STARTED,
    IN_PROGRESS,
    SUCCESS,
    ERROR
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SokkerArchitectAppBar(
    currentScreen: SokkerArchitectScreen,
    shouldShowMenu: Boolean,
    modifier: Modifier = Modifier,
    updateService: UpdateService,
    navigateTo: (route: String) -> Unit,
    onNavigationIconClick: () -> Unit,
    playersViewModel: PlayersViewModel
) {
    val shouldShowDialog = remember { mutableStateOf(MessageDialog.NONE) }
    val updating = remember { mutableStateOf(UpdateState.NOT_STARTED) }
    val exception = remember { mutableStateOf(null as RuntimeException?) }

    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (shouldShowMenu) {
                IconButton(onClick = onNavigationIconClick) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = null,
                    )
                }
            }
        },
        actions = {
            if (currentScreen != SokkerArchitectScreen.LOGIN) {
                Button(
                    onClick = {
                        updating.value = UpdateState.IN_PROGRESS
                        navigateTo(SokkerArchitectScreen.UPDATING.route)
                        updateService.update()
                            .thenApply {
                                playersViewModel.dataUpdated()
                                updating.value = UpdateState.SUCCESS
                                shouldShowDialog.value = MessageDialog.SUCCESS
                            }.exceptionally { e ->
                                if(e.cause != null && e.cause is RuntimeException){
                                    exception.value = e.cause as RuntimeException
                                }
                                updating.value = UpdateState.ERROR
                                e.printStackTrace()
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
    } else if (shouldShowDialog.value == MessageDialog.ERROR) {
        UpdateErrorAlertDialog(shouldShowDialog = shouldShowDialog, getMessage(exception.value))
    }
    if (updating.value == UpdateState.SUCCESS) {
        updating.value = UpdateState.NOT_STARTED
        navigateTo(SokkerArchitectScreen.PLAYERS.route)
    } else if (updating.value == UpdateState.ERROR) {
        updating.value = UpdateState.NOT_STARTED
        navigateTo(
            if (exception.value is CredentialsLoginException) SokkerArchitectScreen.LOGIN.route
            else SokkerArchitectScreen.PLAYERS.route
        )
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
            icon = {
                Icon(imageVector = Icons.Default.Info, contentDescription = null)
            }
        )
    }
}

@Composable
fun UpdateErrorAlertDialog(
    shouldShowDialog: MutableState<MessageDialog>,
    errorMessage: String?
) {
    if (shouldShowDialog.value == MessageDialog.ERROR) {
        AlertDialog(
            onDismissRequest = {
                shouldShowDialog.value = MessageDialog.NONE
            },
            title = { Text(text = stringResource(R.string.update_error_title)) },
            text = {
                Text(
                    text = stringResource(R.string.update_error_message) + (errorMessage
                        ?: "")
                )
            },
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
            icon = {
                Icon(
                    painter = painterResource(id = android.R.drawable.stat_sys_warning),
                    contentDescription = stringResource(R.string.update_error_title),
                    tint = Color.Red
                )
            }
        )
    }
}