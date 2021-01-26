package com.wxxtfxrmx.wallter.collection.api

import com.wxxtfxrmx.wallter.entity.Collection
import io.ktor.client.*
import io.ktor.client.request.*

class CollectionApi(
    private val client: HttpClient
) {

    private val url = "https://api.unsplash.com/collections"

    suspend fun getCollection(): List<Collection> =
        client.get(url)
}