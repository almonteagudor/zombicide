package com.montisgal.zombicide.ui.screens.saved_game

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
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
import com.montisgal.zombicide.R
import com.montisgal.zombicide.data.campaign.Campaign
import com.montisgal.zombicide.ui.ZombicideViewModelProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateSavedGameScreen(
    modifier: Modifier = Modifier,
    viewModel: CreateSavedGameViewModel = viewModel(factory = ZombicideViewModelProvider.factory),
    onSavedGameCreated: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_small)),
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = uiState.name,
            label = {
                Text(text = stringResource(id = R.string.label_saved_game_name))
            },
            onValueChange = { viewModel.onNameChange(it) },
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

        ZombicideCampaignSelection(
            modifier = Modifier.fillMaxWidth(),
            campaignSelected = uiState.campaign,
            onCampaingChange = { campaign: Campaign -> viewModel.onCampaignChange(campaign) },
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

        Button(onClick = { viewModel.createCampaign(onSavedGameCreated = onSavedGameCreated) }) {
            Text(text = stringResource(id = R.string.button_save))
        }
    }
}

@Composable
fun ZombicideCampaignSelection(
    campaignSelected: Campaign,
    modifier: Modifier = Modifier,
    onCampaingChange: (campaign: Campaign) -> Unit,
) {
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = campaignSelected == Campaign.Washington,
                onClick = { onCampaingChange(Campaign.Washington) },
            )
            Text(text = stringResource(id = Campaign.Washington.title))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = campaignSelected == Campaign.Hendrix,
                onClick = { onCampaingChange(Campaign.Hendrix) },
            )
            Text(text = stringResource(id = Campaign.Hendrix.title))
        }
    }
}