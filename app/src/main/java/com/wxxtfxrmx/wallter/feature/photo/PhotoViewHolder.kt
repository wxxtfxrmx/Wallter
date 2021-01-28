package com.wxxtfxrmx.wallter.feature.photo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.wxxtfxrmx.wallter.R
import com.wxxtfxrmx.wallter.entity.Photo
import com.wxxtfxrmx.wallter.common.extension.dp

class PhotoViewHolder(
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.collection_view_holder, parent, false)
) {

    private val category = itemView.findViewById<TextView>(R.id.category)
    private val disclaimer = itemView.findViewById<TextView>(R.id.disclaimer)
    private val cover = itemView.findViewById<ImageView>(R.id.cover)

    fun bind(photo: Photo) {
        category.isVisible = false
        disclaimer.text = "@${photo.user.userName}"

        disclaimer.updateLayoutParams<ConstraintLayout.LayoutParams> {
            this.topMargin = itemView.context.dp(8)
        }

        cover.load(photo.photoUrl.regular) {
            transformations(RoundedCornersTransformation(itemView.context.dp(8).toFloat()))
        }
    }
}