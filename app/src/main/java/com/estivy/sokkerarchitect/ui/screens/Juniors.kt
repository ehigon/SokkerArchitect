package com.estivy.sokkerarchitect.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.core.domain.Player
import com.estivy.sokkerarchitect.ui.SokkerArchitectScreen
import com.estivy.sokkerarchitect.ui.screens.model.PlayersUiState
import com.estivy.sokkerarchitect.ui.screens.model.PlayersViewModel
import com.estivy.sokkerarchitect.ui.util.JuniorEvolution

@Composable
fun Juniors(playersViewModel: PlayersViewModel, navigateTo: (route: String) -> Unit) {
    val modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    when (playersViewModel.juniorsUiState) {
        is PlayersUiState.Loading -> LoadingScreen()
        is PlayersUiState.Success -> JuniorsScreen(
            (playersViewModel.juniorsUiState as PlayersUiState.Success),
            modifier,
            navigateTo
        )

        is PlayersUiState.Error -> ErrorScreen((playersViewModel.juniorsUiState as PlayersUiState.Error).exception)
    }
}

@Composable
fun JuniorsScreen(
    juniorsUiStateSuccess: PlayersUiState.Success,
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
            items(juniorsUiStateSuccess.players.sortedBy
            { JuniorEvolution(it).currentWeek.remainingWeeks }) { player ->
                JuniorRow(player, navigateTo)
            }
        }

    }
}

@Composable
fun JuniorRow(player: Player, navigateTo: (route: String) -> Unit) {

    val evolution = JuniorEvolution(player)
    Card(
        modifier = Modifier
            .padding(1.dp)
            .fillMaxWidth(),
        onClick = {
            if (player.juniorStatuses.size > 1) {
                navigateTo(SokkerArchitectScreen.JUNIOR.route.replace("{id}", player.id.toString()))
            }
        }

    )
    {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(player.name + " " + player.surname)
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom
            )
            {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                )
                {
                    Text(
                        fontSize = 12.sp,
                        text = stringResource(R.string.skill) + ": " + evolution.currentWeek.skill
                    )
                    Text(
                        modifier = Modifier.padding(start = 2.dp),
                        fontSize = 12.sp,
                        text = stringResource(R.string.weeks) + ": " + evolution.currentWeek.remainingWeeks
                    )
                    if (evolution.getSkill() > 0) {
                        Image(
                            painter = painterResource(id = R.drawable.up_arrow),
                            contentDescription = stringResource(id = R.string.increase),
                            Modifier
                                .padding(vertical = 2.dp)
                                .size(12.dp)
                        )
                    } else if (evolution.getSkill() < 0) {
                        Image(
                            painter = painterResource(id = R.drawable.down_arrow),
                            contentDescription = stringResource(id = R.string.decrease),
                            Modifier
                                .padding(vertical = 2.dp)
                                .size(12.dp)
                        )
                    }
                }
            }
        }
    }
}
