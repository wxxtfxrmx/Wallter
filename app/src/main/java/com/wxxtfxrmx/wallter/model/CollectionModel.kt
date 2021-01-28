package com.wxxtfxrmx.wallter.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class CollectionModel(
    val id: String,
    val title: String,
    @SerialName("cover_photo")
    val cover: PhotoModel,
    @Transient
    val liked: Boolean = false
)