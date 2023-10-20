package com.montisgal.zombicide.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.montisgal.zombicide.ui.screens.player.PlayersScreen
import com.montisgal.zombicide.ui.screens.saved_game.CreateSavedGameScreen
import com.montisgal.zombicide.ui.screens.saved_game.SavedGamesScreen

enum class ZombicideRoute() {
    SavedGames(),
    CreateSavedGame(),
    Players()
}

@Preview
@Composable
fun NavManager(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = ZombicideRoute.SavedGames.name,
    ) {
        composable(route = ZombicideRoute.SavedGames.name) {
            SavedGamesScreen(
                navController = navController,
                onCreateClicked = { navController.navigate(ZombicideRoute.CreateSavedGame.name) },
                modifier = Modifier.fillMaxSize(),
            )
        }
        composable(route = ZombicideRoute.CreateSavedGame.name) {
            CreateSavedGameScreen(
                modifier = Modifier.fillMaxSize(),
                onSavedGameCreated = { navController.navigate(ZombicideRoute.SavedGames.name) }
            )
        }
        composable(route = ZombicideRoute.Players.name) {
            PlayersScreen(
                onCreateClicked = { /*navController.navigate(ZombicideRoute.CreateSavedGame.name) */ },
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}