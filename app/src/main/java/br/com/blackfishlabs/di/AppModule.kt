package br.com.blackfishlabs.di

import br.com.blackfishlabs.data.helper.Constants
import br.com.blackfishlabs.data.remote.PexelAPIService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object AppModule {

    private val contentType = "application/json".toMediaType()
    private val json = Json { ignoreUnknownKeys = true }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory(contentType))
        .baseUrl(Constants.BASE_URL)
        .build()

    val retrofitService: PexelAPIService by lazy {
        retrofit.create(PexelAPIService::class.java)
    }
}