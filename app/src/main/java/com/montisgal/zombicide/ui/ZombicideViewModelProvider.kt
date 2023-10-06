package com.montisgal.zombicide.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.montisgal.zombicide.ZombicideApplication
import com.montisgal.zombicide.domain.saved_game.CreateSavedGameUseCase
import com.montisgal.zombicide.domain.saved_game.GetSavedGamesUseCase
import com.montisgal.zombicide.ui.screens.saved_game.SavedGamesViewModel
import com.montisgal.zombicide.ui.screens.saved_game.CreateSavedGameViewModel

object ZombicideViewModelProvider {
    val factory = viewModelFactory {
        initializer {
            SavedGamesViewModel(GetSavedGamesUseCase(zombicideApplication().container.savedGameRepository))
        }
        initializer {
            CreateSavedGameViewModel(CreateSavedGameUseCase(zombicideApplication().container.savedGameRepository))
        }
    }
}

fun CreationExtras.zombicideApplication(): ZombicideApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as ZombicideApplication)