package com.my.moview.home.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.my.movie.core.navigation.OnNavigateTo
import com.my.movie.core.navigation.main.MainNav
import com.my.moview.home.presentation.HomeScreen

fun NavController.navigateToHome(navOptions: NavOptions) =
    navigate(route = MainNav.MainRout.Home, navOptions)

fun NavGraphBuilder.homeScreen(onNavigate: OnNavigateTo) {
    composable<MainNav.MainRout.Home> {
        HomeScreen(onNavigate)
    }
}