package com.wxxtfxrmx.wallter.model.storage

import android.content.SharedPreferences
import androidx.core.content.edit
import com.wxxtfxrmx.wallter.model.CollectionModel
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class CollectionStorage(
    private val jsonParser: Json,
    private val preferences: SharedPreferences,
) {

    private companion object {
        const val COLLECTIONS_KEY = "collections.key"
        const val EMPTY_OBJECT = "{}"
    }

    fun setCollections(collections: List<CollectionModel>) {
        val json = jsonParser.encodeToString(
            ListSerializer(CollectionModel.serializer()),
            collections,
        )

        preferences.edit {
            putString(COLLECTIONS_KEY, json)
        }
    }

    fun getCollections(): List<CollectionModel>? {
        val json = preferences.getString(COLLECTIONS_KEY, EMPTY_OBJECT)

        return json?.let {
            jsonParser.decodeFromString(
                ListSerializer(CollectionModel.serializer()),
                it
            )
        }
    }
}