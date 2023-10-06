package com.montisgal.zombicide.domain.saved_game

import com.montisgal.zombicide.data.saved_game.SavedGame
import com.montisgal.zombicide.data.saved_game.SavedGameRepository

class CreateSavedGameUseCase(private val savedGameRepository: SavedGameRepository) {
    suspend operator fun invoke(savedGame: SavedGame){
        return savedGameRepository.insert(savedGame)
    }
}