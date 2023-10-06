package com.montisgal.zombicide.domain.player

import com.montisgal.zombicide.data.player.Player
import com.montisgal.zombicide.data.player.PlayerRepository

class CreatePlayerUseCase(private val playerRepository: PlayerRepository) {
    suspend operator fun invoke(player: Player){
        return playerRepository.insert(player )
    }
}