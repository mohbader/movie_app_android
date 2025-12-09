package com.my.movie.favourite.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.my.movie.core.navigation.OnNavigateTo
import com.my.movie.core.navigation.main.MainNav
import com.my.movie.favourite.presentation.FavouriteScreen

fun NavGraphBuilder.favouriteScreen(onNavigate: OnNavigateTo) {
    composable<MainNav.MainRout.Favourites> {
        FavouriteScreen()
    }
}