package com.montisgal.zombicide.ui.screens.saved_game.create_saved_game_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.montisgal.zombicide.R
import com.montisgal.zombicide.domain.campaign.Campaign
import com.montisgal.zombicide.ui.ZombicideViewModelProvider
import com.montisgal.zombicide.ui.components.ZombicideAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateSavedGameScreen(
    navController: NavController,
    onSavedGameCreated: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CreateSavedGameViewModel = viewModel(factory = ZombicideViewModelProvider.factory),
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            ZombicideAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(stringResource(id = R.string.route_create_saved_game))
                    }
                },
                navigateUp = { navController.navigateUp() },
                actions = {},
            )
        },
    ) {
        CreateSavedGameScreenContent(
            savedGameName = uiState.savedGameName,
            savedGameCampaign = uiState.savedGameCampaign,
            createSavedGame = { viewModel.createSavedGame(onSavedGameCreated) },
            onSavedGameNameChange = { savedGameName -> viewModel.onSavedGameNameChange(savedGameName) },
            onSavedGameCampaignChange = { savedGameCampaign ->
                viewModel.onSavedGameCampaignChange(
                    savedGameCampaign
                )
            },
            modifier = modifier.padding(paddingValues = it)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateSavedGameScreenContent(
    savedGameName: String,
    savedGameCampaign: Campaign,
    createSavedGame: () -> Unit,
    onSavedGameNameChange: (savedGameName: String) -> Unit,
    onSavedGameCampaignChange: (savedGameCampaign: Campaign) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_small)),
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = savedGameName,
            label = {
                Text(text = stringResource(id = R.string.label_saved_game_name))
            },
            onValueChange = { onSavedGameNameChange(it) },
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

        ZombicideCampaignSelection(
            modifier = Modifier.fillMaxWidth(),
            campaignSelected = savedGameCampaign,
            onCampaingSelectedChange = { campaign: Campaign -> onSavedGameCampaignChange(campaign) },
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

        Button(onClick = { createSavedGame() }) {
            Text(text = stringResource(id = R.string.button_save))
        }
    }
}

@Composable
fun ZombicideCampaignSelection(
    campaignSelected: Campaign,
    onCampaingSelectedChange: (campaign: Campaign) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = campaignSelected == Campaign.Washington,
                onClick = { onCampaingSelectedChange(Campaign.Washington) },
            )
            Text(text = stringResource(id = Campaign.Washington.title))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = campaignSelected == Campaign.Hendrix,
                onClick = { onCampaingSelectedChange(Campaign.Hendrix) },
            )
            Text(text = stringResource(id = Campaign.Hendrix.title))
        }
    }
}