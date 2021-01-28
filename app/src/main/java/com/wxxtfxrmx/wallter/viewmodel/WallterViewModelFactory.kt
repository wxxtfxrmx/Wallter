package com.wxxtfxrmx.wallter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wxxtfxrmx.wallter.collection.CollectionsViewModel
import com.wxxtfxrmx.wallter.photo.PhotosViewModel
import com.wxxtfxrmx.wallter.provider.CollectionInteractorProvider
import com.wxxtfxrmx.wallter.provider.PhotosInteractorProvider

class WallterViewModelFactory(
    private val collectionInteractorProvider: CollectionInteractorProvider,
    private val photosInteractorProvider: PhotosInteractorProvider,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModel = when {
            modelClass.isAssignableFrom(CollectionsViewModel::class.java) -> CollectionsViewModel(
                collectionInteractorProvider()
            )

            modelClass.isAssignableFrom(PhotosViewModel::class.java) -> PhotosViewModel(
                photosInteractorProvider()
            )

            else -> throw IllegalArgumentException("View model class $modelClass is not supported")
        }

        return viewModel as T
    }
}