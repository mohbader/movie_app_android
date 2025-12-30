package com.my.movie.favourite.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.my.movie.core.navigation.MainGraph
import com.my.movie.core.navigation.OnNavigateTo
import com.my.movie.core.navigation.main.MainNav
import com.my.movie.favourite.presentation.FavouriteScreen

fun NavController.navigateToFavourite(navOptions: NavOptions) = navigate(route = MainNav.MainRout.Favourites, navOptions)


fun NavGraphBuilder.favouriteScreen(onNavigate: OnNavigateTo) {
    composable<MainNav.MainRout.Favourites> {
        FavouriteScreen()
    }
}