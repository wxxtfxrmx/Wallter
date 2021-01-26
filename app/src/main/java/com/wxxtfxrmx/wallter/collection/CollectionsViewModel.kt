package com.wxxtfxrmx.wallter.collection

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wxxtfxrmx.wallter.collection.interactor.CollectionInteractor
import com.wxxtfxrmx.wallter.entity.Collection
import kotlinx.coroutines.launch

class CollectionsViewModel(
    private val collectionInteractor: CollectionInteractor,
) : ViewModel() {

    private val _collections = MutableLiveData<List<Collection>>()
    val collections: LiveData<List<Collection>> = _collections

    fun loadCollections() {
        viewModelScope.launch {
            _collections.value = collectionInteractor.getCollection()
            Log.d(this::class.simpleName, "Collections value ${collections.value}")
        }
    }
}