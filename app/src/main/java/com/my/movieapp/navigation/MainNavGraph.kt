package com.my.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.my.movie.core.navigation.MainGraph
import com.my.movie.core.navigation.Navigable
import com.my.movie.core.navigation.PreviousScreen
import com.my.movie.details.presentation.navigation.detailsScreen
import com.my.movieapp.ui.MainScreen

@Composable
fun MainNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: MainGraph = MainGraph.Home,
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<MainGraph.Home> {
            MainScreen { destination, optionsBuilder ->
                navController.navigateTo(destination, navOptions(optionsBuilder))
            }
        }

        detailsScreen() { destination, optionsBuilder ->
            navController.navigateTo(destination, navOptions(optionsBuilder))
        }

    }

}

private fun NavHostController.navigateTo(
    destination: Navigable,
    navOptions: NavOptions?,
) {
    when (destination) {
        is PreviousScreen -> {
            val isBackStackEmpty = previousBackStackEntry == null
            if (!isBackStackEmpty) popBackStack()
        }

        else -> navigate(destination, navOptions)
    }
}
