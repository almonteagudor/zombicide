package com.montisgal.zombicide.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.montisgal.zombicide.R
import com.montisgal.zombicide.ui.screens.player.PlayersScreen
import com.montisgal.zombicide.ui.screens.saved_game.SavedGamesScreen
import com.montisgal.zombicide.ui.screens.saved_game.CreateSavedGameScreen

enum class ZombicideRoute(@StringRes val title: Int) {
    SavedGames(title = R.string.route_saved_games),
    CreateSavedGame(title = R.string.route_create_saved_game),
    Players(title = R.string.route_players)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZombicideApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = ZombicideRoute.valueOf(
        backStackEntry?.destination?.route ?: ZombicideRoute.SavedGames.name
    )

    Scaffold(
        topBar = {
            ZombicideAppBar(
                currentRoute = currentRoute,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            navController = navController,
            startDestination = ZombicideRoute.Players.name,
        ) {
            composable(route = ZombicideRoute.SavedGames.name) {
                SavedGamesScreen(
                    onCreateClicked = { navController.navigate(ZombicideRoute.CreateSavedGame.name) },
                    modifier = Modifier.fillMaxSize(),
                )
            }
            composable(route = ZombicideRoute.CreateSavedGame.name) {
                CreateSavedGameScreen(
                    modifier = Modifier.fillMaxSize(),
                    onSavedGameCreated = {navController.navigate(ZombicideRoute.SavedGames.name)}
                )
            }
            composable(route = ZombicideRoute.Players.name) {
                PlayersScreen(
                    onCreateClicked = { /*navController.navigate(ZombicideRoute.CreateSavedGame.name) */},
                    modifier = Modifier.fillMaxSize(),
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZombicideAppBar(
    canNavigateBack: Boolean,
    currentRoute: ZombicideRoute,
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit,
) {
    TopAppBar(
        title = { Text(stringResource(currentRoute.title)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.button_back)
                    )
                }
            }
        },
    )
}

@Preview
@Composable
fun ZombicideAppPreview() {
    ZombicideApp()
}