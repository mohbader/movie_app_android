package com.my.movie.core.navigation

import kotlinx.serialization.Serializable

sealed class MainGraph : Navigable {
    @Serializable
    data object Home : MainGraph()

    @Serializable
    data object Details : MainGraph()
}
