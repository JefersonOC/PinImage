package br.com.blackfishlabs.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PexelDTO(
    val page: Long,
    @SerialName("per_page")
    val perPage: Long,
    val photos: List<Photo>,
    @SerialName("total_results")
    val totalResults: Long,
    @SerialName("next_page")
    val nextPage: String,
)

@Serializable
data class Photo(
    val id: Long,
    val width: Long,
    val height: Long,
    val url: String,
    val photographer: String,
    @SerialName("photographer_url")
    val photographerUrl: String,
    @SerialName("photographer_id")
    val photographerId: Long,
    @SerialName("avg_color")
    val avgColor: String,
    val src: Src,
    val liked: Boolean,
    val alt: String,
)

@Serializable
data class Src(
    val original: String,
    val large2x: String,
    val large: String,
    val medium: String,
    val small: String,
    val portrait: String,
    val landscape: String,
    val tiny: String,
)
