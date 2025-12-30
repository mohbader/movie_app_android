package com.my.movieapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.my.movie.core.navigation.OnNavigateTo
import com.my.movie.core.navigation.main.MainNav
import com.my.movie.core.systemdesign.MovieTopAppBar
import com.my.movie.favourite.presentation.navigation.favouriteScreen
import com.my.movie.setting.presentation.SettingDialog
import com.my.movieapp.navigation.TopLevelDestination
import com.my.movieapp.navigation.navigateToTopLevelDestination
import com.my.movieapp.navigation.topLevelDestinationList
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
        topLevelDestinationList.find { currentDestination?.hasRoute(it.root) == true }
            ?: TopLevelDestination.HOME


    var showSettingsDialog by rememberSaveable { mutableStateOf(false) }

    if (showSettingsDialog)
        SettingDialog(onDismiss = { showSettingsDialog = false })

    NavigationSuiteScaffold(
        modifier = modifier,
        navigationSuiteItems = {
            topLevelDestinationList.forEach { item ->
                item(
                    icon = {
                        Icon(imageVector = item.icon, contentDescription = null)
                    },
                    onClick = {
                        navigateToTopLevelDestination(item, navController)
                    },
                    selected = topLevelDestinationList == currentScreen.root
                )
            }
        }) {
        Scaffold() {
            Column() {
                MovieTopAppBar(
                    title = currentScreen.title,
                    onSettingsClicked = { showSettingsDialog = true }
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

