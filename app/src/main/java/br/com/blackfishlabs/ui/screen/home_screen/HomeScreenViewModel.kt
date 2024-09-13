package br.com.blackfishlabs.ui.screen.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.blackfishlabs.data.mapper.toDomainModel
import br.com.blackfishlabs.di.AppModule
import br.com.blackfishlabs.domain.model.PhotoModel
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {

    var photos: List<PhotoModel> by mutableStateOf(emptyList())

    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            val result = AppModule.retrofitService.getCuratedPhotos()
            photos = result.toDomainModel()
        }
    }
}