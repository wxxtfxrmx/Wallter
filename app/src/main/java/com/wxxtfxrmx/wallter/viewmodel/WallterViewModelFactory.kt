package com.wxxtfxrmx.wallter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wxxtfxrmx.wallter.collection.CollectionsViewModel
import com.wxxtfxrmx.wallter.provider.CollectionInteractorProvider

class WallterViewModelFactory(
    private val collectionInteractorProvider: CollectionInteractorProvider,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModel = when {
            modelClass.isAssignableFrom(CollectionsViewModel::class.java) -> CollectionsViewModel(
                collectionInteractorProvider()
            )
            else -> throw IllegalArgumentException("View model class $modelClass is not supported")
        }

        return viewModel as T
    }
}