package com.wxxtfxrmx.wallter.entity

data class Photo(
    val id: String,
    val width: Int,
    val height: Int,
    val color: String,
    val blurHash: String,
    val photoUrl: PhotoUrl,
    val user: User,
)