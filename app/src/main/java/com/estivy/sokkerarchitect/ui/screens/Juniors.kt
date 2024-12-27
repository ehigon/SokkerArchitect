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
import androidx.compose.ui.unit.sp
import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.core.domain.Country
import com.estivy.sokkerarchitect.core.domain.JuniorFormation
import com.estivy.sokkerarchitect.core.domain.JuniorStatus
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
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom
            )
            {
                Text(player.name + " " + player.surname)
                Row(
                    modifier = Modifier.fillMaxWidth().noRowPadding(evolution),
                    horizontalArrangement = Arrangement.End
                )
                {
                    if(evolution.currentWeek.formation == JuniorFormation.GOALKEEPER){
                        Image(
                            painter = painterResource(id = R.drawable.goalkeeper),
                            contentDescription = stringResource(id = R.string.goalkeeper),
                            Modifier
                                .padding(vertical = 2.dp, horizontal = 12.dp)
                                .size(20.dp)
                        )
                    }
                    Text(
                        fontSize = 12.sp,
                        text = stringResource(R.string.age) + " " + player.age
                    )
                    TextWithValue(stringResource(R.string.skill), evolution.currentWeek.skill)
                    TextWithValue(
                        stringResource(R.string.weeks),
                        evolution.currentWeek.remainingWeeks
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

fun Modifier.noRowPadding(evolution: JuniorEvolution): Modifier {
    if (evolution.getSkill() == 0) {
        return this then Modifier.padding(horizontal = 12.dp)
    }
    return this
}

@Composable
fun TextWithValue(name: String, value: Int) {
    Text(
        modifier = Modifier.padding(start = 8.dp),
        fontSize = 12.sp,
        text = name + if (value > 9) {
            ": "
        } else {
            ":   "
        } + value
    )
}

@Preview
@Composable
fun JuniorRowPreview() {
    val player: Player = Player.builder()
        .name("Esteban")
        .surname("Higon")
        .value(1345678986)
        .age(19)
        .height(183)
        .weight(80.5)
        .cards(1)
        .injuryDays(5)
        .country(
            Country.builder()
                .name("Spain")
                .countryId(34)
                .build()
        )
        .juniorStatuses(
            listOf(
                JuniorStatus.builder()
                    .week(123)
                    .skill(7)
                    .remainingWeeks(4)
                    .formation(JuniorFormation.FIELD_PLAYER)
                    .build(),
                JuniorStatus.builder()
                    .week(124)
                    .skill(8)
                    .remainingWeeks(3)
                    .formation(JuniorFormation.FIELD_PLAYER)
                    .build()
            )
        )
        .build()
    JuniorRow(player) { println(it) }
}
