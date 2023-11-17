package com.montisgal.zombicide.domain.saved_game

import com.montisgal.zombicide.data.saved_game.SavedGameRepository

class DeleteSavedGamesUseCase(private val savedGameRepository: SavedGameRepository) {
    suspend operator fun invoke(savedGames: List<SavedGame>) {
        savedGames.forEach {
            savedGameRepository.delete(it)
        }
    }
}