package com.montisgal.zombicide.domain.saved_game.use_case

import com.montisgal.zombicide.domain.saved_game.SavedGame
import com.montisgal.zombicide.domain.saved_game.SavedGameRepository

class DeleteSavedGamesUseCase(private val savedGameRepository: SavedGameRepository) {
    suspend operator fun invoke(savedGames: List<SavedGame>) {
        savedGames.forEach {
            savedGameRepository.delete(it)
        }
    }
}