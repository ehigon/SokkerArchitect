package com.estivy.sokkerarchitect.ui.screens.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.estivy.sokkerarchitect.core.domain.Player
import com.estivy.sokkerarchitect.core.service.PlayersService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface PlayersUiState {
    data class Success(val players: List<Player>) : PlayersUiState
    data class Error(val exception: Exception) : PlayersUiState
    object Loading : PlayersUiState
}

@HiltViewModel
class PlayersViewModel @Inject constructor(private val playersService: PlayersService) :
    ViewModel() {
    var playersUiState: PlayersUiState by mutableStateOf(PlayersUiState.Loading)
        private set

    var juniorsUiState: PlayersUiState by mutableStateOf(PlayersUiState.Loading)

    fun retrievePlayers() {
        viewModelScope.launch((Dispatchers.Default)) {
            playersUiState = PlayersUiState.Loading
            playersUiState = try {
                PlayersUiState.Success(playersService.findPlayers())
            } catch (ex: Exception) {
                PlayersUiState.Error(ex)
            }
        }
    }

    fun retrieveJuniors() {
        viewModelScope.launch((Dispatchers.Default)) {
            juniorsUiState = PlayersUiState.Loading
            juniorsUiState = try {
                PlayersUiState.Success(playersService.findJuniors())
            } catch (ex: Exception) {
                PlayersUiState.Error(ex)
            }

        }
    }
}
