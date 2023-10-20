package com.montisgal.zombicide.ui.screens.saved_game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montisgal.zombicide.data.saved_game.SavedGame
import com.montisgal.zombicide.domain.saved_game.GetSavedGamesUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class SavedGamesViewModel(getSavedGamesUseCase: GetSavedGamesUseCase) : ViewModel() {
    private val _uiState = getSavedGamesUseCase().map { SavedGamesUiState(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = SavedGamesUiState()
        )
    val uiState = _uiState

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class SavedGamesUiState(
    val savedGames: List<SavedGame> = listOf()
)