package br.com.blackfishlabs.ui.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import br.com.blackfishlabs.domain.model.PhotoModel
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PhotoCard(
    modifier: Modifier = Modifier,
    photo: PhotoModel?
) {
    val photoRequest = ImageRequest.Builder(LocalContext.current)
        .data(photo?.url)
        .crossfade(true)
        .build()

    val aspectRatio: Float by remember {
        derivedStateOf { (photo?.width?.toFloat() ?: 1f) / (photo?.height?.toFloat() ?: 1f) }
    }

    Card(
        shape = RoundedCornerShape(5),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(aspectRatio)
            .then(modifier)
    ) {
        AsyncImage(
            model = photoRequest,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
}