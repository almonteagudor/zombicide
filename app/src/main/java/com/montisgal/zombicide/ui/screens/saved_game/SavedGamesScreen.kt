package com.montisgal.zombicide.ui.screens.saved_game

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.montisgal.zombicide.R
import com.montisgal.zombicide.data.campaign.Campaign
import com.montisgal.zombicide.data.saved_game.SavedGame
import com.montisgal.zombicide.ui.ZombicideViewModelProvider

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedGamesScreen(
    modifier: Modifier = Modifier,
    viewModel: SavedGamesViewModel = viewModel(factory = ZombicideViewModelProvider.factory),
    onCreateClicked: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        floatingActionButton = {
            ZombicideFab(onClick = { onCreateClicked() })
        },
        modifier = modifier,
    ) {
        if (uiState.savedGames.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = stringResource(R.string.label_no_saved_games_description),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        } else {
            SavedGameCardList(
                savedGames = uiState.savedGames,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}

@Composable
fun ZombicideFab(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Icon(Icons.Filled.Add, "New Saved Game.")
    }
}

@Composable
fun SavedGameCardList(savedGames: List<SavedGame>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_small)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
    ) {
        items(savedGames) { savedGame ->
            SavedGameCard(
                savedGame = savedGame,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun SavedGameCard(savedGame: SavedGame, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = savedGame.name)
                Text(text = savedGame.updatedAt)
            }
            Text(text = stringResource(id = savedGame.campaign.title))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CampaignsScreenPreview() {
    SavedGameCardList(
        listOf(
            SavedGame(
                name = "Exampla campaign 1",
                campaign = Campaign.Washington,
                updatedAt = "14/01/1990"
            ),
            SavedGame(
                name = "Exampla campaign 2",
                campaign = Campaign.Hendrix,
                updatedAt = "14/01/1990"
            ),
            SavedGame(
                name = "Exampla campaign 3",
                campaign = Campaign.Washington,
                updatedAt = "14/01/1990"
            ),
            SavedGame(
                name = "Exampla campaign 4",
                campaign = Campaign.Hendrix,
                updatedAt = "14/01/1990"
            ),
        )
    )
}