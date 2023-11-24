package com.montisgal.zombicide.domain.saved_game.use_case

import com.montisgal.zombicide.domain.saved_game.SavedGame
import com.montisgal.zombicide.domain.saved_game.SavedGameRepository

class CreateSavedGameUseCase(private val savedGameRepository: SavedGameRepository) {
    suspend operator fun invoke(savedGame: SavedGame) {
        return savedGameRepository.insert(savedGame)
    }
}