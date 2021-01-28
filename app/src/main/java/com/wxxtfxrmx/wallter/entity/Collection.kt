package com.wxxtfxrmx.wallter.entity

data class Collection(
    val id: String,
    val title: String,
    val cover: Photo,
    var liked: Boolean = false
)