package ru.shadam.tg.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author sala
 */
internal interface InternalTelegramFileApi {
    @GET("/file/bot{token}/{file_path}")
    fun downloadFile(
            @Path("token") token: String,
            @Path("file_path") filePath: String
    ) : Call<ResponseBody>
}

internal fun createInternalTelegramFileApi(client: OkHttpClient = createLoggingClient(), baseUrl: String) =
        Retrofit.Builder()
        .addConverterFactory(JacksonConverterFactory.create(ObjectMapper().registerKotlinModule()))
        .baseUrl(baseUrl)
        .client(client)
        .build()
        .create(InternalTelegramFileApi::class.java)

interface TelegramFileApi {
    fun downloadFile(filePath: String) : Array<Byte>
}

internal class DefaultTelegramFileApi(private val api : InternalTelegramFileApi, private val token: String) : TelegramFileApi {
    override fun downloadFile(filePath: String): Array<Byte> = api.downloadFile(token, filePath).execute().body().bytes().toTypedArray()
}

fun createTelegramFileApi(token: String, baseUrl: String) : TelegramFileApi =
        DefaultTelegramFileApi(createInternalTelegramFileApi(baseUrl = baseUrl), token)
