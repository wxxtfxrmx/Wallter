package com.wxxtfxrmx.wallter.model.converter

import com.wxxtfxrmx.wallter.entity.Photo
import com.wxxtfxrmx.wallter.model.PhotoModel

class PhotoConverter(
    private val photoUrlConverter: PhotoUrlConverter,
    private val userConverter: UserConverter,
) {

    fun convert(model: PhotoModel): Photo =
        Photo(
            id = model.id,
            width = model.width,
            height = model.height,
            color = model.color,
            blurHash = model.blurHash,
            photoUrl = photoUrlConverter.convert(model.photoUrl),
            user = userConverter.convert(model.user),
        )

    fun revert(entity: Photo): PhotoModel =
        PhotoModel(
            id = entity.id,
            width = entity.width,
            height = entity.height,
            color = entity.color,
            blurHash = entity.blurHash,
            photoUrl = photoUrlConverter.revert(entity.photoUrl),
            user = userConverter.revert(entity.user),
        )
}