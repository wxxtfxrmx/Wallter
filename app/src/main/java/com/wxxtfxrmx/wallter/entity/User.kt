package com.wxxtfxrmx.wallter.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(val name: String,
                @SerialName("username")
                val userName: String)