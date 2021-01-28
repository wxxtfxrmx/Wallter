package com.wxxtfxrmx.wallter.model

import kotlinx.serialization.Serializable

@Serializable
data class PhotoUrlModel(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String,
)