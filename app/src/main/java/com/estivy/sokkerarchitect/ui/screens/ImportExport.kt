package com.estivy.sokkerarchitect.ui.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.core.domain.Player
import com.estivy.sokkerarchitect.core.service.PlayersService
import com.estivy.sokkerarchitect.ui.screens.composables.FinishAppBackPressHandler
import com.estivy.sokkerarchitect.ui.screens.model.PlayersViewModel
import com.google.gson.Gson
import java.io.InputStreamReader
import java.util.Date
import java.util.concurrent.CompletableFuture


enum class ImportStatus {
    NONE,
    IMPORT_SUCCESS,
    EXPORT_SUCCESS,
    IMPORT_ERROR,
    EXPORT_ERROR
}

@Composable
fun ImportExport(playersService: PlayersService, playersViewModel: PlayersViewModel) {
    FinishAppBackPressHandler()
    val loading = remember { mutableStateOf(false) }
    val status = remember { mutableStateOf(ImportStatus.NONE) }
    if (loading.value) {
        Updating()
    } else {
        ImportExport(playersService, loading, status, playersViewModel)
    }

    if (status.value == ImportStatus.IMPORT_ERROR || status.value == ImportStatus.EXPORT_ERROR) {
        ImportExportErrorAlertDialog(status = status)
    }
    if (status.value == ImportStatus.IMPORT_SUCCESS || status.value == ImportStatus.EXPORT_SUCCESS) {
        ImportExportSuccessAlertDialog(status = status)
    }
}

@Composable
fun ImportExport(
    playersService: PlayersService,
    loading: MutableState<Boolean>,
    status: MutableState<ImportStatus>,
    playersViewModel: PlayersViewModel
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(30.dp))
        ImportButton(loading, playersService, status, playersViewModel)
        Spacer(Modifier.height(30.dp))
        ExportButton(loading, playersService, status)
    }
}

@Composable
private fun ImportButton(
    loading: MutableState<Boolean>,
    playersService: PlayersService,
    status: MutableState<ImportStatus>,
    playersViewModel: PlayersViewModel
) {
    val context = LocalContext.current
    val importDataLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.GetContent()
        ) {
            if (it != null) {
                CompletableFuture.supplyAsync {
                    loading.value = true
                    val reader = InputStreamReader(context.contentResolver.openInputStream(it))
                    val playersRidden = Gson().fromJson(reader, Array<Player>::class.java)
                    playersService.save(playersRidden.toList())
                }.thenApply {
                    playersViewModel.dataUpdated()
                    status.value = ImportStatus.IMPORT_SUCCESS
                    loading.value = false
                }.exceptionally { e->
                    e.printStackTrace()
                    status.value = ImportStatus.IMPORT_ERROR
                    loading.value = false
                }
            }
        }
    Button(
        onClick = {
            importDataLauncher.launch("application/json")
        },
        modifier = Modifier.size(width = 140.dp, height = 50.dp)
    ) {
        Text(stringResource(R.string.import_data))
    }
}

@Composable
private fun ExportButton(
    loading: MutableState<Boolean>,
    playersService: PlayersService,
    status: MutableState<ImportStatus>
) {
    val context = LocalContext.current
    val exportDataLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.CreateDocument("application/json")
        ) {
            if (it != null) {
                CompletableFuture.supplyAsync {
                    loading.value = true
                    val jsonString = Gson().toJson(playersService.findAll())
                    context.contentResolver.openOutputStream(it)
                        ?.bufferedWriter()?.apply {
                            write(jsonString)
                            flush()
                        }
                }.thenApply {
                    status.value = ImportStatus.EXPORT_SUCCESS
                    loading.value = false
                }.exceptionally { e->
                    e.printStackTrace()
                    status.value = ImportStatus.EXPORT_ERROR
                    loading.value = false
                }
            }
        }
    Button(
        onClick = {
            exportDataLauncher.launch("backup${Date().time}.json")
        },
        modifier = Modifier.size(width = 140.dp, height = 50.dp)
    ) {
        Text(stringResource(R.string.export_data))
    }
}

@Composable
fun ImportExportErrorAlertDialog(status: MutableState<ImportStatus>) {
    val errorMessageResourceString =
        if (status.value == ImportStatus.IMPORT_ERROR) R.string.import_error
        else R.string.export_error
    AlertDialog(
        onDismissRequest = {
            status.value = ImportStatus.NONE
        },
        title = { Text(text = stringResource(errorMessageResourceString)) },
        text = {
            Text(
                text = stringResource(errorMessageResourceString)
            )
        },
        confirmButton = {
            Button(
                onClick = {
                    status.value = ImportStatus.NONE
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

@Composable
fun ImportExportSuccessAlertDialog(status: MutableState<ImportStatus>) {
    val errorMessageResourceString =
        if (status.value == ImportStatus.IMPORT_SUCCESS) R.string.import_success
        else R.string.export_success
    AlertDialog(
        onDismissRequest = {
            status.value = ImportStatus.NONE
        },
        title = { Text(text = stringResource(errorMessageResourceString)) },
        text = {
            Text(
                text = stringResource(errorMessageResourceString)
            )
        },
        confirmButton = {
            Button(
                onClick = {
                    status.value = ImportStatus.NONE
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
