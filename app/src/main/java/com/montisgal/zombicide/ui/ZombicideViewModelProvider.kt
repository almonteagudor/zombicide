package com.montisgal.zombicide.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.montisgal.zombicide.ZombicideApplication
import com.montisgal.zombicide.domain.player.use_case.GetPlayersUseCase
import com.montisgal.zombicide.domain.saved_game.use_case.CreateSavedGameUseCase
import com.montisgal.zombicide.domain.saved_game.use_case.DeleteSavedGamesUseCase
import com.montisgal.zombicide.domain.saved_game.use_case.GetSavedGamesUseCase
import com.montisgal.zombicide.ui.screens.player.PlayersViewModel
import com.montisgal.zombicide.ui.screens.saved_game.create_saved_game_screen.CreateSavedGameViewModel
import com.montisgal.zombicide.ui.screens.saved_game.saved_games_screen.SavedGamesViewModel

object ZombicideViewModelProvider {
    val factory = viewModelFactory {
        initializer {
            SavedGamesViewModel(
                GetSavedGamesUseCase(zombicideApplication().container.savedGameRepository),
                DeleteSavedGamesUseCase(zombicideApplication().container.savedGameRepository),
            )
        }
        initializer {
            CreateSavedGameViewModel(CreateSavedGameUseCase(zombicideApplication().container.savedGameRepository))
        }
        initializer {
            PlayersViewModel(GetPlayersUseCase(zombicideApplication().container.playerRepository))
        }
    }
}

fun CreationExtras.zombicideApplication(): ZombicideApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as ZombicideApplication)