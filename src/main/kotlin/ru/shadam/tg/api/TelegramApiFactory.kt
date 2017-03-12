package ru.shadam.tg.api

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import okhttp3.Interceptor
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
        private val objectMapper:ObjectMapper? = ObjectMapper().registerKotlinModule().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false),
        private val httpClient: OkHttpClient = createLoggingClient()
) {
    fun createApi(token: String, baseUrl: String) : TelegramApi =
        Retrofit.Builder()
        .addConverterFactory(JacksonConverterFactory.create(objectMapper))
        .baseUrl("$baseUrl/bot$token/")
        .client(httpClient)
        .build()
        .create(TelegramApi::class.java)
}

fun createLoggingClient(interceptors: List<Interceptor> = listOf()): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor({
        message -> logger.info(message)
    }).apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    val builder = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)

    interceptors.forEach { builder.addInterceptor(it) }

    return builder
            .build()
}