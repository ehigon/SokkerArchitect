package com.estivy.sokkerarchitect.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.estivy.sokkerarchitect.core.service.PlayersService
import com.estivy.sokkerarchitect.core.service.UpdateService
import com.estivy.sokkerarchitect.security.service.PasswordStorageService
import com.estivy.sokkerarchitect.ui.screens.model.PlayersViewModel
import com.estivy.sokkerarchitect.ui.theme.SokkerArchitectTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val playersViewModel: PlayersViewModel by viewModels()
    @Inject lateinit var updateService: UpdateService
    @Inject lateinit var passwordStorageService: PasswordStorageService
    @Inject lateinit var playersService: PlayersService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SokkerArchitectTheme {
                SokkerArchitectApp(updateService = updateService,
                    playersService = playersService,
                    playersViewModel = playersViewModel,
                    passwordStorageService = passwordStorageService)
            }
        }
    }
}

