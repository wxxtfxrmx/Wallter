package com.wxxtfxrmx.wallter.model.converter

import com.wxxtfxrmx.wallter.entity.Collection
import com.wxxtfxrmx.wallter.model.CollectionModel

class CollectionConverter(
    private val photoConverter: PhotoConverter,
) {

    fun convert(model: CollectionModel): Collection =
        Collection(
            id = model.id,
            title = model.title,
            cover = photoConverter.convert(model.cover),
            liked = model.liked,
        )

    fun revert(entity: Collection): CollectionModel =
        CollectionModel(
            id = entity.id,
            title = entity.title,
            cover = photoConverter.revert(entity.cover),
            liked = entity.liked,
        )
}