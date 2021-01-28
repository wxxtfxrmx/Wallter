package com.wxxtfxrmx.wallter.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserModel(
    val name: String,
    @SerialName("username")
    val userName: String,
)