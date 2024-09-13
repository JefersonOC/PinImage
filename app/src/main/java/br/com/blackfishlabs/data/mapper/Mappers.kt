package br.com.blackfishlabs.data.mapper

import br.com.blackfishlabs.data.remote.dto.PexelDTO
import br.com.blackfishlabs.domain.model.PhotoModel

fun PexelDTO.toDomainModel(): List<PhotoModel> {
    return this.photos.map {
        PhotoModel(
            id = it.id.toString(),
            url = it.src.original,
            photographer = it.photographer,
            width = it.width,
            height = it.height
        )
    }
}