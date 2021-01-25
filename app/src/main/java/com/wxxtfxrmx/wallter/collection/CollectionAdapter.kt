package com.wxxtfxrmx.wallter.collection

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CollectionAdapter : RecyclerView.Adapter<CollectionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder =
        CollectionViewHolder(parent)

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) =
        Unit

    override fun getItemCount(): Int = 5

}