package com.montisgal.zombicide.ui.screens.saved_game

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.montisgal.zombicide.R
import com.montisgal.zombicide.data.campaign.Campaign
import com.montisgal.zombicide.domain.saved_game.SavedGame
import com.montisgal.zombicide.ui.ZombicideViewModelProvider
import com.montisgal.zombicide.ui.components.SavedGameCardList
import com.montisgal.zombicide.ui.components.ZombicideAddFab
import com.montisgal.zombicide.ui.components.ZombicideAppBar
import com.montisgal.zombicide.ui.screens.saved_game.SavedGamesViewModel.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedGamesScreen(
    navController: NavController,
    onCreateClicked: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SavedGamesViewModel = viewModel(factory = ZombicideViewModelProvider.factory),
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            ZombicideAppBar(
                title = stringResource(id = R.string.route_saved_games),
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                onTrashClicked = { viewModel.deleteSelectedGames() },
                itemsSelected = uiState.savedGames.count { it.isSelected },
                onItemsSelectedCancel = { viewModel.clearSelectedSavedGames() },
            )
        },
        floatingActionButton = {
            ZombicideAddFab(
                onClick = { onCreateClicked() },
                contentDescription = stringResource(id = R.string.label_new_saved_game)
            )
        },
    ) { paddingValues ->
        SavedGamesScreenContent(
            savedGames = uiState.savedGames,
            modifier = modifier.padding(paddingValues = paddingValues),
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