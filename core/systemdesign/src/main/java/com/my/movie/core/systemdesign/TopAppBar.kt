package com.my.movie.core.systemdesign

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieTopAppBar(
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    @StringRes title: Int,
    onSettingsClicked:() -> Unit = {}
) {
    CenterAlignedTopAppBar(
        modifier = Modifier.testTag("Movie App"),
        title = {
            Text(text = stringResource(title))
        },
        navigationIcon = {

        },
        actions = {
            IconButton(onClick = {onSettingsClicked}) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings"
                )
            }
        },
        colors = colors
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview("top app bar preview")
fun MovieTopAppBarPreview(){
    MovieTopAppBar(
        title=android.R.string.untitled
    )
}

