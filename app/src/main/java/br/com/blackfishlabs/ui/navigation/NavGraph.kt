package br.com.blackfishlabs.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import br.com.blackfishlabs.ui.screen.favorites_screen.FavoritesScreen
import br.com.blackfishlabs.ui.screen.full_photo_screen.FullPhotoScreen
import br.com.blackfishlabs.ui.screen.home_screen.HomeScreen
import br.com.blackfishlabs.ui.screen.home_screen.HomeScreenViewModel
import br.com.blackfishlabs.ui.screen.search_screen.SearchScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraphSetup(
    navController: NavHostController,
    scrollBehavior: TopAppBarScrollBehavior,
) {
    NavHost(
        navController = navController,
        startDestination = Routes.HomeScreen,
    ) {
        composable<Routes.HomeScreen> {
            val viewModel = viewModel<HomeScreenViewModel>()
            HomeScreen(
                scrollBehavior = scrollBehavior,
                photos = viewModel.photos,
                onImageClick = { imageId ->
                    navController.navigate(Routes.FullPhotoScreen(imageId))
                },
                onSearchClick = {
                    navController.navigate(Routes.SearchScreen)
                },
                onFabClick = {
                    navController.navigate(Routes.FavoriteScreen)
                }
            )
        }
        composable<Routes.SearchScreen> {
            SearchScreen(
                onBackClick = { navController.navigateUp() }
            )
        }
        composable<Routes.FavoriteScreen> {
            FavoritesScreen(
                onBackClick = { navController.navigateUp() }
            )
        }
        composable<Routes.FullPhotoScreen> { backStackEntry ->
            val imageId = backStackEntry.toRoute<Routes.FullPhotoScreen>().imageId
            FullPhotoScreen(
                imageId = imageId,
                onBackClick = { navController.navigateUp() }
            )
        }
        composable<Routes.ProfileScreen> {

        }
    }
}
