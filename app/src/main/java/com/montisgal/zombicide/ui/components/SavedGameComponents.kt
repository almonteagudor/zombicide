package com.montisgal.zombicide.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.montisgal.zombicide.R
import com.montisgal.zombicide.data.saved_game.SavedGame

@Composable
fun SavedGameCardList(savedGames: List<SavedGame>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
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
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = stringResource(id = savedGame.campaign.product.title)
                            + ": " + stringResource(id = savedGame.campaign.title)
                )
            }
        }
    }
}