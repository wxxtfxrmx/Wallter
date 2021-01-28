package com.wxxtfxrmx.wallter.di

import com.wxxtfxrmx.wallter.model.converter.CollectionConverter
import com.wxxtfxrmx.wallter.model.converter.PhotoConverter
import com.wxxtfxrmx.wallter.model.converter.PhotoUrlConverter
import com.wxxtfxrmx.wallter.model.converter.UserConverter

class CollectionConverterProvider(
    private val photoConverterProvider: PhotoConverterProvider,
) {

    operator fun invoke() =
        CollectionConverter(photoConverterProvider())
}

class PhotoConverterProvider(
    private val photoUrlConverterProvider: PhotoUrlConverterProvider,
    private val userConverterProvider: UserConverterProvider,
) {

    operator fun invoke() =
        PhotoConverter(photoUrlConverterProvider(), userConverterProvider())
}

class PhotoUrlConverterProvider {

    operator fun invoke() =
        PhotoUrlConverter()
}

class UserConverterProvider {

    operator fun invoke() =
        UserConverter()
}

