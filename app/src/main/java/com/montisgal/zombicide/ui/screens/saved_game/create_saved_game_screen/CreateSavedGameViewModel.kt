package com.montisgal.zombicide.ui.screens.saved_game.create_saved_game_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montisgal.zombicide.domain.campaign.Campaign
import com.montisgal.zombicide.domain.saved_game.SavedGame
import com.montisgal.zombicide.domain.saved_game.use_case.CreateSavedGameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.util.GregorianCalendar

class CreateSavedGameViewModel(
    private val createSavedGameUseCase: CreateSavedGameUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(CreateSavedGameUiState())
    val uiState = _uiState.asStateFlow()

    fun onSavedGameNameChange(savedGameName: String) {
        _uiState.update { it.copy(savedGameName = savedGameName) }
    }

    fun onSavedGameCampaignChange(savedGameCampaign: Campaign) {
        _uiState.update { it.copy(savedGameCampaign = savedGameCampaign) }
    }

    fun createSavedGame(onSavedGameCreated: () -> Unit = {}) {
        viewModelScope.launch {
            createSavedGameUseCase(
                SavedGame(
                    name = _uiState.value.savedGameName,
                    campaign = _uiState.value.savedGameCampaign,
                    updatedAt = DateFormat.getDateInstance().format(GregorianCalendar().time)
                ),
            )

            onSavedGameCreated()
        }
    }

    data class CreateSavedGameUiState(
        val savedGameName: String = "",
        val savedGameCampaign: Campaign = Campaign.Washington,
    )
}