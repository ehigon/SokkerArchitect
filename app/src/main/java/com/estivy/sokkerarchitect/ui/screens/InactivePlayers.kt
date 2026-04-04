package com.estivy.sokkerarchitect.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.ui.SokkerArchitectScreen
import com.estivy.sokkerarchitect.ui.screens.composables.ErrorScreen
import com.estivy.sokkerarchitect.ui.screens.composables.FinishAppBackPressHandler
import com.estivy.sokkerarchitect.ui.screens.composables.LoadingScreen
import com.estivy.sokkerarchitect.ui.screens.composables.PlayersListScreen
import com.estivy.sokkerarchitect.ui.screens.model.PlayersUiState
import com.estivy.sokkerarchitect.ui.screens.model.PlayersViewModel

@Composable
fun InactivePlayers(playersViewModel: PlayersViewModel, navigateTo: (route: String) -> Unit) {
    playersViewModel.retrieveInactivePlayers()
    FinishAppBackPressHandler()
    val modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    when (playersViewModel.inactivePlayersUiState) {
        is PlayersUiState.Loading, PlayersUiState.NotStarted -> LoadingScreen()
        is PlayersUiState.Success -> PlayersListScreen(
            playersState = playersViewModel.inactivePlayersUiState as PlayersUiState.Success,
            title = stringResource(id = R.string.number_of_players),
            modifier = modifier,
            navigateTo = navigateTo,
            playerRoute = SokkerArchitectScreen.INACTIVE_PLAYER.route
        )

        is PlayersUiState.Error -> ErrorScreen((playersViewModel.inactivePlayersUiState as PlayersUiState.Error).exception)
    }
}
