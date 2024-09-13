package br.com.blackfishlabs.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.blackfishlabs.domain.model.PhotoModel

@Composable
fun PhotoVerticalGrid(
    modifier: Modifier = Modifier,
    photos: List<PhotoModel?>,
    onImageClick: (String) -> Unit
) {
    LazyVerticalStaggeredGrid(
        modifier = modifier,
        columns = StaggeredGridCells.Adaptive(120.dp),
        contentPadding = PaddingValues(10.dp),
        verticalItemSpacing = 10.dp,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(photos) { image ->
            PhotoCard(
                photo = image,
                modifier = Modifier.clickable { image?.id?.let { onImageClick(it) } }
            )
        }
    }
}