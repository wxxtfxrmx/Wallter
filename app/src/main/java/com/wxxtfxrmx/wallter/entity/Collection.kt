package com.wxxtfxrmx.wallter.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Collection(
    val id: String,
    val title: String,
    @SerialName("cover_photo")
    val cover: Photo,
)