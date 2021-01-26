package com.wxxtfxrmx.wallter.collection

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.wxxtfxrmx.wallter.R
import com.wxxtfxrmx.wallter.entity.Collection
import com.wxxtfxrmx.wallter.extension.dp

class CollectionViewHolder(
    parent: ViewGroup,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.collection_view_holder, parent, false)
) {

    private val category = itemView.findViewById<TextView>(R.id.category)
    private val disclaimer = itemView.findViewById<TextView>(R.id.disclaimer)
    private val cover = itemView.findViewById<ImageView>(R.id.cover)

    fun bind(collection: Collection) {
        category.text = collection.title
        disclaimer.text = "by ${collection.cover.user.name}"

        cover.load(collection.cover.photoUrl.regular) {
            transformations(RoundedCornersTransformation(itemView.context.dp(8).toFloat()))
        }
    }
}