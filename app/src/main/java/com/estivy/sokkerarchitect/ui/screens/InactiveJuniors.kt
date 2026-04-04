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
import com.estivy.sokkerarchitect.ui.screens.composables.JuniorsListScreen
import com.estivy.sokkerarchitect.ui.screens.model.PlayersUiState
import com.estivy.sokkerarchitect.ui.screens.model.PlayersViewModel

@Composable
fun InactiveJuniors(playersViewModel: PlayersViewModel, navigateTo: (route: String) -> Unit) {
    playersViewModel.retrieveInactiveJuniors()
    FinishAppBackPressHandler()
    val modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    when (playersViewModel.inactiveJuniorsUiState) {
        is PlayersUiState.Loading, PlayersUiState.NotStarted -> LoadingScreen()
        is PlayersUiState.Success -> JuniorsListScreen(
            playersState = playersViewModel.inactiveJuniorsUiState as PlayersUiState.Success,
            title = stringResource(id = R.string.number_of_players),
            modifier = modifier,
            navigateTo = navigateTo,
            juniorRoute = SokkerArchitectScreen.INACTIVE_JUNIOR.route
        )

        is PlayersUiState.Error -> ErrorScreen((playersViewModel.inactiveJuniorsUiState as PlayersUiState.Error).exception)
    }
}
