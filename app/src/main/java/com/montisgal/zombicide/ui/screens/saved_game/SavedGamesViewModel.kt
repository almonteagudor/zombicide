package com.montisgal.zombicide.ui.screens.saved_game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montisgal.zombicide.domain.saved_game.DeleteSavedGamesUseCase
import com.montisgal.zombicide.domain.saved_game.SavedGame
import com.montisgal.zombicide.domain.saved_game.GetSavedGamesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SavedGamesViewModel(
    private val getSavedGamesUseCase: GetSavedGamesUseCase,
    private val deleteSavedGamesUseCase: DeleteSavedGamesUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(SavedGamesUiState())
    val uiState: StateFlow<SavedGamesUiState> = _uiState

    init {
        loadSavedGames()
    }

    private fun loadSavedGames() {
        viewModelScope.launch {
            try {
                getSavedGamesUseCase().map {
                    it.map { savedGame ->
                        SavedGameUIModel(savedGame)
                    }
                }.collect { savedGamesUIModel ->
                    _uiState.update { it.copy(savedGames = savedGamesUIModel) }
                }
            } catch (e: Exception) {
                // Handle error state
            }
        }
    }

    fun toggleGameSelection(savedGameUIModel: SavedGameUIModel) {
        _uiState.update { currentState ->
            currentState.copy(savedGames = currentState.savedGames.map {
                if (it.savedGame.id == savedGameUIModel.savedGame.id) {
                    it.copy(isSelected = !it.isSelected)
                } else it
            })
        }
    }

    fun clearSelectedSavedGames() {
        _uiState.update { currentState ->
            currentState.copy(savedGames = currentState.savedGames.map { it.copy(isSelected = false) })
        }
    }

    fun deleteSelectedGames() {
        viewModelScope.launch {
            deleteSavedGamesUseCase(
                _uiState.value.savedGames.filter {
                    it.isSelected
                }.map {
                    it.savedGame
                }
            )
        }
    }

    data class SavedGamesUiState(
        val savedGames: List<SavedGameUIModel> = listOf(),
    )

    data class SavedGameUIModel(
        val savedGame: SavedGame,
        var isSelected: Boolean = false
    )
}