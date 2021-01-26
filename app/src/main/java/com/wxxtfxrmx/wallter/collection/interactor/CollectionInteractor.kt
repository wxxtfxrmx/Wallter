package com.wxxtfxrmx.wallter.collection.interactor

import com.wxxtfxrmx.wallter.collection.api.CollectionApi
import com.wxxtfxrmx.wallter.entity.Collection

class CollectionInteractor(
    private val collectionApi: CollectionApi,
) {

    suspend fun getCollection(): List<Collection> =
        collectionApi.getCollection()
}