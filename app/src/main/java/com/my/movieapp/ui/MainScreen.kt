package com.my.movieapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.my.movie.core.navigation.OnNavigateTo
import com.my.movie.core.navigation.R
import com.my.movie.core.navigation.main.MainNav
import com.my.movie.core.systemdesign.MovieTopAppBar
import com.my.movie.favourite.presentation.navigation.favouriteScreen
import com.my.moview.home.presentation.navigation.homeScreen

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    onNavigation: OnNavigateTo
) {

    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val currentScreen =
        items.find { currentDestination?.hasRoute(it::class) == true }
            ?: MainNav.MainRout.Home

    NavigationSuiteScaffold(
        modifier = modifier,
        navigationSuiteItems = {
            items.forEach { item ->
                item(
                    icon = {
                        Icon(imageVector = item.icon, contentDescription = null)
                    },
                    onClick = {
                        navController.navigate(item) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    selected = items == currentScreen
                )
            }
        }) {
        Scaffold() {
            Column() {
                MovieTopAppBar(
                    title= com.my.movieapp.R.string.app_name
                )

                NavHost(
                    navController = navController,
                    startDestination = MainNav.MainRout.Home,
                    modifier = Modifier.systemBarsPadding(),
                ) {
                    homeScreen(onNavigation)
                    favouriteScreen(onNavigation)
                }
            }
        }
    }
}

private val items = listOf(
    MainNav.MainRout.Home,
    MainNav.MainRout.Favourites
)
private val MainNav.MainRout.icon
    get() =
        when (this) {
            is MainNav.MainRout.Home -> Icons.Default.Home
            is MainNav.MainRout.Favourites -> Icons.Default.FavoriteBorder
        }
