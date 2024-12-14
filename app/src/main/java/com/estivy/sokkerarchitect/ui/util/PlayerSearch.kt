package com.estivy.sokkerarchitect.ui.util

import com.estivy.sokkerarchitect.core.domain.Player
import com.estivy.sokkerarchitect.ui.screens.model.PlayersUiState
import com.estivy.sokkerarchitect.ui.screens.model.PlayersViewModel

fun searchPlayer(playersViewModel: PlayersViewModel, id: String?): Player? {
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

private fun searchPlayer(players: List<Player>, id: Long): Player {
    return players.filter { it.id.equals(id) }[0]
}