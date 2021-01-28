package com.wxxtfxrmx.wallter.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoModel(
    val id: String,
    val width: Int,
    val height: Int,
    val color: String,
    @SerialName("blur_hash")
    val blurHash: String,
    @SerialName("urls")
    val photoUrl: PhotoUrlModel,
    val user: UserModel,
)