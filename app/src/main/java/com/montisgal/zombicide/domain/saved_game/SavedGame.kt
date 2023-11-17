package com.montisgal.zombicide.domain.saved_game

import com.montisgal.zombicide.data.campaign.Campaign

data class SavedGame(
    val id: Int = 0,
    val name: String,
    val campaign: Campaign,
    val updatedAt: String
)