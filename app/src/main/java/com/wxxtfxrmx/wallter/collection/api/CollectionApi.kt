package com.wxxtfxrmx.wallter.collection.api

import com.wxxtfxrmx.wallter.model.CollectionModel
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

class CollectionApi(
    private val json: Json,
    private val client: HttpClient
) {

    private val url = "https://api.unsplash.com/collections"
    private val searchCollectionUrl = "https://api.unsplash.com/search/collections"

    suspend fun getCollection(): List<CollectionModel> =
        client.get(url)

    suspend fun searchCollection(query: String): List<CollectionModel> {
        val jsonObject = client.get<JsonObject> {
            url(searchCollectionUrl)
            parameter("query", query)
        }["results"]

        jsonObject ?: return emptyList()

        return json.decodeFromJsonElement(ListSerializer(CollectionModel.serializer()), jsonObject)
    }
}