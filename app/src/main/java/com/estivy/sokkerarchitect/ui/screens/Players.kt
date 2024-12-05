package com.estivy.sokkerarchitect.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.estivy.sokkerarchitect.core.domain.Player
import com.estivy.sokkerarchitect.ui.SokkerArchitectScreen

@Composable
fun Players(playersViewModel: PlayersViewModel, navigateTo: (route: String) -> Unit) {
    val modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    when (playersViewModel.playersUiState) {
        is PlayersUiState.Loading -> LoadingScreen()
        is PlayersUiState.Success -> PlayersScreen((playersViewModel.playersUiState as PlayersUiState.Success), modifier, navigateTo)
        is PlayersUiState.Error -> ErrorScreen((playersViewModel.playersUiState as PlayersUiState.Error).exception)
    }

}

@Composable
fun LoadingScreen() {
    Text(text = "Loading...")
}

@Composable
fun ErrorScreen(exception: Exception) {
    exception.printStackTrace()
    Text(text = "Error" + exception.message)
}

@Composable
fun PlayersScreen(
    playersViewModelSuccess: PlayersUiState.Success,
    modifier: Modifier,
    navigateTo: (route: String) -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 1.dp),
        ) {
            items(playersViewModelSuccess.players) { player ->
                PlayerRow(player, navigateTo)
            }
        }

    }
}

@Composable
fun PlayerRow(
    player: Player,
    navigateTo: (route: String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(1.dp)
            .fillMaxWidth(),
        onClick = {
            navigateTo(SokkerArchitectScreen.player.route.replace("{id}", player.id.toString()))
        }

    )
    {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(player.name + " " + player.surname)
        }
    }
}

