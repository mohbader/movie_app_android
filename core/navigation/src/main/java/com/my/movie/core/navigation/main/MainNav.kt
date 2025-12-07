package com.my.movie.core.navigation.main

import com.my.movie.core.navigation.Navigable
import kotlinx.serialization.Serializable

sealed class MainNav : Navigable {
    @Serializable
    data object Home : MainNav()
    @Serializable
    data object Favourites : MainNav()
}
