package com.estivy.sokkerarchitect.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.core.service.PlayersService
import com.estivy.sokkerarchitect.core.service.UpdateService
import com.estivy.sokkerarchitect.security.service.PasswordStorageService
import com.estivy.sokkerarchitect.ui.screens.ImportExport
import com.estivy.sokkerarchitect.ui.screens.Junior
import com.estivy.sokkerarchitect.ui.screens.Juniors
import com.estivy.sokkerarchitect.ui.screens.Login
import com.estivy.sokkerarchitect.ui.screens.Notes
import com.estivy.sokkerarchitect.ui.screens.Player
import com.estivy.sokkerarchitect.ui.screens.Players
import com.estivy.sokkerarchitect.ui.screens.SkillProgress
import com.estivy.sokkerarchitect.ui.screens.Updating
import com.estivy.sokkerarchitect.ui.screens.model.PlayersViewModel
import com.estivy.sokkerarchitect.ui.screens.model.Skill
import com.estivy.sokkerarchitect.ui.util.searchJunior
import com.estivy.sokkerarchitect.ui.util.searchPlayer
import kotlinx.coroutines.launch


enum class SokkerArchitectScreen(val route: String, @StringRes val title: Int) {
    LOGIN(route = "login", title = R.string.login_sc),
    PLAYERS(route = "players", title = R.string.players_sc),
    PLAYER(route = "player/{id}", title = R.string.player_sc),
    PLAYER_JUNIOR(route = "player/{id}/junior", title = R.string.player_sc),
    JUNIORS(route = "juniors", title = R.string.juniors_sc),
    SKILL_PROGRESS(route = "player/{id}/skill/{skill}", title = R.string.skill_progress_sc),
    UPDATING(route = "updating", title = R.string.updating_sc),
    JUNIOR(route = "junior/{id}", title = R.string.junior_sc),
    IMPORT_EXPORT(route = "import_export", title = R.string.import_export_sc),
    NOTES(route = "player/{id}/notes", title = R.string.notes_sc);

    companion object {
        fun fromRoute(route: String): SokkerArchitectScreen {
            entries.filter { it.route == route }.forEach { return it }
            return PLAYERS
        }
    }
}


@Composable
fun SokkerArchitectApp(
    updateService: UpdateService,
    playersService: PlayersService,
    playersViewModel: PlayersViewModel,
    passwordStorageService: PasswordStorageService
) {
    val firstScreen =
        if (passwordStorageService.isStarted()) SokkerArchitectScreen.PLAYERS.route else SokkerArchitectScreen.LOGIN.route
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen =
        SokkerArchitectScreen.fromRoute(backStackEntry?.destination?.route ?: firstScreen)
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(Modifier.height(12.dp))
                    NavigationDrawerItem(
                        label = { Text(stringResource(R.string.players)) },
                        selected = false,
                        onClick = {
                            navController.navigate(SokkerArchitectScreen.PLAYERS.route)
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    )
                    NavigationDrawerItem(
                        label = { Text(stringResource(R.string.juniors)) },
                        selected = false,
                        onClick = {
                            navController.navigate(SokkerArchitectScreen.JUNIORS.route)
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    )
                    NavigationDrawerItem(
                        label = { Text(stringResource(R.string.import_export_sc)) },
                        selected = false,
                        onClick = {
                            navController.navigate(SokkerArchitectScreen.IMPORT_EXPORT.route)
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    )
                    Spacer(Modifier.height(12.dp))
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                SokkerArchitectAppBar(
                    currentScreen = currentScreen,
                    shouldShowMenu = shouldShowMenu(currentScreen, navController),
                    updateService = updateService,
                    navigateTo = { route: String -> navController.navigate(route) },
                    onNavigationIconClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    },
                    playersViewModel = playersViewModel
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = firstScreen,
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                composable(route = SokkerArchitectScreen.LOGIN.route) {
                    Login(updateService) {
                        navController.navigate(it)
                    }
                }
                composable(route = SokkerArchitectScreen.PLAYERS.route) {
                    Players(playersViewModel) {
                        navController.navigate(it)
                    }
                    playersViewModel.retrievePlayers()
                }
                composable(
                    route = SokkerArchitectScreen.SKILL_PROGRESS.route,
                    arguments = listOf(navArgument("id") { type = NavType.StringType },
                        navArgument("skill") { type = NavType.StringType })
                ) { backStackEntry ->
                    val id = backStackEntry.arguments?.getString("id")
                    val skill = backStackEntry.arguments?.getString("skill")
                    searchPlayer(playersViewModel, id)?.let {
                        if (skill != null) {
                            SkillProgress(it, Skill.valueOf(skill))
                        }
                    }
                }
                composable(
                    route = SokkerArchitectScreen.PLAYER.route,
                    arguments = listOf(navArgument("id") { type = NavType.StringType })
                ) { backStackEntry ->
                    val id = backStackEntry.arguments?.getString("id")
                    searchPlayer(playersViewModel, id)?.let { player ->
                        Player(player.player) {
                            navController.navigate(it)
                        }
                    }
                }
                composable(
                    route = SokkerArchitectScreen.PLAYER_JUNIOR.route,
                    arguments = listOf(navArgument("id") { type = NavType.StringType })
                ) { backStackEntry ->
                    val id = backStackEntry.arguments?.getString("id")
                    searchPlayer(playersViewModel, id)?.let { player ->
                        Junior(player)
                    }
                }
                composable(route = SokkerArchitectScreen.JUNIORS.route) {
                    Juniors(playersViewModel) {
                        navController.navigate(it)
                    }
                    playersViewModel.retrieveJuniors()
                }
                composable(
                    route = SokkerArchitectScreen.JUNIOR.route,
                    arguments = listOf(navArgument("id") { type = NavType.StringType })
                ) { backStackEntry ->
                    val id = backStackEntry.arguments?.getString("id")
                    searchJunior(playersViewModel, id)?.let { player ->
                        Junior(player)
                    }
                }
                composable(route = SokkerArchitectScreen.UPDATING.route) {
                    Updating()
                }
                composable(route = SokkerArchitectScreen.IMPORT_EXPORT.route) {
                    ImportExport(playersService, playersViewModel)
                }
                composable(
                    route = SokkerArchitectScreen.NOTES.route,
                    arguments = listOf(navArgument("id") { type = NavType.StringType })
                ) { backStackEntry ->
                    val id = backStackEntry.arguments?.getString("id")
                    searchPlayer(playersViewModel, id)?.let { player ->
                        Notes(
                            player = player.player,
                            saveNotes = { id, notes -> playersService.saveNotes(id, notes) },
                            navigateUp = { navController.navigateUp() }
                        )
                    }
                }
            }
        }
    }

}

@Composable
private fun shouldShowMenu(
    currentScreen: SokkerArchitectScreen,
    navController: NavHostController
): Boolean {
    return currentScreen != SokkerArchitectScreen.LOGIN || navController.previousBackStackEntry != null
}

