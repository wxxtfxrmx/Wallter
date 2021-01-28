package com.wxxtfxrmx.wallter.photo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wxxtfxrmx.wallter.entity.Photo
import com.wxxtfxrmx.wallter.photo.interactor.PhotosInteractor
import kotlinx.coroutines.launch

class PhotosViewModel(
    private val photosInteractor: PhotosInteractor,
) : ViewModel() {

    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> = _photos

    fun loadPhotos() {
        viewModelScope.launch {
            _photos.value = photosInteractor.getPhotos()
        }
    }

    fun search(query: String) {
        viewModelScope.launch {
            _photos.value = photosInteractor.search(query)
        }
    }
}