package com.wxxtfxrmx.wallter.photo.interactor

import com.wxxtfxrmx.wallter.entity.Photo
import com.wxxtfxrmx.wallter.photo.api.PhotoApi

class PhotosInteractor(
    private val photoApi: PhotoApi
) {

    suspend fun getPhotos(): List<Photo> =
        photoApi.getPhotos()

    suspend fun search(query: String): List<Photo> =
        photoApi.search(query)
}