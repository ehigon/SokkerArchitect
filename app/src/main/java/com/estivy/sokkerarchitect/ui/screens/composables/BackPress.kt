package com.estivy.sokkerarchitect.ui.screens.composables

import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.estivy.sokkerarchitect.R

private const val DOUBLE_TAP_DELAY_MS = 2000L

@Composable
fun FinishAppBackPressHandler(){
    val activity = LocalActivity.current
    val context = LocalContext.current
    val exitMessage = stringResource(R.string.press_back_again_to_exit)
    var lastBackPressTime by remember { mutableStateOf(0L) }
    
    BackPressHandler(onBackPressed = {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastBackPressTime < DOUBLE_TAP_DELAY_MS) {
            activity?.finish()
        } else {
            lastBackPressTime = currentTime
            Toast.makeText(context, exitMessage, Toast.LENGTH_SHORT).show()
        }
    })
}

@Composable
fun BackPressHandler(
    backPressedDispatcher: OnBackPressedDispatcher? =
        LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher,
    onBackPressed: () -> Unit
) {
    val currentOnBackPressed by rememberUpdatedState(newValue = onBackPressed)

    val backCallback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                currentOnBackPressed()
            }
        }
    }

    DisposableEffect(key1 = backPressedDispatcher) {
        backPressedDispatcher?.addCallback(backCallback)

        onDispose {
            backCallback.remove()
        }
    }
}
