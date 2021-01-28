package com.wxxtfxrmx.wallter.di

import com.wxxtfxrmx.wallter.BuildConfig
import com.wxxtfxrmx.wallter.feature.collection.api.CollectionApi
import com.wxxtfxrmx.wallter.feature.collection.interactor.CollectionInteractor
import com.wxxtfxrmx.wallter.feature.photo.api.PhotoApi
import com.wxxtfxrmx.wallter.feature.photo.interactor.PhotosInteractor
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json
import okhttp3.logging.HttpLoggingInterceptor

class CollectionApiProvider(
    private val httpClientProvider: HttpClientProvider,
    private val jsonProvider: JsonProvider,
) {

    operator fun invoke(): CollectionApi =
        CollectionApi(jsonProvider(), httpClientProvider())
}

class PhotosApiProvider(
    private val httpClientProvider: HttpClientProvider,
    private val jsonProvider: JsonProvider
) {

    operator fun invoke(): PhotoApi =
        PhotoApi(jsonProvider(), httpClientProvider())
}

class PhotosInteractorProvider(
    private val photoConverterProvider: PhotoConverterProvider,
    private val photosApiProvider: PhotosApiProvider
) {

    operator fun invoke(): PhotosInteractor =
        PhotosInteractor(photoConverterProvider(), photosApiProvider())
}

class CollectionInteractorProvider(
    private val collectionConverterProvider: CollectionConverterProvider,
    private val apiProvider: CollectionApiProvider
) {

    operator fun invoke(): CollectionInteractor =
        CollectionInteractor(collectionConverterProvider(), apiProvider())
}

class JsonProvider(private val json: Json) {

    operator fun invoke(): Json =
        json
}

class HttpClientProvider(private val jsonProvider: JsonProvider) {

    private val client = HttpClient(OkHttp) {
        engine {
            val interceptor = HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }

            addInterceptor(interceptor)
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer(jsonProvider())
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 15000L
            connectTimeoutMillis = 15000L
            socketTimeoutMillis = 15000L
        }

        defaultRequest {
            parameter(
                "client_id",
                "WAdpDG-hYViRW7nphTJNHIlVfkHk0oiA4m_yeC2eCkw"
            )
            header("Accept-Version", "v1")
        }
    }

    operator fun invoke(): HttpClient =
        client
}