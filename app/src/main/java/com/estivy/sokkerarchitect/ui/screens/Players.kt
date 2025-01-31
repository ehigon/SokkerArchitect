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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.core.domain.Country
import com.estivy.sokkerarchitect.core.domain.Player
import com.estivy.sokkerarchitect.core.domain.PlayerStatus
import com.estivy.sokkerarchitect.ui.SokkerArchitectScreen
import com.estivy.sokkerarchitect.ui.screens.composables.Cards
import com.estivy.sokkerarchitect.ui.screens.composables.ErrorScreen
import com.estivy.sokkerarchitect.ui.screens.composables.FinishAppBackPressHandler
import com.estivy.sokkerarchitect.ui.screens.composables.Injury
import com.estivy.sokkerarchitect.ui.screens.composables.LoadingScreen
import com.estivy.sokkerarchitect.ui.screens.composables.skill
import com.estivy.sokkerarchitect.ui.screens.model.PlayersUiState
import com.estivy.sokkerarchitect.ui.screens.model.PlayersViewModel
import com.estivy.sokkerarchitect.ui.theme.subPlayer
import com.estivy.sokkerarchitect.ui.util.Evolution

@Composable
fun Players(playersViewModel: PlayersViewModel, navigateTo: (route: String) -> Unit) {
    FinishAppBackPressHandler()
    val modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    when (playersViewModel.playersUiState) {
        is PlayersUiState.Loading -> LoadingScreen()
        is PlayersUiState.Success -> PlayersScreen(
            (playersViewModel.playersUiState as PlayersUiState.Success),
            modifier,
            navigateTo
        )

        is PlayersUiState.Error -> ErrorScreen((playersViewModel.playersUiState as PlayersUiState.Error).exception)
    }

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
            items(playersViewModelSuccess.players.sortedBy { it.surname + it.name }) { player ->
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
    val evolution = Evolution(player)
    Card(
        modifier = Modifier
            .padding(1.dp)
            .fillMaxWidth(),
        onClick = {
            navigateTo(SokkerArchitectScreen.PLAYER.route.replace("{id}", player.id.toString()))
        }

    )
    {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Column {
                Row {
                    Text(player.name + " " + player.surname)
                }
                Row(
                    modifier = Modifier.padding(top = 3.dp)
                ) {
                    val currentWeek = player.playerStatuses.maxBy { ps -> ps.week }
                    if(currentWeek != null) {
                        Text(
                            stringResource(R.string.age) + " " + player.age,
                            style = subPlayer
                        )
                        Text(
                            modifier = Modifier.padding(start = 10.dp),
                            text = stringResource(R.string.form) + ": " + skill(currentWeek.skillForm),
                            style = subPlayer
                        )
                    }
                }
            }
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Injury(player, 12, 16)
                    Cards(player, 12, 16)
                    for (i in 0 until evolution.getIncreases()) {
                        Image(
                            painter = painterResource(id = R.drawable.up_arrow),
                            contentDescription = stringResource(id = R.string.increase),
                            Modifier
                                .padding(vertical = 12.dp)
                                .size(16.dp)
                        )
                    }
                    for (i in 0 until evolution.getDecreases()) {
                        Image(
                            painter = painterResource(id = R.drawable.down_arrow),
                            contentDescription = stringResource(id = R.string.decrease),
                            Modifier
                                .padding(vertical = 12.dp)
                                .size(16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PlayerRowPreview() {
    val player: Player = Player.builder()
        .name("Esteban")
        .surname("Higon")
        .value(1345678986)
        .age(23)
        .height(183)
        .weight(80.5)
        .cards(1)
        .injuryDays(6)
        .country(
            Country.builder()
                .name("Spain")
                .countryId(34)
                .build()
        )
        .playerStatuses(
            listOf(
                PlayerStatus.builder()
                    .week(123)
                    .skillForm(10)
                    .skillPace(9)
                    .skillKeeper(1)
                    .skillPassing(12)
                    .skillDefending(11)
                    .skillDiscipline(10)
                    .skillExperience(8)
                    .skillPlaymaking(9)
                    .skillScoring(18)
                    .skillStamina(17)
                    .skillTeamwork(12)
                    .skillTechnique(15)
                    .build(),
                PlayerStatus.builder()
                    .week(124)
                    .skillForm(10)
                    .skillPace(9)
                    .skillKeeper(0)
                    .skillPassing(13)
                    .skillDefending(12)
                    .skillDiscipline(9)
                    .skillExperience(8)
                    .skillPlaymaking(9)
                    .skillScoring(18)
                    .skillStamina(17)
                    .skillTeamwork(13)
                    .skillTechnique(15)
                    .build()
            )
        )
        .build()
    PlayerRow(player) { r -> print(r) }
}

