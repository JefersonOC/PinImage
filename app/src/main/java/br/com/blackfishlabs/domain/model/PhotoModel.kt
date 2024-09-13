package br.com.blackfishlabs.domain.model

data class PhotoModel(
    val id: String,
    val url: String,
    val photographer: String,
    val width: Long,
    val height: Long,
)