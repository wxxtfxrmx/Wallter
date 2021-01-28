package com.wxxtfxrmx.wallter.feature.collection

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wxxtfxrmx.wallter.entity.Collection

class CollectionsAdapter(
    private val favoriteClickListener: (Collection) -> Unit,
) : RecyclerView.Adapter<CollectionViewHolder>() {

    var collections: List<Collection> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder =
        CollectionViewHolder(favoriteClickListener, parent)

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        holder.bind(collections[position])
    }


    override fun getItemCount(): Int = collections.size
}