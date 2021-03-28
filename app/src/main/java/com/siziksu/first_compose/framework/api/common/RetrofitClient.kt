package com.siziksu.first_compose.framework.api.common

import android.content.Context
import com.siziksu.first_compose.BuildConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient(private val context: Context) {

    fun getRetrofit(server: RetrofitServer): Retrofit {
        return Retrofit.Builder()
            .baseUrl(
                when (server) {
                    RetrofitServer.STUDIO_GHIBLI -> STUDIO_GHIBLI_URL
                }
            )
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .cache(Cache(context.cacheDir, CACHE_SIZE))
            .apply {
                if (BuildConfig.DEBUG) {
                    val loggingInterceptor = HttpLoggingInterceptor().setLevel(Level.BODY)
                    addInterceptor(loggingInterceptor)
                }
            }.build()
    }

    companion object {

        private const val STUDIO_GHIBLI_URL = "https://ghibliapi.herokuapp.com/"
        private const val TIMEOUT = 15L
        private const val CACHE_SIZE = 10L * 1024 * 1024 // 10MB
    }
}
