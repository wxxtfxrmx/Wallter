package com.wxxtfxrmx.wallter.entity

import kotlinx.serialization.Serializable

@Serializable
data class PhotoUrl(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String,
)