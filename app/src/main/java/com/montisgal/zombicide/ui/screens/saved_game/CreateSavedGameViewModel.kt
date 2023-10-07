package com.montisgal.zombicide.ui.screens.saved_game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montisgal.zombicide.data.campaign.Campaign
import com.montisgal.zombicide.data.saved_game.SavedGame
import com.montisgal.zombicide.domain.saved_game.CreateSavedGameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.util.GregorianCalendar

class CreateSavedGameViewModel(private val createSavedGameUseCase: CreateSavedGameUseCase) :
    ViewModel() {
    private val _uiState = MutableStateFlow(CreateSavedGameUiState())
    val uiState = _uiState.asStateFlow()

    fun onNameChange(name: String) {
        _uiState.update { currentUiState ->
            currentUiState.copy(name = name)
        }
    }

    fun onCampaignChange(campaign: Campaign) {
        _uiState.update { currentUiState ->
            currentUiState.copy(campaign = campaign)
        }
    }

    fun createCampaign(onSavedGameCreated: () -> Unit) {
        viewModelScope.launch {
            createSavedGameUseCase(
                SavedGame(
                    name = _uiState.value.name,
                    campaign = _uiState.value.campaign,
                    updatedAt = DateFormat.getDateInstance().format(GregorianCalendar().time)),
                )
            onSavedGameCreated()
        }
    }
}

data class CreateSavedGameUiState(
    val name: String = "",
    val campaign: Campaign = Campaign.Washington,
)