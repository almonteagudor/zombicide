package com.montisgal.zombicide.data.player

import com.montisgal.zombicide.domain.player.Player

class PlayerMapper {
    fun fromEntityToDomain(entity: PlayerEntity): Player {
        return Player(id = entity.id, name = entity.name)
    }

    fun fromDomainToEntity(domainModel: Player): PlayerEntity {
        return PlayerEntity(id = domainModel.id, name = domainModel.name)
    }
}