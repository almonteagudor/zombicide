package com.montisgal.zombicide.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.montisgal.zombicide.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZombicideAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    itemsSelected: Int = 0,
    onItemsSelectedCancel: () -> Unit,
    navigateUp: () -> Unit,
    onTrashClicked: () -> Unit,
) {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (itemsSelected > 0) {
                    IconButton(onClick = onItemsSelectedCancel) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = stringResource(R.string.button_back),
                        )
                    }
                    Text(itemsSelected.toString())
                    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
                } else {
                    Text(title)
                }
            }
        },
        modifier = modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            navigationIconContentColor = Color.White,
            titleContentColor = Color.White,
            actionIconContentColor = Color.White,
        ),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.button_back)
                    )
                }
            }
        },
        actions = {
            if (itemsSelected > 0) {
                IconButton(onClick = onTrashClicked) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = stringResource(R.string.button_back)
                    )
                }
            }
        }
    )
}

@Composable
fun ZombicideAddFab(onClick: () -> Unit, contentDescription: String) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = Color.White,
    ) {
        Icon(Icons.Filled.Add, contentDescription)
    }
}

@Preview(showBackground = true)
@Composable
fun ZombicideAppBarPreview() {
    ZombicideAppBar(
        title = stringResource(id = R.string.app_name),
        canNavigateBack = false,
        navigateUp = { },
        onTrashClicked = { },
        itemsSelected = 1,
        onItemsSelectedCancel = {}
    )
}