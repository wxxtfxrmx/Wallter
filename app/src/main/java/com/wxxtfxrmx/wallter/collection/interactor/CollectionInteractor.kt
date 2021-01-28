package com.wxxtfxrmx.wallter.collection.interactor

import com.wxxtfxrmx.wallter.collection.api.CollectionApi
import com.wxxtfxrmx.wallter.entity.Collection
import com.wxxtfxrmx.wallter.model.CollectionModel

class CollectionInteractor(
    private val collectionApi: CollectionApi,
) {

    suspend fun getCollection(): List<Collection> =
        collectionApi.getCollection().map(::convert)

    suspend fun searchCollection(query: String): List<Collection> =
        collectionApi.searchCollection(query).map(::convert)

    private fun convert(model: CollectionModel): Collection =
        Collection(
            id = model.id,
            title = model.title,
            cover = model.cover,
        )
}