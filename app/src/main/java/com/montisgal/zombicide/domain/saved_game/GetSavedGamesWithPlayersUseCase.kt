package com.montisgal.zombicide.domain.saved_game

import com.montisgal.zombicide.data.saved_game.SavedGameRepository
import com.montisgal.zombicide.data.saved_game.SavedGameWithPlayers
import kotlinx.coroutines.flow.Flow

class GetSavedGamesWithPlayersUseCase(private val savedGameRepository: SavedGameRepository) {
    operator fun invoke(): Flow<List<SavedGameWithPlayers>> {
        return savedGameRepository.getAllWithPlayers()
    }
}