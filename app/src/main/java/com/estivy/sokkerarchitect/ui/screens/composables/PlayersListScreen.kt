package com.estivy.sokkerarchitect.ui.screens.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.ui.SokkerArchitectScreen
import com.estivy.sokkerarchitect.ui.screens.model.PlayersUiState

@Composable
fun PlayersListScreen(
    playersState: PlayersUiState.Success,
    title: String,
    modifier: Modifier = Modifier,
    navigateTo: (route: String) -> Unit,
    playerRoute: String = SokkerArchitectScreen.PLAYER.route
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title + " " + playersState.players.size.toString(),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 1.dp),
        ) {
            items(playersState.players.sortedBy { it.player.surname + it.player.name }) { player ->
                PlayerRow(player, navigateTo, playerRoute)
            }
        }
    }
}
