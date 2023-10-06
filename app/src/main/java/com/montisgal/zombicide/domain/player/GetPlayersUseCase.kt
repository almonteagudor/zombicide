package com.montisgal.zombicide.domain.player

import com.montisgal.zombicide.data.player.Player
import com.montisgal.zombicide.data.player.PlayerRepository
import kotlinx.coroutines.flow.Flow

class GetPlayersUseCase (private  val playerRepository: PlayerRepository){
    operator fun invoke(): Flow<List<Player>> {
        return playerRepository.getAll()
    }
}