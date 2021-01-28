package com.wxxtfxrmx.wallter.model.converter

import com.wxxtfxrmx.wallter.entity.User
import com.wxxtfxrmx.wallter.model.UserModel

class UserConverter {

    fun convert(model: UserModel): User =
        User(
            name = model.name,
            userName = model.userName,
        )

    fun revert(entity: User): UserModel =
        UserModel(
            name = entity.name,
            userName = entity.userName,
        )
}