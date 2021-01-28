package com.wxxtfxrmx.wallter.feature.photo.api

import com.wxxtfxrmx.wallter.model.PhotoModel
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

class PhotoApi(
    private val json: Json,
    private val client: HttpClient
) {

    private val url = "https://api.unsplash.com/photos"
    private val searchPhotoUrl = "https://api.unsplash.com/search/photos"

    suspend fun getPhotos(): List<PhotoModel> =
        client.get(url)

    suspend fun search(query: String): List<PhotoModel> {
        val jsonObject = client.get<JsonObject> {
            url(searchPhotoUrl)
            parameter("orientation", "portrait")
            parameter("query", query)
        }["results"]

        jsonObject ?: return emptyList()

        return json.decodeFromJsonElement(ListSerializer(PhotoModel.serializer()), jsonObject)
    }
}