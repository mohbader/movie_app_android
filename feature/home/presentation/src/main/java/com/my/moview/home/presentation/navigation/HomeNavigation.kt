package com.my.moview.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.my.movie.core.navigation.OnNavigateTo
import com.my.movie.core.navigation.main.MainNav
import com.my.moview.home.presentation.HomeScreen

fun NavGraphBuilder.homeScreen(onNavigate: OnNavigateTo) {
    composable<MainNav.MainRout.Home> {
        HomeScreen(onNavigate)
    }
}