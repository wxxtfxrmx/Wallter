package com.wxxtfxrmx.wallter.model.converter

import com.wxxtfxrmx.wallter.entity.PhotoUrl
import com.wxxtfxrmx.wallter.model.PhotoUrlModel

class PhotoUrlConverter {

    fun convert(model: PhotoUrlModel): PhotoUrl =
        PhotoUrl(
            raw = model.raw,
            full = model.full,
            regular = model.regular,
            small = model.small,
            thumb = model.thumb,
        )

    fun revert(entity: PhotoUrl): PhotoUrlModel =
        PhotoUrlModel(
            raw = entity.raw,
            full = entity.full,
            regular = entity.regular,
            small = entity.small,
            thumb = entity.thumb,
        )
}