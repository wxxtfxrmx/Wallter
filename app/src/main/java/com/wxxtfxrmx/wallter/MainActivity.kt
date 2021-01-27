package com.wxxtfxrmx.wallter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wxxtfxrmx.wallter.collection.CollectionsFragment
import com.wxxtfxrmx.wallter.provider.CollectionApiProvider
import com.wxxtfxrmx.wallter.provider.CollectionInteractorProvider
import com.wxxtfxrmx.wallter.provider.HttpClientProvider
import com.wxxtfxrmx.wallter.provider.JsonProvider
import com.wxxtfxrmx.wallter.viewmodel.WallterViewModelFactory
import kotlinx.serialization.json.Json

class MainActivity : AppCompatActivity() {

    private val jsonProvider = JsonProvider(provideJson())
    private val httpClientProvider = HttpClientProvider(jsonProvider)
    private val apiProvider = CollectionApiProvider(httpClientProvider, jsonProvider)
    private val collectionInteractorProvider = CollectionInteractorProvider(apiProvider)
    val viewModelProviderFactory = WallterViewModelFactory(collectionInteractorProvider)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, CollectionsFragment.newInstance())
            .commit()
    }

    private fun provideJson(): Json =
        Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = false
        }
}