package com.wxxtfxrmx.wallter.feature.photo

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wxxtfxrmx.wallter.entity.Photo

class PhotosAdapter : RecyclerView.Adapter<PhotoViewHolder>() {

    var photos: List<Photo> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder =
        PhotoViewHolder(parent)

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    override fun getItemCount(): Int =
        photos.size
}