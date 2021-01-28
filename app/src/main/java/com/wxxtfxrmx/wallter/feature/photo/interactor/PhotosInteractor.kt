package com.wxxtfxrmx.wallter.feature.photo.interactor

import com.wxxtfxrmx.wallter.entity.Photo
import com.wxxtfxrmx.wallter.feature.photo.api.PhotoApi
import com.wxxtfxrmx.wallter.model.converter.PhotoConverter

class PhotosInteractor(
    private val photoConverter: PhotoConverter,
    private val photoApi: PhotoApi
) {

    suspend fun getPhotos(): List<Photo> =
        photoApi.getPhotos().map(photoConverter::convert)

    suspend fun search(query: String): List<Photo> =
        photoApi.search(query).map(photoConverter::convert)
}