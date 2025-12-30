package com.my.movieapp.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmarks
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.my.movie.core.navigation.main.MainNav
import com.my.movieapp.R
import kotlin.reflect.KClass

enum class TopLevelDestination(
    @StringRes val title: Int,
    val icon: ImageVector,
    val root:  KClass<*>
) {
    HOME(
        title = R.string.label_home,
        icon = Icons.Outlined.Home,
        root = MainNav.MainRout.Home::class
    ),

    FAVOURITE(
        title = R.string.label_saved,
        icon = Icons.Outlined.Bookmarks,
        root = MainNav.MainRout.Favourites::class
    )
}