package com.my.movie.core.navigation.main

import com.my.movie.core.navigation.Navigable
import kotlinx.serialization.Serializable


sealed class MainNav : Navigable {
    sealed class MainRout : MainNav() {
        @Serializable
        data object Home : MainRout()

        @Serializable
        data object Favourites : MainRout()
    }
}
