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
import java.util.concurrent.locks.ReentrantLock
import javax.inject.Inject
import kotlin.concurrent.withLock

sealed interface PlayersUiState {
    data class Success(val players: List<Player>) : PlayersUiState
    data class Error(val exception: Exception) : PlayersUiState
    object Loading : PlayersUiState
    object NotStarted : PlayersUiState
}

@HiltViewModel
class PlayersViewModel @Inject constructor(private val playersService: PlayersService) :
    ViewModel() {

    val lock = ReentrantLock()

    var playersUiState: PlayersUiState by mutableStateOf(PlayersUiState.NotStarted)
        private set

    var juniorsUiState: PlayersUiState by mutableStateOf(PlayersUiState.NotStarted)

    fun retrievePlayers() {
        lock.withLock {
            if(playersUiState !is PlayersUiState.NotStarted){
                return
            }
            playersUiState = PlayersUiState.Loading
        }
        viewModelScope.launch((Dispatchers.Default)) {
            try {
                val players = playersService.findPlayers()
                lock.withLock {
                    playersUiState = PlayersUiState.Success(players)
                }
            } catch (ex: Exception) {
                lock.withLock {
                    playersUiState = PlayersUiState.Error(ex)
                }
            }
        }
    }

    fun retrieveJuniors() {
        lock.withLock {
            if(juniorsUiState !is PlayersUiState.NotStarted){
                return
            }
            juniorsUiState = PlayersUiState.Loading
        }
        viewModelScope.launch((Dispatchers.Default)) {
            try {
                val juniors = playersService.findJuniors()
                lock.withLock {
                    juniorsUiState = PlayersUiState.Success(juniors)
                }
            } catch (ex: Exception) {
                lock.withLock {
                    juniorsUiState = PlayersUiState.Error(ex)
                }

            }
        }
    }

    fun dataUpdated(){
        lock.withLock {
            playersUiState = PlayersUiState.NotStarted
            juniorsUiState = PlayersUiState.NotStarted
        }
    }
}
