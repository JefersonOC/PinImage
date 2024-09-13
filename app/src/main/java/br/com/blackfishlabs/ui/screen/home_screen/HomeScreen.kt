package br.com.blackfishlabs.ui.screen.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.blackfishlabs.domain.model.PhotoModel
import br.com.blackfishlabs.ui.component.PhotoVerticalGrid
import br.com.blackfishlabs.ui.component.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    scrollBehavior: TopAppBarScrollBehavior,
    photos: List<PhotoModel>,
    onImageClick: (String) -> Unit,
    onSearchClick: () -> Unit,
    onFabClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                onSearchClick = onSearchClick
            )
            PhotoVerticalGrid(
                photos = photos,
                onImageClick = onImageClick
            )
        }
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp),
            onClick = { onFabClick() }) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorites",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}