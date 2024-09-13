package br.com.blackfishlabs.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {
    @Serializable
    data object HomeScreen : Routes()

    @Serializable
    data object SearchScreen : Routes()

    @Serializable
    data object FavoriteScreen : Routes()

    @Serializable
    data class FullPhotoScreen(val imageId: String) : Routes()

    @Serializable
    data class ProfileScreen(val link: String) : Routes()
}