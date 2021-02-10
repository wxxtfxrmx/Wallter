package com.wxxtfxrmx.wallter.feature.collection.interactor

import com.wxxtfxrmx.wallter.entity.Collection
import com.wxxtfxrmx.wallter.feature.collection.api.CollectionApi
import com.wxxtfxrmx.wallter.model.CollectionModel
import com.wxxtfxrmx.wallter.model.converter.CollectionConverter
import com.wxxtfxrmx.wallter.model.storage.CollectionStorage

class CollectionInteractor(
    private val collectionConverter: CollectionConverter,
    private val collectionStorage: CollectionStorage,
    private val collectionApi: CollectionApi,
) {

    suspend fun getCollection(): List<Collection> =
        collectionApi.getCollection().updateCollections().map(collectionConverter::convert)


    suspend fun searchCollection(query: String): List<Collection> =
        collectionApi.searchCollection(query).updateCollections().map(collectionConverter::convert)

    private fun List<CollectionModel>.updateCollections(): List<CollectionModel> {
        val savedCollectionIds = collectionStorage.getCollections()?.map { it.id } ?: emptyList()
        return map { if (it.id in savedCollectionIds) it.copy(liked = true) else it }
    }

    fun setCollections(collections: List<Collection>) {
        collections
            .map(collectionConverter::revert)
            .let(collectionStorage::setCollections)
    }
}