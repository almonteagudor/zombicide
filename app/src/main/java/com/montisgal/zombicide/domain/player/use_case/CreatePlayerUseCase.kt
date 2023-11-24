package com.montisgal.zombicide.domain.player.use_case

import com.montisgal.zombicide.domain.player.Player
import com.montisgal.zombicide.domain.player.PlayerRepository

class CreatePlayerUseCase(private val playerRepository: PlayerRepository) {
    suspend operator fun invoke(player: Player) {
        return playerRepository.insert(player)
    }
}