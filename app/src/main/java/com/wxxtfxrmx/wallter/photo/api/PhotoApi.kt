package com.wxxtfxrmx.wallter.photo.api

import com.wxxtfxrmx.wallter.entity.Photo
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

    suspend fun getPhotos(): List<Photo> =
        client.get(url)

    suspend fun search(query: String): List<Photo> {
        val jsonObject = client.get<JsonObject> {
            url(searchPhotoUrl)
            parameter("orientation", "portrait")
            parameter("query", query)
        }["results"]

        jsonObject ?: return emptyList()

        return json.decodeFromJsonElement(ListSerializer(Photo.serializer()), jsonObject)
    }
}