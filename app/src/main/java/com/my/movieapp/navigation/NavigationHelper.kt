package com.my.movieapp.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.navOptions
import com.my.movie.favourite.presentation.navigation.navigateToFavourite
import com.my.moview.home.presentation.navigation.navigateToHome


val topLevelDestinationList: List<TopLevelDestination> = TopLevelDestination.entries

fun navigateToTopLevelDestination(
    topLevelDestination: TopLevelDestination, navController: NavHostController,
) {

    val topLevelNavOptions = navOptions {

        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

    when (topLevelDestination) {
        TopLevelDestination.HOME -> {
            navController.navigateToHome(topLevelNavOptions)
        }

        TopLevelDestination.FAVOURITE -> {
            navController.navigateToFavourite(topLevelNavOptions)
        }
    }
}

