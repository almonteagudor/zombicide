package com.montisgal.zombicide.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.montisgal.zombicide.R
import com.montisgal.zombicide.domain.campaign.Campaign
import com.montisgal.zombicide.domain.saved_game.SavedGame
import com.montisgal.zombicide.ui.screens.saved_game.saved_games_screen.SavedGamesViewModel.SavedGameUIModel

@Composable
fun SavedGameCardList(
    savedGames: List<SavedGameUIModel>,
    modifier: Modifier = Modifier,
    onItemClicked: (SavedGameUIModel) -> Unit,
    onItemLongClicked: (SavedGameUIModel) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_small)),
    ) {
        items(savedGames) { savedGame ->
            SavedGameCard(
                savedGameUIModel = savedGame,
                modifier = Modifier.fillMaxWidth(),
                onClick = { onItemClicked(savedGame) },
                onLongClick = { onItemLongClicked(savedGame) },
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SavedGameCard(
    savedGameUIModel: SavedGameUIModel,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    onLongClick: () -> Unit,
) {
    Card(
        modifier = modifier.combinedClickable(
            onClick = onClick,
            onLongClick = onLongClick
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (savedGameUIModel.isSelected)
                MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = savedGameUIModel.savedGame.name)
                Text(text = savedGameUIModel.savedGame.updatedAt)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = stringResource(id = savedGameUIModel.savedGame.campaign.product.title)
                            + ": " + stringResource(id = savedGameUIModel.savedGame.campaign.title)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SavedGameCardPreview() {
    SavedGameCard(
        savedGameUIModel = SavedGameUIModel(
            SavedGame(1, "SavedGame 1", Campaign.Hendrix, "14/01/1990")
        ),
        onClick = {},
        onLongClick = {},
    )
}