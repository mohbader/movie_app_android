package com.my.movieapp.ui

import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.my.movie.core.navigation.main.MainNav

@Composable
internal fun MainScreen(
    modifier: Modifier = Modifier,
) {

    NavigationSuiteScaffold(modifier = modifier,
        navigationSuiteItems={
            ite
        }) {

    }
}

private val items = listOf(
    MainNav.Home,
    MainNav.Favourites
)