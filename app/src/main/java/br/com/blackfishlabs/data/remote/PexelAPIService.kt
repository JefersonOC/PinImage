package br.com.blackfishlabs.data.remote

import br.com.blackfishlabs.data.helper.Constants
import br.com.blackfishlabs.data.remote.dto.PexelDTO
import retrofit2.http.GET
import retrofit2.http.Headers

interface PexelAPIService {
    @Headers("Authorization: ${Constants.API_KEY}")
    @GET("curated?per_page=80")
    suspend fun getCuratedPhotos(): PexelDTO
}