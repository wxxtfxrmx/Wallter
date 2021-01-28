package com.wxxtfxrmx.wallter.feature.collection.pref

import android.content.SharedPreferences
import kotlinx.serialization.json.Json

class CollectionPreferences(
    private val json: Json,
    private val prefs: SharedPreferences
) {

    private companion object {
        const val COLLECTIONS_KEY = "collections.key"
    }

    fun setCollections() {

    }
}