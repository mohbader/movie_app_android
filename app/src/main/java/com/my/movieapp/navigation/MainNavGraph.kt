package com.my.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.my.movie.core.navigation.main.MainNav

@Composable
fun MainNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: MainNav = MainNav.Home
) {

    NavHost(
        navController=navController,
        startDestination = startDestination
    ){

    }

}