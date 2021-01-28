package com.wxxtfxrmx.wallter.feature.collection.interactor

import com.wxxtfxrmx.wallter.entity.Collection
import com.wxxtfxrmx.wallter.feature.collection.api.CollectionApi
import com.wxxtfxrmx.wallter.model.converter.CollectionConverter

class CollectionInteractor(
    private val collectionConverter: CollectionConverter,
    private val collectionApi: CollectionApi,
) {

    suspend fun getCollection(): List<Collection> =
        collectionApi.getCollection().map(collectionConverter::convert)

    suspend fun searchCollection(query: String): List<Collection> =
        collectionApi.searchCollection(query).map(collectionConverter::convert)
}