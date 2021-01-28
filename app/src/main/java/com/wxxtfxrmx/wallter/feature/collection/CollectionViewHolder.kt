package com.wxxtfxrmx.wallter.feature.collection

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.wxxtfxrmx.wallter.R
import com.wxxtfxrmx.wallter.entity.Collection
import com.wxxtfxrmx.wallter.common.extension.dp

class CollectionViewHolder(
    private val favoriteClickListener: (Collection) -> Unit,
    parent: ViewGroup,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.collection_view_holder, parent, false)
) {

    private val category = itemView.findViewById<TextView>(R.id.category)
    private val disclaimer = itemView.findViewById<TextView>(R.id.disclaimer)
    private val cover = itemView.findViewById<ImageView>(R.id.cover)
    private val favoriteIcon = itemView.findViewById<ImageView>(R.id.favoriteIcon)

    fun bind(collection: Collection) {
        category.text = collection.title
        disclaimer.text = "by ${collection.cover.user.name}"

        val drawable = if (collection.liked) {
            R.drawable.ic_favorite
        } else {
            R.drawable.ic_favorite_border
        }

        favoriteIcon.setImageDrawable(ContextCompat.getDrawable(itemView.context, drawable))

        favoriteIcon.setOnClickListener {
            favoriteClickListener(collection)
        }

        cover.load(collection.cover.photoUrl.regular) {
            transformations(RoundedCornersTransformation(itemView.context.dp(8).toFloat()))
        }
    }
}