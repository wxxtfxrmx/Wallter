package com.wxxtfxrmx.wallter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wxxtfxrmx.wallter.collection.CollectionsFragment
import com.wxxtfxrmx.wallter.photo.PhotosFragment
import com.wxxtfxrmx.wallter.provider.*
import com.wxxtfxrmx.wallter.viewmodel.WallterViewModelFactory
import kotlinx.serialization.json.Json

class MainActivity : AppCompatActivity(), Router {

    private val jsonProvider = JsonProvider(provideJson())
    private val httpClientProvider = HttpClientProvider(jsonProvider)
    private val apiProvider = CollectionApiProvider(httpClientProvider, jsonProvider)
    private val photosApiProvider = PhotosApiProvider(httpClientProvider, jsonProvider)
    private val collectionInteractorProvider = CollectionInteractorProvider(apiProvider)
    private val photosInteractorProvider = PhotosInteractorProvider(photosApiProvider)
    val viewModelProviderFactory =
        WallterViewModelFactory(collectionInteractorProvider, photosInteractorProvider)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openCollections()
    }

    private fun provideJson(): Json =
        Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = false
        }

    override fun openCollections() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, CollectionsFragment.newInstance())
            .commit()
    }

    override fun openPhotos() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, PhotosFragment.newInstance())
            .commit()
    }
}