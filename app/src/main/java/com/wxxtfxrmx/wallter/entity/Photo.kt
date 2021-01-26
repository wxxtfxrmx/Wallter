package com.wxxtfxrmx.wallter.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Photo(
    val id: String,
    val width: Int,
    val height: Int,
    val color: String,
    @SerialName("blur_hash")
    val blurHash: String,
    @SerialName("urls")
    val photoUrl: PhotoUrl,
    val user: User,
)