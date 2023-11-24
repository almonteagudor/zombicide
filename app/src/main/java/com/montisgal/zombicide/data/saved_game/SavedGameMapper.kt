package com.montisgal.zombicide.data.saved_game

import com.montisgal.zombicide.domain.campaign.Campaign
import com.montisgal.zombicide.domain.saved_game.SavedGame

class SavedGameMapper {
    fun fromEntityToDomain(entity: SavedGameEntity): SavedGame {
        return SavedGame(
            id = entity.id,
            name = entity.name,
            campaign = Campaign.fromId(entity.campaignId)!!,
            updatedAt = entity.updatedAt,
        )
    }

    fun fromDomainToEntity(domainModel: SavedGame): SavedGameEntity {
        return SavedGameEntity(
            id = domainModel.id,
            name = domainModel.name,
            campaignId = domainModel.campaign.id,
            updatedAt = domainModel.updatedAt,
        )
    }
}