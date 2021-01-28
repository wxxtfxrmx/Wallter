package com.wxxtfxrmx.wallter.model

import com.wxxtfxrmx.wallter.entity.Photo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollectionModel(
    val id: String,
    val title: String,
    @SerialName("cover_photo")
    val cover: Photo,
)