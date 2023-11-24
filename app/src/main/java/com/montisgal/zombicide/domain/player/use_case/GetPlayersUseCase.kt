package com.montisgal.zombicide.domain.player.use_case

import com.montisgal.zombicide.domain.player.Player
import com.montisgal.zombicide.domain.player.PlayerRepository
import kotlinx.coroutines.flow.Flow

class GetPlayersUseCase(private val playerRepository: PlayerRepository) {
    operator fun invoke(): Flow<List<Player>> {
        return playerRepository.getAll()
    }
}