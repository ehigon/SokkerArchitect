package com.estivy.sokkerarchitect.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.core.service.UpdateService
import com.estivy.sokkerarchitect.security.service.PasswordStorageService
import com.estivy.sokkerarchitect.ui.screens.Login
import com.estivy.sokkerarchitect.ui.screens.Player
import com.estivy.sokkerarchitect.ui.screens.Players
import com.estivy.sokkerarchitect.ui.screens.PlayersViewModel


enum class SokkerArchitectScreen(val route: String, @StringRes val title: Int) {
    login(route = "login", title = R.string.login_sc),
    players(route = "players", title = R.string.players_sc),
    player(route = "player/{id}", title = R.string.player_sc);

    companion object {
        fun fromRoute(route: String): SokkerArchitectScreen {
            entries.filter { it.route == route }.forEach { return it }
            return players;
        }
    }
}


@Composable
fun SokkerArchitectApp(
    updateService: UpdateService,
    playersViewModel: PlayersViewModel,
    passwordStorageService: PasswordStorageService
) {
    val firstScreen =
        if (passwordStorageService.isStarted()) SokkerArchitectScreen.players.route else SokkerArchitectScreen.login.route
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen =
        SokkerArchitectScreen.fromRoute(backStackEntry?.destination?.route ?: firstScreen)
    Scaffold(
        topBar = {
            SokkerArchitectAppBar(
                currentScreen = currentScreen,
                canNavigateBack = canNavigateBack(navController),
                navigateUp = { navController.navigateUp() },
                updateService = updateService
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = firstScreen,
            modifier = Modifier
                .padding(innerPadding)
        ) {
            composable(route = SokkerArchitectScreen.login.route) {
                Login(updateService) {
                    navController.navigate(it)
                }
            }
            composable(route = SokkerArchitectScreen.players.route) {
                Players(playersViewModel) {
                    navController.navigate(it)
                }
                playersViewModel.retrievePlayers()
            }
            composable(
                route = SokkerArchitectScreen.player.route,
                arguments = listOf(navArgument("id") { type = NavType.StringType })
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")
                Player(playersViewModel, id)
            }
        }
    }

}

@Composable
private fun canNavigateBack(navController: NavHostController) =
    (navController.previousBackStackEntry != null
            && navController.previousBackStackEntry?.destination?.route
            != SokkerArchitectScreen.login.route)
