package com.montisgal.zombicide.domain.saved_game

import com.montisgal.zombicide.data.player_saved_game.SavedGameWithPlayers
import com.montisgal.zombicide.data.saved_game.SavedGameRepository
import kotlinx.coroutines.flow.Flow

class GetSavedGamesWithPlayersUseCase(private val savedGameRepository: SavedGameRepository) {
    operator fun invoke(): Flow<List<SavedGameWithPlayers>> {
        return savedGameRepository.getAllWithPlayers()
    }
}