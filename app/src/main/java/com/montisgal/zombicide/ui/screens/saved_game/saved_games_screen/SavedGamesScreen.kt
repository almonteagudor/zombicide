package com.montisgal.zombicide.ui.screens.saved_game.saved_games_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.montisgal.zombicide.domain.campaign.Campaign
import com.montisgal.zombicide.domain.saved_game.SavedGame
import com.montisgal.zombicide.ui.ZombicideViewModelProvider
import com.montisgal.zombicide.ui.components.SavedGameCardList
import com.montisgal.zombicide.ui.components.ZombicideAddFab
import com.montisgal.zombicide.ui.components.ZombicideAppBar
import com.montisgal.zombicide.ui.screens.saved_game.saved_games_screen.SavedGamesViewModel.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedGamesScreen(
    modifier: Modifier = Modifier,
    onCreateClicked: () -> Unit = {},
    viewModel: SavedGamesViewModel = viewModel(factory = ZombicideViewModelProvider.factory),
) {
    val uiState by viewModel.uiState.collectAsState()
    val itemsSelected = uiState.savedGames.count { it.isSelected }

    Scaffold(
        topBar = {
            ZombicideAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        if (itemsSelected > 0) {
                            IconButton(onClick = { viewModel.clearSelectedSavedGames() }) {
                                Icon(
                                    imageVector = Icons.Filled.Close,
                                    contentDescription = stringResource(R.string.button_back),
                                )
                            }
                            Text(itemsSelected.toString())
                            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
                        } else {
                            Text(stringResource(id = R.string.route_saved_games))
                        }
                    }
                },
                actions = {
                    if (itemsSelected > 0) {
                        IconButton(onClick = { viewModel.deleteSelectedGames() }) {
                            Icon(
                                imageVector = Icons.Filled.Delete,
                                contentDescription = stringResource(R.string.button_back)
                            )
                        }
                    }
                },
            )
        },
        floatingActionButton = {
            ZombicideAddFab(
                onClick = { onCreateClicked() },
                contentDescription = stringResource(id = R.string.label_new_saved_game)
            )
        },
    ) {
        SavedGamesScreenContent(
            savedGames = uiState.savedGames,
            modifier = modifier.padding(paddingValues = it),
            onItemClicked = {},
            onItemLongClicked = {
                viewModel.toggleGameSelection(it)
            },
        )
    }
}

@Composable
fun SavedGamesScreenContent(
    savedGames: List<SavedGameUIModel>,
    modifier: Modifier = Modifier,
    onItemClicked: (SavedGameUIModel) -> Unit,
    onItemLongClicked: (SavedGameUIModel) -> Unit,
) {
    if (savedGames.isEmpty()) {
        Box(modifier = modifier, contentAlignment = Alignment.Center) {
            Text(
                text = stringResource(R.string.label_no_saved_games_description),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
            )
        }
    } else {
        Box(modifier = modifier) {
            SavedGameCardList(
                savedGames = savedGames,
                modifier = Modifier.fillMaxWidth(),
                onItemClicked = onItemClicked,
                onItemLongClicked = onItemLongClicked,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SavedGamesScreenContentPreview() {
    SavedGamesScreenContent(
        savedGames = listOf(
            SavedGameUIModel(SavedGame(1, "SavedGame 1", Campaign.Hendrix, "14/01/1990")),
            SavedGameUIModel(SavedGame(2, "SavedGame 2", Campaign.Hendrix, "14/01/1990")),
            SavedGameUIModel(SavedGame(3, "SavedGame 3", Campaign.Hendrix, "14/01/1990")),
            SavedGameUIModel(SavedGame(4, "SavedGame 4", Campaign.Hendrix, "14/01/1990")),
            SavedGameUIModel(SavedGame(5, "SavedGame 5", Campaign.Hendrix, "14/01/1990")),
        ),
        onItemClicked = {},
        onItemLongClicked = {},
    )
}