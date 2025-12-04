package com.estivy.sokkerarchitect.ui.util

import com.estivy.sokkerarchitect.core.domain.Player
import com.estivy.sokkerarchitect.ui.screens.model.PlayerWrapper
import com.estivy.sokkerarchitect.ui.screens.model.PlayersUiState
import com.estivy.sokkerarchitect.ui.screens.model.PlayersViewModel

fun searchPlayer(playersViewModel: PlayersViewModel, id: String?): PlayerWrapper? {
    id?.let {
        if (playersViewModel.playersUiState is PlayersUiState.Success) {
            return searchPlayer(
                (playersViewModel.playersUiState as PlayersUiState.Success).players,
                it.toLong()
            )
        }
    }
    return null
}

fun searchJunior(playersViewModel: PlayersViewModel, id: String?): PlayerWrapper? {
    id?.let {
        if (playersViewModel.juniorsUiState is PlayersUiState.Success) {
            return searchPlayer(
                (playersViewModel.juniorsUiState as PlayersUiState.Success).players,
                it.toLong()
            )
        }
    }
    return null
}

private fun searchPlayer(players: List<PlayerWrapper>, id: Long): PlayerWrapper {
    return players.filter { it.player.id.equals(id) }[0]
}