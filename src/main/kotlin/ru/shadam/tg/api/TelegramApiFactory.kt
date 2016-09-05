package ru.shadam.tg.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

/**
 * @author sala
 */
private val logger : Logger = LoggerFactory.getLogger("telegramApi")

class TelegramApiFactory(
        private val objectMapper:ObjectMapper? = ObjectMapper().registerKotlinModule(),
        private val httpClient: OkHttpClient = createLoggingClient()
) {
    fun createApi(token: String) : TelegramApi = Retrofit.Builder()
        .addConverterFactory(JacksonConverterFactory.create(objectMapper))
        .baseUrl("https://api.telegram.org/bot$token/")
        .client(httpClient)
        .build()
        .create(TelegramApi::class.java)
}

internal fun createLoggingClient(): OkHttpClient {
    return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor({ message -> logger.info(message) }).apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()
}