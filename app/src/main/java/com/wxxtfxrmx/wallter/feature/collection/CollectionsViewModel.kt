package com.wxxtfxrmx.wallter.feature.collection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wxxtfxrmx.wallter.entity.Collection
import com.wxxtfxrmx.wallter.feature.collection.interactor.CollectionInteractor
import kotlinx.coroutines.launch

class CollectionsViewModel(
    private val collectionInteractor: CollectionInteractor,
) : ViewModel() {

    private val _collections = MutableLiveData<List<Collection>>()
    val collections: LiveData<List<Collection>> = _collections

    private val _updateCollectionEvent = MutableLiveData<Unit>()
    val updateCollectionEvent: LiveData<Unit> = _updateCollectionEvent

    fun loadCollections() {
        viewModelScope.launch {
            _collections.value = collectionInteractor.getCollection()
        }
    }

    fun search(query: String) {
        viewModelScope.launch {
            _collections.value = collectionInteractor.searchCollection(query)
        }
    }

    fun updateCollection(collection: Collection) {
        collection.liked = !collection.liked

        _updateCollectionEvent.value = Unit
    }
}