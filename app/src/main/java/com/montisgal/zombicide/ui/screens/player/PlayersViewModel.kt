package com.montisgal.zombicide.ui.screens.player

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montisgal.zombicide.domain.player.Player
import com.montisgal.zombicide.domain.player.use_case.GetPlayersUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class PlayersViewModel (getPlayersUseCase: GetPlayersUseCase):ViewModel() {
    private val _uiState = getPlayersUseCase().map { PlayersUiState(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = PlayersUiState()
        )
    val uiState = _uiState

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}
data class PlayersUiState(
    val players: List<Player> = listOf()
)