package com.my.movie.details.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.my.movie.core.navigation.MainGraph
import com.my.movie.core.navigation.OnNavigateTo
import com.my.movie.core.navigation.main.MainNav
import com.my.movie.details.presentation.DetailsScreen

fun NavGraphBuilder.detailsScreen(onNavigate: OnNavigateTo) {
    composable<MainGraph.Details> {
        DetailsScreen()
    }
}