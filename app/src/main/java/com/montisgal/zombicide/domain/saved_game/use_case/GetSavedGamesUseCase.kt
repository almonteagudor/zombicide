package com.montisgal.zombicide.domain.saved_game.use_case

import com.montisgal.zombicide.domain.saved_game.SavedGame
import com.montisgal.zombicide.domain.saved_game.SavedGameRepository
import kotlinx.coroutines.flow.Flow

class GetSavedGamesUseCase(private val savedGameRepository: SavedGameRepository) {
    operator fun invoke(): Flow<List<SavedGame>> {
        return savedGameRepository.getAll()
    }
}